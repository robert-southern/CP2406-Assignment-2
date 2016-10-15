import java.util.Scanner;

public class Menu {

    private boolean choosePlay = false;

    public Menu() {

    }

    public void displayMenu() {

        Scanner in = new Scanner(System.in);

        System.out.println("------ Main Menu ------\n" +
                "1. Play\n" +
                "2. Rules\n" +
                "3. Exit");
        System.out.println("-----------------------");

        System.out.print("Enter menu item number: ");
        while (!in.hasNextInt()) {
            System.out.println("Invalid Input! Pick an option from the list using the corresponding integer.");
            System.out.print("Enter menu item number: ");
            in.next();
        }
        int userChoice = in.nextInt();

        switch (userChoice) {
            case 1:
                this.choosePlay = true;
                break;
            case 2:
                displayRules();
                displayMenu();
                break;
            case 3:
                System.out.println("");
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    private void displayRules() {

        System.out.println(" ");
        System.out.println("------ Rules ------\n" +
                ">> 1. Play a card and select a category.\n" +
                ">> 2. Player to the left must play a card with a higher value in the selected category\n" +
                ">> 3. When the next player can't play, he picks up a card from the deck and passes his turn.\n" +
                ">> 4. If a player has passed, he may not play until all but one player has passed.\n" +
                ">> 5. A player may use a supertrump card at any of their turns; the player changes the\n" +
                "      trump category according to the instructions on the supertrump card. Any player who\n" +
                "      previously passed his turn may play again.\n" +
                ">> 6. Playing the Geophysicist card together with the Magnetite card wins that player the hand.\n" +
                ">> 7. When all but one player has passed his turn, the remaining player gets to lead out the\n" +
                "      next round and chooses the next trump category.\n" +
                ">> 8. The Winner of the game is the first player to lose all of their cards.\n" +
                ">> 9. The game continues until all but one player (the loser) has lost their cards.");
        System.out.println(" ");
    }

    public boolean isChoosePlay() {
        return choosePlay;
    }

}
