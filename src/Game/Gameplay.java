package Game;

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


}
