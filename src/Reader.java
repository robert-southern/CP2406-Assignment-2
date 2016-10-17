import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

// Reader will return an array containing the contents of the csv file in line by line format.

public interface Reader {

    ArrayList readFile(String fileName);

}


//class XMLReader implements Reader {
//
//    public ArrayList readFile(String filename) {
//
//        try {
//            File deckList = new File(filename);
//
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//
//            org.w3c.dom.Document document = documentBuilder.parse(new File("DeckList.xml"));
//
//            // normalise text representation:
//            document.getDocumentElement().normalize();
//            System.out.println("Root: " + document.getDocumentElement().getNodeName());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


class CSVReader implements Reader {

    public CSVReader() {

    }

    public ArrayList readFile(String fileName) {

        ArrayList deckList = new ArrayList();

        String line = "";
        int lineNumber = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {

                deckList.add(lineNumber, line);

                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deckList;
    }

}

class ImageReader implements Reader {

    public ImageReader() {

    }

    public ArrayList readFile(String fileName) {

        ArrayList image = new ArrayList();


            try {
                BufferedImage tempImg = ImageIO.read(new File(fileName));

                JLabel labelImg = new JLabel(new ImageIcon(tempImg));
                image.add(labelImg);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return image;
    }
}