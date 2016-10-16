import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI implements ActionListener {

    private JMenuItem newGame = new JMenuItem("New Game");
    private JMenuItem options = new JMenuItem("Options");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem viewHelp = new JMenuItem("View Help");


    public GameGUI() {
        newGame.addActionListener(this);
        options.addActionListener(this);
        exit.addActionListener(this);
        viewHelp.addActionListener(this);

    }

    public void run() {

        JFrame frame = new JFrame("Mineral Super Trumps");
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("Game");
        JMenu menu2 = new JMenu("Help");

        menu1.add(newGame);
        menu1.addSeparator();
        menu1.add(options);
        menu1.addSeparator();
        menu1.add(exit);

        menu2.add(viewHelp);

        menuBar.add(menu1);
        menuBar.add(menu2);

        frame.setJMenuBar(menuBar);

        frame.setContentPane(new MainGUI().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            //todo: start new game
        }
        if (e.getSource() == options) {
            //todo: display options
            // need to make default options (obviously).
        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == viewHelp) {
            //todo: view help
            //Rules of the game, strategy, and such.
        }

    }
}
