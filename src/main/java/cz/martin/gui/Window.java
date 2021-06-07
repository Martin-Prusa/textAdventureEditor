package cz.martin.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Window extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/editor.fxml"));
        Scene s = new Scene(root);
        primaryStage.setScene(s);
        primaryStage.show();
        primaryStage.setTitle("Room editor");
        stage = primaryStage;
        primaryStage.setResizable(false);
    }
}
