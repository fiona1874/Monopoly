package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance8 implements Chance{
    private String instruction = "Go Back Three 3 Spaces.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        if (player.getCurrentPos() < 3){
            player.setCurrentPos(player.getCurrentPos() - 3 + 40);
        }
        else
            player.setCurrentPos(player.getCurrentPos() - 3);
    }
}
