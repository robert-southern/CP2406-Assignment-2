import java.util.ArrayList;
import java.util.Random;

public class Game {

    private boolean gameIsOver = false;
    private int numberOfPlayers;
    private Player[] players;
    private Deck gameDeck;
    private int firstPlayerIndex = 0;
    private String winner = "";
    private String roundWinner = "";


    public Game(int numberOfPlayers) {

        this.numberOfPlayers = numberOfPlayers;
        this.players = new Player[numberOfPlayers];
    }

    public void initialise(String fileName, String fileNameImg) {

        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player();
        }

        pickHuman();
        pickDealer();
        setNamesAndDisplay();
        DeckBuilder deckBuilder = new DeckBuilder();
        this.gameDeck = deckBuilder.buildDeck(fileName, fileNameImg);
        dealHands();
    }


    public void play() {

        while(!this.gameIsOver) {
            playRound();
            System.out.println(" ");
            System.out.println(this.roundWinner + " won the round!");
        }

        for (int i = 0; i < players.length; i++) {

            if (players[i].getHand().size() == 0) {
                this.gameIsOver = true;
                this.winner = players[i].getName();
            }
        }
    }


    public void playRound() {

        int playersLeft = numberOfPlayers - 1;
        boolean roundOver = false;
        String trumpCategory = "";
        int categoryIndex = 0;
        double categoryValue = 0;
        String categoryValueName = "";
        double tempValue = 0;

            GameMenu gameMenu = new GameMenu();
            int nextPlayerIndex = firstPlayerIndex;

            if (players[firstPlayerIndex].isHuman()) {
                System.out.println(" ");
                System.out.println("It's your turn!");
                System.out.println(" ");
                System.out.println("YOUR CARDS >>");
                showPlayerHand();
                pauseTwoSeconds();
                gameMenu.displayMenu(false);
                if (gameMenu.isPlayCard()) {
                    String[] tempChoice = gameMenu.getCardChoice().split(",");
                    trumpCategory = tempChoice[1];
                    categoryValue = Double.parseDouble(tempChoice[2]);
                    categoryIndex = returnTrumpIndex(trumpCategory);

                    for (int z = 0; z < players[nextPlayerIndex].getHand().size(); z++) {
                        if (tempChoice[0].equals(players[nextPlayerIndex].getHand().get(z).getName())) {
                            players[nextPlayerIndex].getHand().remove(z);
                        }
                    }

                    if (firstPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }
                } else {
                    players[firstPlayerIndex].giveCard(gameDeck.getNextCard());
                    if (firstPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }
                }

            } else {


                Card cardPlayed = pickRandCard(firstPlayerIndex);
                while (cardPlayed.isSuperTrumpCard()) {
                    cardPlayed = pickRandCard(firstPlayerIndex);
                }

                pauseTwoSeconds();
                System.out.println(" ");
                System.out.println("It's " + players[firstPlayerIndex].getName() + "'s turn!");
                pauseTwoSeconds();
                System.out.println(" ");
                System.out.println(players[firstPlayerIndex].getName() + " played:");
                cardPlayed.displayCard();
                trumpCategory = pickCategory();
                categoryIndex = returnTrumpIndex(trumpCategory);
                categoryValue = returnTrumpValue(trumpCategory, cardPlayed);
                System.out.println(players[firstPlayerIndex].getName() + " picked " + trumpCategory + " at "
                + categoryValue+ ".");

                for (int z = 0; z < players[nextPlayerIndex].getHand().size(); z++) {
                    if (cardPlayed == players[nextPlayerIndex].getHand().get(z)) {
                        players[nextPlayerIndex].getHand().remove(z);
                    }
                }

                if (firstPlayerIndex == 4) {
                    nextPlayerIndex = 0;
                } else {
                    nextPlayerIndex++;
                }
            }

        while (!roundOver) {

            if (players[nextPlayerIndex].isHuman()) {

                System.out.println(" ");
                System.out.println("It's your turn!");
                System.out.println(" ");
                System.out.println("The trump is " + trumpCategory + " at " + categoryValue + ".");
                System.out.println(" ");
                System.out.println("YOUR CARDS >>");
                showPlayerHand();
                pauseTwoSeconds();

                gameMenu.displayMenu(!canPlay(nextPlayerIndex, categoryIndex, categoryValue));

                if (gameMenu.isPlayCard()) {
                    String[] tempChoice = gameMenu.getCardChoice().split(",");
                    trumpCategory = tempChoice[1];
                    categoryValue = Double.parseDouble(tempChoice[2]);

                    for (int z = 0; z < players[nextPlayerIndex].getHand().size(); z++) {
                        if (tempChoice[0].equals(players[nextPlayerIndex].getHand().get(z).getName())) {
                            players[nextPlayerIndex].getHand().remove(z);
                        }
                    }

                    if (nextPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }
                } else {
                    players[nextPlayerIndex].setCanPlay(false);
                    players[nextPlayerIndex].giveCard(gameDeck.getNextCard());
                    if (nextPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }
                }

            } else {

                if (canPlay(nextPlayerIndex, categoryIndex, categoryValue)) {

                    Card cardPlayed = pickRandCard(nextPlayerIndex, categoryIndex, categoryValue);
                    pauseTwoSeconds();
                    System.out.println(" ");
                    System.out.println("It's " + players[nextPlayerIndex].getName() + "'s turn!");
                    pauseTwoSeconds();
                    System.out.println(" ");
                    System.out.println("The trump is " + trumpCategory + " at " + categoryValue + ".");
                    System.out.println(" ");
                    System.out.println(players[nextPlayerIndex].getName() + " played:");
                    cardPlayed.displayCard();

                    for (int z = 0; z < players[nextPlayerIndex].getHand().size(); z++) {
                        if (cardPlayed == players[nextPlayerIndex].getHand().get(z)) {
                            players[nextPlayerIndex].getHand().remove(z);
                        }
                    }

                    categoryValue = returnTrumpValue(trumpCategory, cardPlayed);
                    if (nextPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }

                } else {
                    players[nextPlayerIndex].setCanPlay(false);
                    players[nextPlayerIndex].giveCard(gameDeck.getNextCard());
                    pauseTwoSeconds();
                    System.out.println(" ");
                    System.out.println(players[nextPlayerIndex].getName() + " has passed!");
                    if (nextPlayerIndex == 4) {
                        nextPlayerIndex = 0;
                    } else {
                        nextPlayerIndex++;
                    }
                }
            }

            for (int x = 0; x < numberOfPlayers; x++) {
                if (!players[x].isCanPlay()) {
                    playersLeft--;
                }
            }

            if (playersLeft == 1) {
                for (int k = 0; k < numberOfPlayers; k++) {
                    if (players[k].isCanPlay()) {
                        this.roundWinner = players[k].getName();
                        firstPlayerIndex = k;
                        roundOver = true;
                    }
                }
            }
        }
    }

    public boolean canPlay(int playerIndex, int trumpIndex, double currentTrumpValue) {

        boolean canPlay = false;

        for (int i = 0; i < players[playerIndex].getHand().size(); i++) {

            if (!players[playerIndex].getHand().get(i).isSuperTrumpCard()) {
                if (currentTrumpValue <= (players[playerIndex].getHand().get(i).getValues()[trumpIndex])) {
                    canPlay = true;
                    break;
                }
            }
        }
        return canPlay;
    }


    public int returnTrumpIndex(String trumpCategory) {

        int trumpIndex = 0;

        switch (trumpCategory) {
            case "Hardness":
                trumpIndex = 0;
                break;
            case "Specific Gravity":
                trumpIndex = 1;
                break;
            case "Cleavage":
                trumpIndex = 2;
                break;
            case "Crustal Abundance":
                trumpIndex = 3;
                break;
            case "Economic Value":
                trumpIndex = 4;
                break;
        }
        return trumpIndex;
    }


    public Card pickRandCard(int playerIndex) {

        int randNum = new Random().nextInt(players[playerIndex].getHand().size());

        return players[playerIndex].getHand().get(randNum);
    }

    public Card pickRandCard(int playerIndex, int trumpIndex, double trumpValue) {

        ArrayList<Card> tempValidCards = new ArrayList();

        for (int i = 0; i < players[playerIndex].getHand().size(); i++) {

            if (!players[playerIndex].getHand().get(i).isSuperTrumpCard()) {
                if (players[playerIndex].getHand().get(i).getValues()[trumpIndex] >= trumpValue) {

                    tempValidCards.add(players[playerIndex].getHand().get(i));
                }
            }
        }
        int randNum = new Random().nextInt(tempValidCards.size());

        return tempValidCards.get(randNum);

    }


    public String pickCategory() {

        int randInt = new Random().nextInt(5);
        String category = "";

        switch (randInt) {
            case 0:
                category = "Hardness";
                break;
            case 1:
                category = "Specific Gravity";
                break;
            case 2:
                category = "Cleavage";
                break;
            case 3:
                category = "Crustal Abundance";
                break;
            case 4:
                category = "Economic Value";
                break;
        }
        return category;
    }

    public double returnTrumpValue(String trump, Card cardPlayed) {

        double trumpVal = 0;

        if (trump.equals("Hardness")) {
            trumpVal = cardPlayed.getHardness();
        } else if (trump.equals("Specific Gravity")) {
            trumpVal = cardPlayed.getSpecificGravity();
        } else if (trump.equals("Cleavage")) {
            trumpVal = cardPlayed.getCleavage();
        } else if (trump.equals("Crustal Abundance")) {
            trumpVal = cardPlayed.getAbundance();
        } else if (trump.equals("Economic Value")) {
            trumpVal = cardPlayed.getEconValue();
        }

        return trumpVal;
    }

    public void returnCardByName (int index, String cardName) {

        for (int i = 0; i < players[index].getHand().size(); i++) {
            if (players[index].getHand().get(i).getName().equals("cardName")) {

            }
        }
    }



    public void pickHuman() {
        this.players[new Random().nextInt(numberOfPlayers)].setHuman(true);
    }

    public void pickDealer() {
        int randInt = new Random().nextInt(numberOfPlayers);
        this.players[randInt].setDealer(true);
        if (randInt == numberOfPlayers - 1) {
            this.firstPlayerIndex = 0;
        } else {
            this.firstPlayerIndex = randInt + 1;
        }

    }



    public void setNamesAndDisplay() {

        StringBuffer playersList = new StringBuffer();
        int aiCount = 1;

        for (int i = 0; i < players.length; i++) {

            if (!players[i].getName().equals("Player")) {
                if (players[i].isDealer()) {
                    players[i].setName("AI " + (aiCount));
                    players[i].setTempName("AI " + (aiCount) + "(dealer)");
                    aiCount++;
                }
                else {
                    players[i].setName("AI " + (aiCount));
                    players[i].setTempName("AI " + (aiCount));
                    aiCount++;
                }
            }
            else {
                if(players[i].isDealer()) {
                    players[i].setName("Player");
                    players[i].setTempName("Player(dealer)");
                }
            }

//            if (!Character.isSpaceChar(playersList.charAt(playersList.length() - 1))) {
//                playersList.append(players[i].getName() + " -> ");
//            }

            playersList.append(players[i].getTempName() + " -> ");

        }

        playersList.delete(playersList.length() - 3, playersList.length() - 1);
        System.out.println("----------------------------------------------------------------");
        System.out.print("Play Order:    ");
        System.out.print(playersList + "\n");
        System.out.println("----------------------------------------------------------------");
    }

    public void dealHands() {
        this.gameDeck.shuffleDeck();

        for (int i = 0; i < players.length; i++) {

            for (int j = 0; j < 8; j++) {
                this.players[i].giveCard(this.gameDeck.getNextCard());
            }
        }
    }

    public void showPlayerHand() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].isHuman()) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    System.out.println(j + 1);
                    players[i].getHand().get(j).displayCard();
                }
            }
        }

    }


    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getWinner() {
        return winner;
    }

    public void pauseTwoSeconds() {

        try {
            Thread.sleep(2000); //Pause for 2000 ms.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
