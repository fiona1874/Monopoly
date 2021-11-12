package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance5 implements Chance{
    private String instruction = "Advance to the nearest Railroad.";

    @Override
    public String getInstruction() {
        return this.instruction;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        while (player.getCurrentPos() % 10 != 5){
            player.forward();
            if(player.getCurrentPos() == 0){
                player.setCash(player.getCash() + 200);
            }
        }
    }
}
