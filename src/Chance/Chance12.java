package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance12 implements Chance{
    private String instruction = "Take a trip to Reading Railroad.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        while (player.getCurrentPos() != 5){
            player.forward();
            if (player.getCurrentPos() == 0){
                player.setCash(player.getCash() + 200);
            }
        }
    }
}
