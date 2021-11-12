package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC7 implements CommunityChest{
    private String instruction = "Grand Opera Night. Collect $50 from every player for opening night seats.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        for( Player player1: allPlayer){
            if (player1 == player){
                player.setCash(player.getCash() + (allPlayer.size()-1) * 50);
            }
            else player1.setCash(player1.getCash() - 50);
        }
        //collect money and subtract from other players
    }
}
