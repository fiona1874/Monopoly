package Chance;

import main.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck {
    private ArrayList<Chance> chanceDeck;

    public ChanceDeck(){
        chanceDeck = new ArrayList<Chance>();
        chanceDeck.add(new Chance1());
        chanceDeck.add(new Chance2());
        chanceDeck.add(new Chance3());
        chanceDeck.add(new Chance4());
        chanceDeck.add(new Chance5());
        chanceDeck.add(new Chance6());
        chanceDeck.add(new Chance7());
        chanceDeck.add(new Chance8());
        chanceDeck.add(new Chance9());
        chanceDeck.add(new Chance10());
        chanceDeck.add(new Chance11());
        chanceDeck.add(new Chance12());
        chanceDeck.add(new Chance13());
        chanceDeck.add(new Chance14());
        chanceDeck.add(new Chance15());
        chanceDeck.add(new Chance16());
    }

    public void Draw(ArrayList<Player> allPlayer, Player player){
        Chance card = chanceDeck.get(0);
        chanceDeck.remove(0);
        chanceDeck.add(card);
        JOptionPane.showMessageDialog(null, card.getInstruction(), "Chance Card",
                JOptionPane.INFORMATION_MESSAGE);

        card.action(allPlayer, player);

    }

    public void Shuffle(){
        Collections.shuffle(chanceDeck);
    }



    }

