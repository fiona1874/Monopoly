package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC4 implements CommunityChest{
    private String instruction = "From sale of stock you get $50.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 50);
    }
}
