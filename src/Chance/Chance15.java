package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance15 implements Chance{
    private String instruction = "Your building and loan matures. Collect $150. ";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCash(player.getCash() + 150);
    }
}
