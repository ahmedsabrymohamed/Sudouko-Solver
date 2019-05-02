package app;

import java.util.ArrayList;

public class Solver implements Runnable {

    static ThreadGroup solvers = new ThreadGroup("Solvers");
    Thread singleSolver;
    ArrayList<Integer> empty;
    Board board;

    Solver(Board board, ArrayList<Integer> empty) {
        this.board = board;
        this.empty = empty;
        singleSolver = new Thread(this);
    }

    @Override
    public void run() {
        
    }

}