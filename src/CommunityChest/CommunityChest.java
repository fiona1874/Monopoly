package CommunityChest;

import main.Player;

import java.util.ArrayList;

public interface CommunityChest {
    String getInstruction();
    void action(ArrayList<Player> allPlayer, Player player);
}
