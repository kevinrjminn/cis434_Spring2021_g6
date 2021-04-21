package com.kevinminn.Cis434;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

//public class Game extends JFrame {
//
//    public static void main(String[] args) {
//        TicTacToe ticTacToe = new TicTacToe();
//    }
//
//}
public class Game extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Menu.fxml")); //creating root node
        Scene scene = new Scene(root); // creating a new scene
        primaryStage.setScene(scene);     // setting the scene to the stage
        primaryStage.setTitle("TicTacToe Main Menu");  //Program title
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
