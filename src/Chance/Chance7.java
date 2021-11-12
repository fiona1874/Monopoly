package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance7 implements Chance{
    private String instruction = "Get out of Jail Free.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setJailFreeCard(true);
    }
}
