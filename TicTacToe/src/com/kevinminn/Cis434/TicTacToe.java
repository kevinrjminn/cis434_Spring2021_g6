package com.kevinminn.Cis434;

import javafx.application.Application;

import javax.swing.*;

public class TicTacToe {

    
    private Character showX;
    private Character showO;

    public TicTacToe(Character showX, Character showO) {
        super();
        this.showX = showX;
        this.showO = showO;
    }

    public Character getShowX() {
        return showX;
    }

    public void setShowX(Character showX) {
        this.showX = showX;
    }

    public Character getShowO() {
        return showO;
    }

    public void setShowO(Character showO) {
        this.showO = showO;
    }


}
