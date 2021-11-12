package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
    public GameBoard gb;
    private BoardButton[] bButton;
    private Image monopoly = new ImageIcon("GameBoard.jpeg").getImage();
    public BoardPanel(GameBoard gb){
        this.gb = gb;

        this.setBounds(0,0, 900,900);
        this.posButtons();
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(false);
    }

    public void posButtons(){
       bButton = new BoardButton[40];
        for (int i = 0; i < bButton.length; i++){
            bButton[i] = new BoardButton(gb.getPosition(i).getName(), i, gb);
            this.add(bButton[i]);
        }

        bButton[0].setBounds(783, 783, 117, 117);

        for (int i = 1; i < 10; i++){
            int x = 783 - 74 * i;
            bButton[i].setBounds(x, 783, 74, 117);
        }

        bButton[10].setBounds(0, 783, 117, 117);

        for (int i = 11; i < 20; i++){
            int y = 783 - 74 * (i - 10);
            bButton[i].setBounds(0, y, 117, 74);
        }

        bButton[20].setBounds(0, 0, 117, 117);

        for (int i = 21; i < 30; i++){
            int x = 117 + 74 * (i - 21);
            bButton[i].setBounds(x, 0, 74, 117);
        }

        bButton[30].setBounds(783, 0, 117, 117);

        for (int i = 31; i < 40; i++){
            int y = 117 + 74 * (i - 31);
            bButton[i].setBounds(783, y , 117, 74);
        }


    }



    public void paintComponent(Graphics g, ArrayList<Player> allPlayer){

       g.drawImage(monopoly, 0, 0, 900, 900, null);
        ArrayList<ImageIcon> tokensImg = new ArrayList<>();
        for (int i = 1; i < 9; i++){
            String fileName = "token" + i + ".png";
            ImageIcon ii = new ImageIcon(fileName);
            Image img = ii.getImage();
            ImageIcon iiResized = new ImageIcon(img.getScaledInstance(40,40,Image.SCALE_FAST));
            tokensImg.add(iiResized);
        }
        if (allPlayer != null){
            for (Player p: allPlayer){
                g.drawImage(tokensImg.get(allPlayer.indexOf(p)).getImage(),
                        bButton[p.getCurrentPos()].getX()+20,
                        bButton[p.getCurrentPos()].getY()+20,
                        null);
            }
        }


    }



}
