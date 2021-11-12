package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance11 implements Chance{
    private String instruction = "Pay poor tax of $15";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCash(player.getCash() - 15);
    }
}
