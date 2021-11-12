package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC12 implements CommunityChest{
    private String instruction = "Hospital Fees. Pay $50.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() - 50);
    }
}
