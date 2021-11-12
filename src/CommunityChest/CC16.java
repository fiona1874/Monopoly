package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC16 implements CommunityChest{
    private String instruction = "You have won second prize in a beauty contest. Collect $10.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 10);
    }
}
