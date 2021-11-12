package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance3 implements Chance{
    private String instruction = "Advance to St. Charles Place. If you pass Go, collect $200.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        if (player.getCurrentPos() > 11){
            player.setCash(player.getCash() + 200);
        }
        player.setCurrentPos(11);
    }
}
