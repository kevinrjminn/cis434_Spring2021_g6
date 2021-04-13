package com.kevinminn.Cis434;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {


//Karim Testing uploading code

//    JFrame frame = new JFrame("TicTacToe");
////    board = new GameBoard();


//    private void initialize(){
//        JPanel menu = new JPanel(new BorderLayout());
//        JPanel game = new JPanel(new GridLayout());
//
//
//    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(root, 435, 435));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


    }
}
