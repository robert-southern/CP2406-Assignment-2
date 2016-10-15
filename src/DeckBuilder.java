import java.util.ArrayList;

public class DeckBuilder {

    public DeckBuilder() {

    }


    public Deck buildDeck(String fileName) {

        Deck newDeck = new Deck();

        Reader fileReader = new CSVReader();

        ArrayList<String> deckList = fileReader.readFile(fileName);

        String sc = ",";

        for (int i = 0; i < deckList.size(); i++) {

            String[] tempCardData = deckList.get(i).split(sc);

            if (tempCardData.length != 1) {
                String name = tempCardData[0];
                Double hardness = Double.parseDouble(tempCardData[1]);
                Double specificGravity = Double.parseDouble(tempCardData[2]);
                Integer cleavage = Integer.parseInt(tempCardData[3]);
                Integer crustalAbundance = Integer.parseInt(tempCardData[4]);
                Integer economicValue = Integer.parseInt(tempCardData[5]);

                Card cardInfo = new Card(name, hardness, specificGravity,
                        cleavage, crustalAbundance, economicValue);
                newDeck.addCard(cardInfo);

            } else {

                Card cardInfo = new Card(tempCardData[0]);
                cardInfo.setSuperTrumpCard(true);
                newDeck.addCard(cardInfo);
            }
        }

        return newDeck;
    }

}
