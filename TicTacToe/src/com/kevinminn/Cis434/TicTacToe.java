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

        //Implement button action
        class ButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                //increment turn for each selection
                turns++;

                //put the Mark alteranatively
                if(turns % 2 == 0)
                {
                    MARK = "O";
                }
                else
                {
                    MARK = "X";
                }
                //create button
                JButton btn = (JButton)ae.getSource();
                btn.setForeground(Color.YELLOW);
                btn.setText(MARK);
                btn.setEnabled(false);
                displayWinner();
            }
        }
        //Create object for the ButtonListener
        ActionListener buttonListener = new ButtonListener();
        //use for-loop add buttons in the panel
        for(int i=0; i<9; i++)
        {
            buttons[i] = new JButton("");
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.YELLOW);
            buttons[i].setFont(new Font(Font.SERIF, 0, 24));
            buttons[i].addActionListener(buttonListener);
            boardPanel.add(buttons[i]);
        }

        //Create EXit button
        exit = new JButton("EXIT");
        exit.setFont(new Font(Font.MONOSPACED, 0, 24));
        exit.setForeground(Color.RED);
        //set the action listenet for exit button
        class QuitListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        }
        ActionListener quitListener = new QuitListener();
        exit.addActionListener(quitListener);

        //Add the panel
        wholePanel = new JPanel();
        wholePanel.setLayout(new BorderLayout());
        wholePanel.add(titlePanel, BorderLayout.NORTH);
        wholePanel.add(boardPanel, BorderLayout.CENTER);
        wholePanel.add(exit, BorderLayout.SOUTH);
        add(wholePanel);
    }

    //Implement the method to check for the horizontal wins
    public void checkHorzWins()
    {
        if (buttons[0].getText().equals(buttons[1].getText())
                && buttons[1].getText().equals(buttons[2].getText())
                && buttons[0].getText().equals("")==false)
        {
            win=true;
        }

        else if (buttons[3].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[5].getText())
                &&buttons[3].getText().equals("")==false)
        {
            win=true;
        }
        else if (buttons[6].getText().equals(buttons[7].getText())
                && buttons[7].getText().equals(buttons[8].getText())
                && buttons[6].getText().equals("")==false)
        {
            win=true;
        }
    }


    //Implement the method to check for the Vertical wins
    public void checkVertWins()
    {
        if (buttons[0].getText().equals(buttons[3].getText())
                && buttons[3].getText().equals(buttons[6].getText())
                && buttons[0].getText().equals("")==false)
        {
            win=true;
        }

        else if (buttons[1].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[7].getText())
                && buttons[1].getText().equals("")==false)
        {
            win=true;

        }

        else if (buttons[2].getText().equals(buttons[5].getText())
                && buttons[5].getText().equals(buttons[8].getText())
                && buttons[2].getText().equals("")==false)
        {
            win=true;
        }
    }
    //Implement the method to check for the Diaogonal wins
    public void checkDiagWins()
    {
        if (buttons[0].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[8].getText())
                && buttons[0].getText().equals("")==false)
        {
            win=true;
        }

        else if (buttons[2].getText().equals(buttons[4].getText())
                && buttons[4].getText().equals(buttons[6].getText())
                && buttons[2].getText().equals("")==false)
        {
            win=true;
        }
    }

}
