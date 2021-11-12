package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC14 implements CommunityChest{
    private String instruction = "Receive $25 consultancy fee.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 25);
    }
}
