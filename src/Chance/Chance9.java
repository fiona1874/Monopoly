package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance9 implements Chance{
    private String instruction = "Go directly to Jail.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCurrentPos(10);
        player.setInJail(true);
        player.setIsDouble(false);
        player.setDoublesRolled(0);
    }
}
