package app;

/**
 * Cell
 * Contains Board Cell Info
 */
public class Cell {

    private int bRow;
    private int block;
    private int row;
    private int cell;

    public Cell(int bRow, int block, int row, int cell) {

        this.bRow = bRow;
        this.block = block;
        this.cell = cell;
        this.row = row;
    }

    public Cell() {

        this.bRow = -1;
        this.block = -1;
        this.cell = -1;
        this.row = -1;
    }
    public void setCell(int bRow, int block, int row, int cell) {

        this.bRow = bRow;
        this.block = block;
        this.cell = cell;
        this.row = row;
    }

    public int[] getCellDimensions(){
        int []a={bRow,block,row,cell};
        return a;
    }
}