import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static boolean playAgain = true;

    public static void main(String[] args) {



            Main main = new Main();
            main.displayWelcome();
            main.pauseTwoSeconds();

            Menu menu = new Menu();
            menu.displayMenu();

            // Keep menu going while 'Play' is not selected.
            // Maybe not needed - Handled by Menu Class.
//        while (!menu.isChoosePlay()) {
//            menu.displayMenu();
//        }

        while (playAgain) {

            System.out.println(" ");
            System.out.println("Starting new game...");
            System.out.println(" ");
            main.pauseTwoSeconds();

            Scanner in = new Scanner(System.in);


        /* TODO:
        Fix bug whereby the user input is checked whether its an int and then checked whether its between
        3 and 5 inclusive. The input is not checked again whether its an int or not.
        */
            int numPlayers = 0;
            System.out.print("Enter the number of players: ");
            while (!in.hasNextInt()) {
                System.out.println("Invalid! Must be an integer!");
                System.out.print("Enter the number of players: ");
                in.next();
            }

            numPlayers = in.nextInt();
            while (numPlayers < 3 || numPlayers > 5) {
                System.out.println("Invalid! Must be 3 to 5 players!");
                System.out.println("Enter the number of players: ");
                numPlayers = in.nextInt();
            }

            Game game = new Game(numPlayers);

            game.initialise("J:/CORSAIR USB 25-8-16/CP2406/2406 Assign1/Assignment 1/DeckList.csv",
                    "J:/CORSAIR USB 25-8-16/CP2406/2406 Assign1/mst master/mst master/images/slide");

            for (int i = 0; i < game.getPlayers().length; i++) {
                if (game.getPlayers()[i].isDealer()) {

                    if (game.getPlayers()[i].isHuman()) {
                        System.out.println(" ");
                        System.out.println("You are the dealer!");
                        System.out.println(" ");
                        if (i == numPlayers - 1) {
                            System.out.println(game.getPlayers()[0].getName() + " plays first.");

                        } else {
                            System.out.println(game.getPlayers()[i + 1].getName() + " plays first.");
                        }


                    } else {
                        System.out.println(" ");
                        System.out.println(game.getPlayers()[i].getName() + " is the dealer!");
                        System.out.println(" ");
                        if (i == numPlayers - 1) {
                            System.out.println(game.getPlayers()[0].getName() + " plays first.");

                        } else {
                            System.out.println(game.getPlayers()[i + 1].getName() + " plays first.");
                        }
                    }
                }
            }

            main.pauseTwoSeconds();
            System.out.println(" ");
            System.out.println("The cards are being dealt...");
            System.out.println(" ");
            main.pauseTwoSeconds();

            System.out.println(" ");
            System.out.println("YOUR CARDS >>");
            System.out.println(" ");
            game.showPlayerHand();
            main.pauseTwoSeconds();

            game.play();
            System.out.println(" ");
            System.out.println("The winner is " + game.getWinner() + "!");

            System.out.println(" ");
            main.pauseTwoSeconds();

            System.out.println("Would you like to play again?");
            main.pauseTwoSeconds();
            menu.displayMenu();

            if (menu.isChoosePlay()) {
                playAgain = true;
            } else {
                playAgain = false;
            }

        }
    }


    public void displayWelcome() {

        System.out.println("Welcome to Mineral Supertrumps!\n" +
                "------------------------------------------\n");
    }

    public void pauseTwoSeconds() {

        try {
            Thread.sleep(2000); //Pause for 2000 ms.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}


