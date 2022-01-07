package ExploudingAtoms.interfaces;

public interface IAtoms {

    void makeMove(int x, int y);

    boolean[][] getGrid();

    int getMoveCount();

    boolean isGameOver();
}

