package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC2 implements CommunityChest{
    private String instruction = "Bank error in your favor. Collect $200.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 200);
    }
}
