package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance13 implements Chance{
    private String instruction = "Take a walk on the Boardwalk.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCurrentPos(39);
    }
}
