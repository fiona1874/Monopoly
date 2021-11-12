package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC9 implements CommunityChest{
    private String instruction = "Income tax refund. Collect $20.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 20);
    }
}
