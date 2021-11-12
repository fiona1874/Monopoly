package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance16 implements Chance{
    private String instruction = "You have won a crossword competition. Collect $100.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCash(player.getCash() + 100);
    }
}
