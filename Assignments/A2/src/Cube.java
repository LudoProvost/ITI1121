import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;


/********************************************************************
 * The Cube is a type of JButton that represents a cube in the game 
 *********************************************************************/

public class Cube extends JButton {

    private int row;
    private int column;
    private int type;

    private final ImageIcon[] icons = new ImageIcon[]{
            new ImageIcon("resources/icons/square-0.png"),
            new ImageIcon("resources/icons/square-1.png"),
            new ImageIcon("resources/icons/square-2.png")};

    /**
     * Constructor
     */

    public Cube(int row, int column, int type) {
        super();
        this.setPreferredSize(new Dimension(40, 40));
        this.setBorderPainted(false);

        this.row = row;
        this.column = column;

        setType(type);

    }


    //Sets the type of a square.
    //sets the icon of the square.

    public void setType(int type) {
        this.type = type;
        this.setIcon(icons[type]);
    }


    // Getter method for the attribute row.
    public int getRow() {
        return row;
    }

    //Getter method for the attribute column.
    public int getColumn() {
        return column;
    }
}
