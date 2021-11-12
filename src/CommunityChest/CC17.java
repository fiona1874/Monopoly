package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC17 implements CommunityChest{
    private String instruction = "You inherit $100.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 100);
    }
}
