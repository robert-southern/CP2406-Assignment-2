import javax.swing.*;
import java.util.ArrayList;

public class DeckBuilder {

    public DeckBuilder() {

    }


    public Deck buildDeck(String fileNameCSV, String fileNameImg) {

        Deck newDeck = new Deck();

        Reader fileReader = new CSVReader();
        Reader imageReader = new ImageReader();

        ArrayList<String> deckList = fileReader.readFile(fileNameCSV);

        ArrayList<JLabel> imageList = new ArrayList();
        for (int j = 0; j < deckList.size(); j++) {

            ArrayList<JLabel> image = imageReader.readFile(fileNameImg);

            imageList.add(image.get(0));
        }
        String sc = ",";

        for (int i = 0; i < deckList.size(); i++) {

            String[] tempCardData = deckList.get(i).split(sc);
            JLabel tempLabelImage = imageList.get(i);

            if (tempCardData.length != 1) {
                String name = tempCardData[0];
                Double hardness = Double.parseDouble(tempCardData[1]);
                Double specificGravity = Double.parseDouble(tempCardData[2]);
                Integer cleavage = Integer.parseInt(tempCardData[3]);
                Integer crustalAbundance = Integer.parseInt(tempCardData[4]);
                Integer economicValue = Integer.parseInt(tempCardData[5]);

                Card cardInfo = new Card(name, hardness, specificGravity,
                        cleavage, crustalAbundance, economicValue);
                cardInfo.setImage(tempLabelImage);
                newDeck.addCard(cardInfo);

            } else {

                Card cardInfo = new Card(tempCardData[0]);
                cardInfo.setSuperTrumpCard(true);
                cardInfo.setImage(tempLabelImage);
                newDeck.addCard(cardInfo);
            }
        }

        return newDeck;
    }

}
