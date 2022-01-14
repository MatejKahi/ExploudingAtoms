package ExploudingAtoms.interfaces;

public interface IAtoms {

    void makeMove(int x, int y);

    GameField[][] getGrid();

    int getMoveCount();

    boolean isGameOver();
}

