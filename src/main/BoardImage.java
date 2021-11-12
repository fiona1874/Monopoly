package main;

import javax.swing.*;


public class BoardImage extends JFrame{

    public BoardImage(){
        super("Monopoly");
        this.setLayout(null);
        this.setBounds(0,0,1500,920);

        ImageIcon board = new ImageIcon("GameBoard.jpeg");
        JLabel label = new JLabel();
        label.setBounds(0,0,900,900);
        label.setIcon(board);
        this.add(label);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
