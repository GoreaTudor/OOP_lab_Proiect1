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
    }

    public void gameMenu(){
        System.out.println("A new enemy arrived");
        boolean ok = true;
        boolean valid;

        while (enemy.isAlive() && player.isAlive() && ok){
            System.out.println("Stats:");
            System.out.println("Player HP: ");

            System.out.println("Please choose an action:");
            System.out.println("a - attack");
            System.out.println("d - defend");
            System.out.println("0 - exit");

            Scanner input = new Scanner(System.in);
            System.out.print("Your option: ");
            String s = input.next();
            Options playerOption = Options.none;
            valid = true;

            switch (s) {
                case "a":
                    playerOption = Options.attack;
                    break;
                case "d":
                    playerOption = Options.defend;
                    break;
                case "0":
                    playerOption = Options.none;
                    ok = false;
                    break;
                default:
                    playerOption = Options.none;
                    System.out.println("Invalid input!");
                    valid = false;
            }

            if (valid) {
                Random rnd = new Random();
                Options enemyOption;

                int opt = rnd.nextInt(2);

                if(opt == 1)
                    enemyOption = Options.attack;
                else
                    enemyOption = Options.defend;


                if (playerOption == Options.attack && enemyOption == Options.attack) {
                    ;
                } else if (playerOption == Options.defend && enemyOption == Options.attack) {
                    ;
                } else if (playerOption == Options.attack && enemyOption == Options.defend) {
                    ;
                } else if (playerOption == Options.defend && enemyOption == Options.defend) {
                    ;
                }

            }

        }
    }
}
