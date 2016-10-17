import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private int numPlayers = 3;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Game");
    private JMenu menu2 = new JMenu("Help");
    private JMenuItem newGame = new JMenuItem("New Game");
    private JMenuItem options = new JMenuItem("Options");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem viewHelp = new JMenuItem("View Help");


    public GameGUI() {

        this.setTitle("Mineral Super Trumps");

        newGame.addActionListener(this);
        options.addActionListener(this);
        exit.addActionListener(this);
        viewHelp.addActionListener(this);

        menu1.add(newGame);
        menu1.addSeparator();
        menu1.add(options);
        menu1.addSeparator();
        menu1.add(exit);

        menu2.add(viewHelp);

        menuBar.add(menu1);
        menuBar.add(menu2);

        this.setContentPane(new MainGUI().getPanelMain());
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,900);
        this.setMinimumSize(new Dimension(600,300));
        this.setResizable(false); //todo: change this to resisable in future.
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newGame) {
            setContentPane(new MainGUI(numPlayers).getPanelMain());
        }
        if (e.getSource() == options) {
            OptionsGUI optionsGUI = new OptionsGUI();
        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == viewHelp) {
            new HelpGUI();
        }

    }
}
