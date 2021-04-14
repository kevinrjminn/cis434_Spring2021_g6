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

    public TicTacToe()
    {
        //Call the method to create GUI board
        createBoardGUI();

        //Gets the width of the screen
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(WIDTH, HEIGHT);
        setLocation(screenWidth / 4, screenHeight / 4);
    }
//aaaaaa more test
    //Implement the method to creat GUI board
    private void createBoardGUI()
    {
        //Set the title of the board
        title = new JLabel("TIC TAC TOE Game!");
        titlePanel = new JPanel();
        //set the font type and size
        title.setFont(new Font(Font.MONOSPACED, 0, 40));
        //set the fond color
        title.setForeground(Color.BLUE);
        //add it to the panel
        titlePanel.add(title);

        //Create panel
        boardPanel = new JPanel();
        boardPanel.setLayout(LAYOUT);
}