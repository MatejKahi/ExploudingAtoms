package ExploudingAtoms.interfaces;

import java.util.Random;
import java.util.Stack;


public class Game implements IAtoms {

    private GameField[][] gameBoard;
    private int moves;
    private int player;



    private int getTargetCapacity(int x, int y) {
        if (x == 0) {
            if (y == 0 || y == gameBoard[0].length - 1) return 2;
            else {
                return 3;
            }
        }
        if (x == gameBoard.length - 1) {
            if (y == 0 || y == gameBoard[0].length - 1) return 2;
            else {
                return 3;
            }
        }
        if (y == 0 || y == gameBoard[0].length - 1) return 3;
        else {
            return 4;
        }
    }

    public Game(int x, int y) {
        player = 1;
        this.gameBoard = new GameField[x][y];
        moves = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = new GameField();
            }
        }
    }


    @Override
    public void makeMove(int x, int y) {

        moves = getMoveCount() + 1;
        Stack<Point> points = new Stack<>();
        points.push(new Point(x, y));
        while (!points.empty()) {
            Point CurrentPoint = points.pop();
            AddToField(CurrentPoint.getX(), CurrentPoint.getY());
            if (gameBoard[CurrentPoint.getX()][CurrentPoint.getY()].getOccupancy() >= getTargetCapacity(CurrentPoint.getX(), CurrentPoint.getY())) {
                gameBoard[CurrentPoint.getX()][CurrentPoint.getY()].setOccupancy(0);
                gameBoard[CurrentPoint.getX()][CurrentPoint.getY()].setPlayer(0);
                if (CurrentPoint.getX() != 0) {
                    points.push(new Point(CurrentPoint.getX() - 1, CurrentPoint.getY()));
                }
                if (CurrentPoint.getY() != 0) {
                    points.push(new Point(CurrentPoint.getX(), CurrentPoint.getY() - 1));
                }
                if (CurrentPoint.getX() != gameBoard.length - 1) {
                    points.push(new Point(CurrentPoint.getX() + 1, CurrentPoint.getY()));
                }
                if (CurrentPoint.getY() != gameBoard[0].length - 1) {
                    points.push(new Point(CurrentPoint.getX(), CurrentPoint.getY() + 1));
                }
            }
        }
        if (player == 1) {
            player = 2;

            }else{
            player = 1;
        }
    }



    @Override
    public GameField[][] getGrid() {
        return gameBoard;
    }

    @Override
    public int getMoveCount() {
        return moves;
    }

    @Override
    public boolean isGameOver() {
        if (moves <= 2)
            return false;
          int[] FieldCount = new int[3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                FieldCount[gameBoard[i][j].getPlayer()] = FieldCount [gameBoard[i][j].getPlayer()] + 1;
            }
        }
        if (FieldCount[1] == 0 || FieldCount[2] == 0)
            return true;
        else {
            return false;
        }
    }
    private void AddToField(int x, int y){
        gameBoard[x][y] .setPlayer(player);
        gameBoard[x][y] .setOccupancy(gameBoard[x][y] .getOccupancy() + 1);
    }
}
