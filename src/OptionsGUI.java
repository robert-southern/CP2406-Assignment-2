import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsGUI extends JDialog implements ActionListener {

    private JPanel panelOptions;
    private JComboBox numPlayers;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel playersLabel;
    private int numPlayersIndex = 0;

    private int numberOfPlayers = 3;

    public OptionsGUI() {

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        this.setContentPane(panelOptions);
        this.setTitle("Options");

        this.setSize(400,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == okButton) {
            numberOfPlayers = Integer.parseInt(this.numPlayers.getSelectedItem().toString());
            numPlayersIndex = numPlayers.getSelectedIndex();
            this.dispose();
        }

        if (e.getSource() == cancelButton) {
            numPlayers.setSelectedIndex(numPlayersIndex);
            this.dispose();
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

}
