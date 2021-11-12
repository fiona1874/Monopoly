package Chance;

import main.GameBoard;
import main.Land;
import main.Player;
import main.Property;

import javax.swing.*;
import java.util.ArrayList;

public class Chance4 implements Chance{
    private String instruction = "Advance token to the nearest Utility.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        while (player.getCurrentPos() != 12 && player.getCurrentPos() != 28) {
            player.forward();
            if (player.getCurrentPos() == 0) {
                player.setCash(player.getCash() + 200);
            }
        }
    }
}


