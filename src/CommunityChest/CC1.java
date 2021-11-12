package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC1 implements CommunityChest{
    private String instruction = "Advance to \"Go\". (Collect $200)";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCurrentPos(0);
        player.setCash(player.getCash() + 200);
    }
}
