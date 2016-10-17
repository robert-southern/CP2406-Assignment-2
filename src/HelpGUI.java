import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpGUI extends JDialog implements ActionListener {
    private JPanel helpPanel;
    private JButton okButton;
    private JTextArea helpTextArea;


    public HelpGUI() {

        okButton.addActionListener(this);
        helpTextArea.setEditable(false);

        this.setContentPane(helpPanel);
        this.setTitle("Help");
        this.setSize(550,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == okButton) {
            this.dispose();
        }
    }
}
