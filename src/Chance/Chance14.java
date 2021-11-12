package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance14 implements Chance{
    private String instruction = "You have been elected Chairman of the Board. Pay each player $50.";

    @Override
    public String getInstruction() {
        return null;
    }

    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        for (Player player1 : allPlayer){
            if (player1 == player){
                player.setCash(player.getCash() - 50 * (allPlayer.size()-1));
            }
            else player1.setCash(player1.getCash() + 50);
        }

    }
}
