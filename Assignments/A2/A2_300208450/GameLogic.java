import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.*;

//This class implements the interface ActionListener so that it is called when the player makes a move. 
//It calculates the next step of the game
//It updates state and userInterface.


public class GameLogic implements ActionListener {

    // ADD YOUR INSTANCE VARIABLES HERE
    private GameState gameState;
    private GameUserInterface gameUserInterface;


    //The parameter size is the size of the board on which the game will be played
    public GameLogic(int size) {
        // It creates the game's userInterface and the game's state instances

        gameState = new GameState(size);
        gameUserInterface = new GameUserInterface(gameState, this);

    }


    /**
     * Starts the game
     */
    public void start() {

    }


    /**
     * resets the game
     */
    public void reset() {
        gameState = new GameState(gameState.getSize());
        gameUserInterface.dispose();
        gameUserInterface = new GameUserInterface(gameState, this);
    }


    private boolean hasSnakeNeighbor(int x, int y) {

        for (int horizontalOffset : new int[]{-1, 1}) {
            int posX = x + horizontalOffset;
            if (posX < 0 || posX >= gameState.getSize()) {
                continue;
            }
            if (gameState.getCurrentStatus(posX, y) == GameState.SELECTED) {
                return true;
            }
        }

        for (int verticalOffset : new int[]{-1, 1}) {
            int posY = y + verticalOffset;

            if (posY < 0 || posY >= gameState.getSize()) {
                continue;
            }

            int[] horizontalOffsets;
            if (y % 2 == 0) {
                horizontalOffsets = new int[]{-1, 0};
            } else {
                horizontalOffsets = new int[]{0, 1};
            }

            for (int horizontalOffset : horizontalOffsets) {
                int posX = x + horizontalOffset;
                if (posX < 0 || posX >= gameState.getSize()) {
                    continue;
                }
                if (gameState.getCurrentStatus(posX, posY) == GameState.SELECTED) {
                    return true;
                }
            }

        }
        return false;
    }

    private int[] hasFreeNeighbor(int x, int y) {

        int[] freeSpace = new int[2];

        for (int horizontalOffset : new int[]{-1, 1}) {
            int posX = x + horizontalOffset;
        }

        for (int verticalOffset : new int[]{-1, 1}) {
            int posY = y + verticalOffset;
            int[] horizontalOffsets;
            if (y % 2 == 0) {
                horizontalOffsets = new int[]{-1, 0};  // {-1, 0}
            } else {
                horizontalOffsets = new int[]{0, 1};  // {0, 1}
            }

            for (int horizontalOffset : horizontalOffsets) {
                int posX = x + horizontalOffset;
                if (gameState.getCurrentStatus(posX, posY) == GameState.FREE_CUBE) {
                    freeSpace[0] = posX;
                    freeSpace[1] = posY;
                }
            }

        }
        for (int i = 0; i < freeSpace.length; i++) {
            System.out.println(freeSpace[0] +", "+ freeSpace[1]);
        }
        return freeSpace;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Cube cube) {
            if (hasSnakeNeighbor(cube.getColumn(), cube.getRow())
                    && gameState.getCurrentStatus(cube.getColumn(), cube.getRow()) != GameState.SELECTED) {

                if (gameState.getCurrentStatus(cube.getColumn(), cube.getRow()) == GameState.RED_CUBE) {
                    // Clicked on mouse
                    int answer = JOptionPane.showConfirmDialog(gameUserInterface, "You won. Do you want to play again?");
                    if (answer == JOptionPane.YES_OPTION) {
                        reset();
                    } else {
                        System.exit(0);
                    }
                } else {
                    gameState.select(cube.getColumn(), cube.getRow());
                    cube.setType(1);

                    // Move mouse

                    int[] freeSpace = new int[2];
                    freeSpace = hasFreeNeighbor(gameState.getCurrentCube().getY(), gameState.getCurrentCube().getX());
                    gameState.setCube(freeSpace[1], freeSpace[0]);
                    gameUserInterface.getBoardUserInterface().update();

                    Point mousePos = gameState.getCurrentCube();
                    if (mousePos.getX() == 0 || mousePos.getX() == gameState.getSize() - 1 ||
                            mousePos.getY() == 0 || mousePos.getY() == gameState.getSize() - 1) {

                        JOptionPane.showMessageDialog(gameUserInterface, "You lost.");
                    }
                }
            }
        } else {
            JButton buttonClicked = (JButton) e.getSource();

            if (buttonClicked == gameUserInterface.getReset()) {
                reset();
            } else if (buttonClicked == gameUserInterface.getQuit()) {
                System.exit(0);
            }
        }
    }


}

