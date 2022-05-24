import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 /*the class GameUserInterface provides the user interface of the Game. It extends
 JFrame and lays out an instance of BoardUserInterface and  two instances of JButton: one to reset and the second the quit the game at any time.*/

public class GameUserInterface extends JFrame {

    private JButton reset;
    private JButton quit;
    private GameState state;
    private GameLogic gameLogic;
    private BoardUserInterface boardUserInterface;


    /* Constructor
     * initializes the board
     * takes as parameters the state of the game and the gameLogic */

    public GameUserInterface(GameState state, GameLogic gameLogic) {
        super("Catch the mouse");
        this.setLayout(new GridBagLayout());

        this.state = state;
        this.gameLogic = gameLogic;

        boardUserInterface = new BoardUserInterface(state, gameLogic);

        GridBagConstraints boardConstraints = new GridBagConstraints();
        boardConstraints.gridheight = state.getSize();
        boardConstraints.gridx = 0;
        boardConstraints.gridy = 0;
        boardConstraints.fill = GridBagConstraints.HORIZONTAL;
        boardConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(boardUserInterface, boardConstraints);

        this.reset = new JButton("Reset");
        this.reset.addActionListener(this.gameLogic);

        this.quit = new JButton("Quit");
        this.quit.addActionListener(this.gameLogic);


        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.add(this.reset);
        buttonsPanel.add(this.quit);

        GridBagConstraints buttonsConstraints = new GridBagConstraints();
        buttonsConstraints.gridx = 0;
        buttonsConstraints.gridy = state.getSize() + 1;
        buttonsConstraints.anchor = GridBagConstraints.CENTER;
        this.add(buttonsPanel, buttonsConstraints);


        this.setVisible(true);
        this.setSize((state.getSize() * 50 + 50), (state.getSize() * 60) + 60);
        this.setResizable(false);

    }


    public JButton getReset() {
        return this.reset;
    }

    public JButton getQuit() {
        return this.quit;
    }

    public BoardUserInterface getBoardUserInterface() {
        return this.boardUserInterface;
    }

}
