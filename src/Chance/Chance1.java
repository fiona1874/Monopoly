package Chance;

import main.Player;

import java.util.ArrayList;

public class Chance1 implements Chance{
    private String instruction = "Advance to \"Go\".";
    public String getInstruction(){return this.instruction;}
    @Override
    public void action(ArrayList<Player> allPlayer, Player player) {
        player.setCurrentPos(0);
        player.setCash(player.getCash() + 200);
    }

}
