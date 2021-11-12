package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC8 implements CommunityChest{
    private String instruction = "Holiday {Xmas} Fund matures. Receive {Collect} $100.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 100);
    }
}
