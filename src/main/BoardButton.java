package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardButton extends JButton implements ActionListener{
    private int pos;
    private GameBoard gb;
    public BoardButton (String name, int pos, GameBoard gb){
        super(name);
        this.pos = pos;
        this.gb = gb;
        this.setLayout(null);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setText(null);
        this.setVisible(true);
        this.setOpaque(false);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
            Position p = gb.getPosition(pos);
            if (p instanceof Land) {
                JOptionPane.showMessageDialog(null, String.format(
                        "Price: " + ((Land) p).getPrice() + "\n"
                                + "Rent: " + ((Land) p).getRent() + "\n"
                                + "Owner: " + ((Land) p).getOwner() + "\n"
                                + "Monopoly: " + ((Land) p).getMonopoly(),
                        p.getName(), JOptionPane.PLAIN_MESSAGE));

            } else if (p instanceof Utility){
                JOptionPane.showMessageDialog(null, String.format(
                        "Price: " + ((Utility) p).getPrice() + "\n"
                                + "Owner: " + ((Utility) p).getOwner(),
                        p.getName(), JOptionPane.PLAIN_MESSAGE));
            } else if (p instanceof RailRoad){
                JOptionPane.showMessageDialog(null, String.format(
                        "Price: " + ((RailRoad) p).getPrice() + "\n"
                                + "Owner: " + ((RailRoad) p).getOwner(),
                        p.getName(), JOptionPane.PLAIN_MESSAGE));
            } else
                JOptionPane.showMessageDialog(null,
                        p.getName(), p.getName(),
                        JOptionPane.PLAIN_MESSAGE);

    }


}
