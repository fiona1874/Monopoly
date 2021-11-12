package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance6 implements Chance{
    private String instruction = "Bank pays you dividend of $50.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCash(player.getCash() + 50);
    }
}
