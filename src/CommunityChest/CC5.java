package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC5 implements CommunityChest{
    private String instruction = "Get Out of Jail Free.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setJailFreeCard(true);
    }
}
