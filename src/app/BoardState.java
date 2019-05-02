package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * BoardState Contain information about the current state of the Board
 */

public class BoardState {

    private Set<Integer> blockState[][];
    private Set<Integer> colState[][];
    private Set<Integer> rowState[][];

    BoardState() {
        blockState = new HashSet[3][3];
        colState = new HashSet[3][3];
        rowState = new HashSet[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                blockState[i][j] = new HashSet<Integer>();
                colState[i][j] = new HashSet<Integer>();
                rowState[i][j] = new HashSet<Integer>();

            }
    }

    BoardState(BoardState state) {
        this();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                blockState[i][j].addAll(state.blockState[i][j]);
                colState[i][j].addAll(state.colState[i][j]);
                rowState[i][j].addAll(state.rowState[i][j]);
            }

    }

    public Set<Integer> getCellState(Cell cell) {
        int[] dim = cell.getCellDimensions();
        Set<Integer> cellState = new HashSet<>();
        cellState.addAll(blockState[dim[0]][dim[1]]);
        cellState.retainAll(rowState[dim[0]][dim[2]]);
        cellState.retainAll(colState[dim[1]][dim[3]]);

        return cellState;
    }

    public BoardState updateState(Cell cell, int val) {
        int[] dim = cell.getCellDimensions();
        BoardState newState = new BoardState(this);
        newState.blockState[dim[0]][dim[1]].remove(val);
        newState.rowState[dim[0]][dim[2]].remove(val);
        newState.colState[dim[1]][dim[3]].remove(val);

        return newState;

    }

}