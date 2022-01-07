package ExploudingAtoms.presentation.controler;


import ExploudingAtoms.interfaces.Game;
import ExploudingAtoms.interfaces.IAtoms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {

    private static final int SIZE = 10;

    private IAtoms game;

    private Button[][] cells;

    @FXML
    private GridPane gpGame;

    @FXML
    private Label lMoves;

    @FXML
    private Label lGameStatus;

    @FXML
    public void initialize() {
        // TODO: Change here with your own impl
        game = new Game();
        // TODO: Change here with your own impl

        if (game != null) {
            cells = new Button[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    Button cell = new Button();
                    cell.setPrefWidth(50);
                    cell.setPrefHeight(50);

                    int y = j;
                    int x = i;
                    cell.setOnMouseClicked(event -> {
                        game.makeMove(x, y);
                        rerender();
                    });

                    cells[x][y] = cell;
                    gpGame.add(cell, i + 1, j + 1);
                }
            }

            rerender();
        }
    }

    public void onNewClicked(ActionEvent actionEvent) {
        initialize();
    }

    private void rerender() {
        boolean[][] grid = game.getGrid();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setStyle("-fx-background-color: " + (grid[i][j] ? "gray" : "white") + "; -fx-border-color: rgba(0, 0, 0, 0.2); -fx-border-width: 0.5");
            }
        }

        lMoves.setText(game.getMoveCount() + "");
        if (game.isGameOver()) {
            lGameStatus.setText("Game finished");
            lGameStatus.setStyle("-fx-text-fill: green");
        } else {
            lGameStatus.setText("Game in progress");
            lGameStatus.setStyle("-fx-text-fill: black");
        }
    }
}