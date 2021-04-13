package com.kevinminn.Cis434;
//Import required packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JFrame {
    //declare local variables
    private static final GridLayout LAYOUT = new GridLayout(3, 3);
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    //Declare array of buttons
    private JButton buttons[] = new JButton[9];
    private JButton exit;
    //declare the panels
    private JPanel wholePanel, boardPanel, titlePanel;
    //Define the labels
    private JLabel title;
    private int turns = 0;
    private String MARK = "";
    //Intially boolean variable
    //set to false
    private boolean win = false;
}