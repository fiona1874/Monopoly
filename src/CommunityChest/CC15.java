package CommunityChest;

import main.Player;

import java.util.ArrayList;

public class CC15 implements CommunityChest{
    private String instruction = "You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.";
    public String getInstruction(){return this.instruction;}
    public void action(ArrayList<Player> allPlayer, Player player){
        player.setCash(player.getCash() - player.getNumOfHouse() * 40 - player.getNumOfHotel() * 115);
    }
}
