package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC10 implements CommunityChest{
    private String instruction = "It is your birthday. Collect $10 from every player.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        for (Player player1: allPlayer) {
            if (player1 == player) {
                player.setCash(player.getCash() + (allPlayer.size() - 1) * 10);
            } else player1.setCash(player.getCash() - 10);
        }
    }
}
