import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {

    private JPanel panelMain;
    private JPanel aiPanel1;
    private JPanel aiPanel2;
    private JPanel aiPanel3;
    private JPanel aiPanel4;
    private JPanel cardPlayedPanel;
    private JPanel deckPanel;
    private JPanel humanPanel;
    private JButton passTurnButton;
    private JLabel aiLabel2;
    private JLabel aiLabel1;
    private JLabel aiLabel3;
    private JLabel aiLabel4;
    private JPanel emptyPanel;
    private JLabel deckLabel;

    public MainGUI() {
        passTurnButton.addActionListener(this);
        passTurnButton.setToolTipText("Click to Pass!");
        aiLabel1.setVisible(false);
        aiLabel4.setVisible(false);
    }

    public MainGUI(int numPlayers) {
        passTurnButton.addActionListener(this);
        passTurnButton.setToolTipText("Click to Pass!");
        aiLabel1.setVisible(false);
        aiLabel4.setVisible(false);

    }

    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanels(int numberOfPlayers) {


    }

}


