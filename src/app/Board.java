package app;
/**
 * Board
 */
public class Board {

    public enum Diffculty {
        EASY, MEDIUM, HARD
    }
    private Diffculty level;
    /**
     * Board Dimensions
     * 
     *  Row of Blocks     Block     Row       Column
     *      []             []        []        []
     */
    private int board[][][][];

    public int[][][][] getBoard(){
        return board;
    }
    Board() {
        level = Diffculty.EASY;
        board = new int[3][3][3][3];
    }

    // Create the Board according to diffculty.
    Board(Diffculty level) {
        this.level = level;
    }
}