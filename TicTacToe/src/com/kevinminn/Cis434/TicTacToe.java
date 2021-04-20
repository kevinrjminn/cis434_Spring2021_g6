package com.kevinminn.Cis434;
//Import required packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class TicTacToe {
    //declare local variables
//    private static final GridLayout LAYOUT = new GridLayout(3, 3);
//    private static final int HEIGHT = 500;
//    private static final int WIDTH = 500;

    //Declare array of buttons
    private JFrame mainFrame;
    private JPanel scorePanel, buttonPanel, statusPanel;
    private JLabel statusLabel;
    private JButton[][] board;
    private JTextField xScoreField, oScoreField, drawsField;
    private JLabel xLabel, oLabel, drawsLabel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGameMenuItem;
    private JMenuItem exitMenuItem;

    private String currentPlayer;
    private boolean Win;
    private int xScore, oScore, drawsScore, buttonClicked;
    //Initialize boolean variable
    //set to false
    private boolean win = false;


    public TicTacToe()
    {
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());

// panel to contain the player score statistics
        scorePanel = new JPanel(new FlowLayout(0, 15, 5));

        xLabel = new JLabel("Player 1: ");
        xScoreField = new JTextField(10);
        xScoreField.setHorizontalAlignment(SwingConstants.CENTER);
        xScoreField.setEditable(false);

        oScoreField = new JTextField(10);
        oScoreField.setEditable(false);
        oScoreField.setHorizontalAlignment(SwingConstants.CENTER);
        oLabel = new JLabel("Player 2: ");

        drawsField = new JTextField(10);
        drawsField.setHorizontalAlignment(SwingConstants.CENTER);
        drawsField.setEditable(false);
        drawsLabel = new JLabel("Draws: ");

        scorePanel.add(xLabel);
        scorePanel.add(xScoreField);
        scorePanel.add(oLabel);
        scorePanel.add(oScoreField);
        scorePanel.add(drawsLabel);
        scorePanel.add(drawsField);

// panel to contain the buttons
        buttonPanel = new JPanel(new GridLayout(3, 3));

        statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

// game status label
        statusLabel = new JLabel("New Game");
        statusLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusPanel.add(statusLabel);

        board = new JButton[3][3];
        currentPlayer = "X";
        xScore = 0;
        oScore = 0;
        drawsScore = 0;
        buttonClicked = 0;
        Win = false;

        initBoard();
        initMenu();

        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel, BorderLayout.CENTER);
        mainFrame.add(statusPanel, BorderLayout.SOUTH);

        mainFrame.setSize(700, 500);
        mainFrame.setTitle("Tic Tac Toe: Group 6");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }


    private void initBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                JButton btn = new JButton();
                btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                board[i][j] = btn;

// set action listener for the buttons
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("") && Win == false)
                        {
                            btn.setText(currentPlayer);
                            buttonClicked++;
                            checkWin();
                            switchPlayers();
                        }
                    }
                });

                buttonPanel.add(btn);
            }
        }
    }

    private void initMenu()
    {
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
                statusLabel.setText("New Game");
                xScore = oScore = drawsScore = 0;
                xScoreField.setText("");
                oScoreField.setText("");
                drawsField.setText("");
            }
        });
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(newGameMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);
    }



    private void resetBoard()
    {
        switchPlayers();
        buttonClicked = 0;
        Win = false;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j].setText("");
            }
        }
    }

    private void switchPlayers()
    {
        if(currentPlayer.equals("X"))
        {
            currentPlayer = "O";
            statusLabel.setText("Player " + currentPlayer + "'s turn...");
        }
        else
        {
            currentPlayer = "X";
            statusLabel.setText("Player " + currentPlayer + "'s turn...");
        }
    }

    private void checkWin()
    {

        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");
            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }

        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }

        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }


        else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }


        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }


        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }


        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }

// right to left diagonal
        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer))
        {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " is the Winner!");
            if(currentPlayer.equals("X"))
                xScoreField.setText(++xScore + "");
            else
                oScoreField.setText(++oScore + "");

            statusLabel.setText("Game over! Player " + currentPlayer + " wins!");
            Win = true;
            resetBoard();
        }
        else
        {
// the game is a draw
            for(int i = 0; i < 3; i++)
            {
                for(int j = 0; j < 3; j++)
                {
                    if(!board[i][j].getText().equals("") && buttonClicked == 9)
                    {
                        JOptionPane.showMessageDialog(null, "The match is a draw!");
                        statusLabel.setText("Game over! The game is a draw.");
                        drawsField.setText(++drawsScore +"");
                        Win = false;
                        resetBoard();
                    }
                }
            }
        }
    }


}









