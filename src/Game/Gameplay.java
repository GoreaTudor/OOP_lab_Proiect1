package Game;

import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    private Player player;
    private Enemy enemy;

    public Gameplay () {
        this.player = null;
        this.enemy = null;
    }

    public void setupMenu(){
        System.out.println("Please choose the difficulty: ");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Impossible");

        Scanner input = new Scanner(System.in);
        int option;
        do{
            System.out.print("Your option: ");
            option = input.nextInt();
            if (option < 1 || option > 4)
                System.out.println("Invalid value!");
        } while (option < 1 || option > 4);

        Difficulty difficulty = Difficulty.Easy;
        System.out.print("Game difficulty is set to ");
        switch (option) {
            case 1:
                difficulty = Difficulty.Easy;
                System.out.println("Easy, with minimum effort you can win, for casual players");
                break;
            case 2:
                difficulty = Difficulty.Medium;
                System.out.println("Medium, a slight challenge, for normal players");
                break;
            case 3:
                difficulty = Difficulty.Hard;
                System.out.println("Hard, a challenging fight, recommended for experienced players.");
                break;
            case 4:
                difficulty = Difficulty.Impossible;
                System.out.println("Impossible, YOU WON'T SURVIVE!");
                break;
        }

        this.player = new Player();
        this.enemy = new Enemy(difficulty);

        player.resetScore();
        System.out.println("\n");
    }

    public void gameMenu(){
        Scanner input = new Scanner(System.in);
        Options playerOption;
        Options enemyOption;
        boolean validInput;
        boolean ok;
        Random rnd;
        String s;
        int opt;

        while (true) {
            System.out.println("A new enemy arrived");
            enemy.resetCurrentHP();
            player.resetCurrentHP();
            ok = true;

            while (enemy.isAlive() && player.isAlive() && ok) {
                System.out.println("\nStats:");
                System.out.println("    Score: " + player.getScore());
                System.out.println("    Player HP: " + player.getCurrentHP() + " <-");
                System.out.println("    Enemy HP: " + enemy.getCurrentHP());

                System.out.println("\nPlease choose an action:");
                System.out.println("(a)ttack  /  (d)efend  /  (r)un  /  (0) exit");

                System.out.print("Your option: ");
                s = input.next();
                playerOption = Options.none;
                validInput = true;

                switch (s) {
                    case "a":
                        System.out.println("Player choice: ATTACK");
                        playerOption = Options.attack;
                        break;

                    case "d":
                        System.out.println("Player choice: DEFEND");
                        playerOption = Options.defend;
                        break;

                    case "r":
                        System.out.println("Player choice: RUN");
                        playerOption = Options.none;
                        ok = false;
                        break;

                    case "0":
                        System.out.println("Player choice: EXIT");
                        playerOption = Options.none;
                        return;

                    default:
                        playerOption = Options.none;
                        System.out.println("Invalid input!");
                        validInput = false;
                } // switch case

                if (validInput) {
                    rnd = new Random();

                    opt = rnd.nextInt(2);
                    if (opt == 1) {
                        System.out.println("Enemy choice: ATTACK");
                        enemyOption = Options.attack;
                    } else {
                        System.out.println("Enemy choice: DEFEND");
                        enemyOption = Options.defend;
                    }


                    if (playerOption == Options.defend && enemyOption == Options.defend) {
                        player.incCurrentHP();
                        enemy.incCurrentHP();

                    } else if (playerOption == Options.defend && enemyOption == Options.attack) {
                        player.setCurrentHP(player.getCurrentHP() - (enemy.getBaseDMG() / 2.0));

                    } else if (playerOption == Options.attack && enemyOption == Options.defend) {
                        enemy.setCurrentHP(enemy.getCurrentHP() - (player.getDmg() / 2.0));

                    } else if (playerOption == Options.attack && enemyOption == Options.attack) {
                        player.setCurrentHP(player.getCurrentHP() - enemy.getBaseDMG());
                        enemy.setCurrentHP(enemy.getCurrentHP() - player.getDmg());
                    }

                } // if validInput
            } // while player.isAlive && enemy.isAlive && ok


            System.out.println("\n");
            if(!player.isAlive() && !enemy.isAlive()) { // both died
                System.out.println("TIE - This battle left no one alive");

                System.out.println("Do you want to try again?");
                System.out.println("Press Y to continue, press any other key to exit...");
                System.out.print("-> ");
                s = input.next();
                if (s.contentEquals("y") == false)
                    return;

            } else if(!player.isAlive()) { // player died
                System.out.println("MISSION FAILED - we'll get em next time.");
                player.resetScore();

                System.out.println("Do you want to try again?");
                System.out.println("Press Y to continue, press any other key to exit...");
                System.out.print("-> ");
                s = input.next();
                if (s.contentEquals("y") == false)
                    return;

            } else if (!enemy.isAlive()) { // enemy died
                System.out.println("VICTORY! - You are a beast!");
                player.incScore();

            } else { // player ran
                System.out.println("UNWORTHY - you ran from the enemy.");
                player.incCurrentHP();
                player.decScore(); //this is used for punishment
            }


            if (player.getScore() > 0 && player.getScore() % 4 == 0) {
                player.upgrade();
                System.out.println("\nA new upgrade available!");
                System.out.println("Base Health increased: " + player.getBaseHP());
                System.out.println("Damage increased: " + player.getDmg());
            }

        } // main game
    }
}
