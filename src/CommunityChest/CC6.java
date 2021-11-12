package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC6 implements CommunityChest{
    private String instruction = "Go to Jail.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCurrentPos(10);
        player.setInJail(true);
        player.setIsDouble(false);
        player.setDoublesRolled(0);
    }
}
