package ExploudingAtoms.presentation.controler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Window extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game-window.fxml")));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Atoms");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}