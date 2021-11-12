package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance10 implements Chance{
    private String instruction = "Make general repairs on all your property: " +
            "For each house pay $25, For each hotel pay $100.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCash(player.getCash() - player.getNumOfHouse() * 25 - player.getNumOfHotel() * 100);
    }
}
