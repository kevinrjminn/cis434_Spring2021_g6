package com.kevinminn.Cis434;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class MenuController {
    @FXML
    private Button StartBtn;

    @FXML
    private ComboBox<Integer> comboboxbtn;

    public int seriesOf;

    public void initialize(){
        comboboxbtn.getItems().addAll(1, 3, 5, 7);
    }
    @FXML
    public void StartGame(ActionEvent gameEvent){
        try{
            seriesOf = comboboxbtn.getValue();
            //System.out.println(bestOf+1);
            TicTacToe.bestOf = seriesOf;
            Stage oldstage = (Stage) StartBtn.getScene().getWindow();
            oldstage.close();
            TicTacToe ticTacToe = new TicTacToe();
        }
        catch (Exception ex){
            System.out.println("ERROR MenuController" + ex );
            ex.printStackTrace();
        }
    }

    @FXML
    public void exitGame(ActionEvent event){
        System.exit(0);
    }

}
