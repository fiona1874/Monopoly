package CommunityChest;

import main.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class CCDeck {
    private ArrayList<CommunityChest> CCDeck;

    public CCDeck(){
        CCDeck = new ArrayList<>();
        CCDeck.add(new CC1());
        CCDeck.add(new CC2());
        CCDeck.add(new CC3());
        CCDeck.add(new CC4());
        CCDeck.add(new CC5());
        CCDeck.add(new CC6());
        CCDeck.add(new CC7());
        CCDeck.add(new CC8());
        CCDeck.add(new CC9());
        CCDeck.add(new CC10());
        CCDeck.add(new CC11());
        CCDeck.add(new CC12());
        CCDeck.add(new CC13());
        CCDeck.add(new CC14());
        CCDeck.add(new CC15());
        CCDeck.add(new CC16());
        CCDeck.add(new CC17());
    }

    public void Draw(ArrayList<Player> allPlayer, Player player){
        CommunityChest card = CCDeck.get(0);
        CCDeck.remove(0);
        CCDeck.add(card);
        JOptionPane.showMessageDialog(null, card.getInstruction(), "Community Chest Card",
                JOptionPane.INFORMATION_MESSAGE);

        card.action(allPlayer, player);
    }

    public void Shuffle(){
        Collections.shuffle(CCDeck);
    }
}
