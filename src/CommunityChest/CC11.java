package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC11 implements CommunityChest{
    private String instruction = "Life insurance matures – Collect $100";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() + 100);
    }
}
