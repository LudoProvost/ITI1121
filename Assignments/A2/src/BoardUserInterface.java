import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BoardUserInterface extends JPanel {

    private GameState gameState;
    private GameLogic gameLogic;

    private Cube[][] cubeBoard;

    public BoardUserInterface(GameState gameState, GameLogic gameLogic) {
        super(new FlowLayout());
        this.setPreferredSize(new Dimension(gameState.getSize() * 50, gameState.getSize() * 50));


        this.gameState = gameState;
        this.gameLogic = gameLogic;

        cubeBoard = new Cube[gameState.getSize()][gameState.getSize()];

        for (int y = 0; y < gameState.getSize(); y++) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));

            if (y % 2 == 1) {
                rowPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
            }

            for (int x = 0; x < gameState.getSize(); x++) {
                cubeBoard[y][x] = new Cube(y, x, gameState.getCurrentStatus(x, y));
                cubeBoard[y][x].addActionListener(gameLogic);
                rowPanel.add(cubeBoard[y][x]);
            }

            this.add(rowPanel);
        }

    }

    //updates the status of the board's cubes instances following the game state
    //calls setType() from the class Cube, as needed.
    public void update() {
        for (int x = 0; x < gameState.getSize(); x++) {
            for (int y = 0; y < gameState.getSize(); y++) {
                cubeBoard[y][x].setType(gameState.getCurrentStatus(x, y));
            }
        }
    }

}
