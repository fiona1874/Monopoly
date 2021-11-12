package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC3 implements CommunityChest{
    private String instruction = "Doctor's fees. {fee} Pay $50.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() - 50);
    }
}
