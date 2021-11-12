package Chance;

import main.Player;

import java.util.ArrayList;

public interface Chance {
    String getInstruction();
    void action(ArrayList<Player> allPlayer, Player player);
}
