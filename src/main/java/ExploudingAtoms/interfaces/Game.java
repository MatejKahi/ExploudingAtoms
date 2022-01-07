package ExploudingAtoms.interfaces;

import java.util.Random;


public class Game implements IAtoms {

    private boolean[][] active;
    private int moves;

    public Game() {
        active = new boolean[10][10];
        moves = 0;

    }

    @Override
    public void makeMove(int x, int y) {

    }

    @Override
    public boolean[][] getGrid() {
        return active;
    }

    @Override
    public int getMoveCount() {
        return 0;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
