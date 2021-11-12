package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScorePanel extends JTextArea {
    private String score;
    public ScorePanel(){


        this.setText(score);
        this.setForeground(Color.blue);
        this.setBounds(900,0,300,900);
    }

    public void updateBoard(ArrayList<Player> allPlayer){
        score = "Score Board: \n";
        score += "Player Balance: \n";
        for (Player p : allPlayer){
            score += p.getName() + "'s Balance: " + p.getCash() + "\n";
        }
        score += "\n Player Position: \n";
        for (Player p : allPlayer){
            score += p.getName() + "'s Position: " + p.getCurrentPos() + "\n";
        }
        score += "\n Player is in jail: \n";
        for (Player p : allPlayer){
            score += p.getName() + " is in Jail: " + p.getInJail() + "\n";
        }
        score += "\n Player's property: \n";
        for (Player p : allPlayer){
            score += p.getName() + "'s # of properties: " + p.getPropertyOwned().size() + "\n";
        }

        this.setText(score);
    }


}
