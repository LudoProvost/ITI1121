import java.util.Random;

public class GameState {


		//static final variables public
		public static final int FREE_CUBE = 0;
		public static final int SELECTED = 1;
		public static final int RED_CUBE = 2;
		public static final int MAX_SELECTED = 5;
		
		//non-final variables private
		private int boardSize;
		private Point redCube;
		private int[][] board;

    /**
     * Constructor 
	 * initializes the state to the size of board
     *  The parameter size is the size of the board
     */
    public GameState(int size) {
        board = new int[size][size];
        boardSize = size;

        Random random = new Random();
        int mid = (int) Math.floor((size - 1) / 2.0);
        if (size % 2 == 0) {
            redCube = new Point(random.nextInt(2) + mid, random.nextInt(2) + mid);
        } else {
            redCube = new Point(random.nextInt(3) - 1 + mid, random.nextInt(3) - 1 + mid);
        }

        board[redCube.getY()][redCube.getX()] = RED_CUBE;

        int i = MAX_SELECTED;
        while (i > 0) {
            int x = random.nextInt(getSize());
            int y = random.nextInt(getSize());
            if (getCurrentStatus(x, y) == FREE_CUBE) {
                select(x, y);
                i--;
            }
        }
    }

    public  int getSize(){
		return boardSize;
   }

    /**
     * returns the current status (FREE_CUBE, SELECTED or RED_CUBE) of a given cube in the game
     * 
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     * return the status of the cube at location (i,j)
     */   
    public int getCurrentStatus(int i, int j){
		return board[j][i];
    }


    /**
     * Sets the status of the cube at coordinate (i,j) to SELECTED
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void select(int i, int j){
	    board[j][i] = SELECTED;
    }

    /**
     * Puts the red cube at coordinate (i,j). Clears the previous location 
     * of the red cube.
     *
      * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void setCube(int i, int j){
        board[redCube.getY()][redCube.getX()] = FREE_CUBE;
        board[j][i] = RED_CUBE;
        redCube.reset(i, j);
   }

    /* Getter method for the current red cube
     * return the location of the curent red cube */   
    public Point getCurrentCube(){
		return redCube;
    }

}
