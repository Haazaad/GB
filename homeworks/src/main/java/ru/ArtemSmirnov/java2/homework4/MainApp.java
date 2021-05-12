package ru.ArtemSmirnov.java2.homework4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(MainApp.class.getResource("sample.fxml"));
        stage.setTitle("Simple Chat");
        stage.setScene(new Scene(root, 475, 300));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
