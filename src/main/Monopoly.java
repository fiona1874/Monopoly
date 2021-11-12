package main;

import Chance.ChanceDeck;
import CommunityChest.CCDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Monopoly implements Runnable, ActionListener {
    private Thread thread;
    private int numOfPlayers, nextPlayer;
    private ArrayList<Player> allPlayer;
    private GameBoard gameBoard;
    private CCDeck ccDeck;
    private ChanceDeck chanceDeck;
    private BoardImage bImage;
    private BoardPanel bPanel;
    private ScorePanel sPanel;
    private Graphics g;

    public Monopoly(){

        this.start();
        this.stop();
    }

    public void init(){
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        gameBoard = new GameBoard();
        bImage = new BoardImage();

        bPanel = new BoardPanel(gameBoard);
        this.buttons();
        bImage.add(bPanel);

        bImage.validate();
        bImage.repaint();


    }

    public void newGame(){


        Integer[] opt = new Integer[7];
        for (int i = 0; i < 7; i++){
            opt[i] = i+2;
        }


        this.numOfPlayers = (int) JOptionPane.showInputDialog(null,
                "How many players? ",
                "Welcome!",
                JOptionPane.QUESTION_MESSAGE,
                null, opt, 0);



        allPlayer = new ArrayList<>();
        for(int i = 0; i<numOfPlayers; i++){
            Player p = new Player();
            String name = JOptionPane.showInputDialog("Player name");
            p.setName(name);
            allPlayer.add(p);
        }

        sPanel = new ScorePanel();

        bImage.add(sPanel);
        sPanel.updateBoard(allPlayer);

        ccDeck = new CCDeck();
        chanceDeck = new ChanceDeck();
        ccDeck.Shuffle();
        chanceDeck.Shuffle();
        nextPlayer = 0;
    }
    public void Play(){

        this.Display();
        Player cPlayer = allPlayer.get(nextPlayer);
        System.out.println(cPlayer.getName()+" Current position: " + cPlayer.getCurrentPos());
        System.out.println(cPlayer.getName()+" Current balance: " + cPlayer.getCash());


        int steps = cPlayer.rollDice();

        System.out.println(cPlayer.getName() + " Current dice rolled: " + steps);



        if (cPlayer.getInJail()){
            cPlayer.inJail();
        }else {
            JOptionPane.showMessageDialog(null, cPlayer.getName() + ": You rolled a " + steps , "Monopoly",
                    JOptionPane.INFORMATION_MESSAGE);
        }



        if (!cPlayer.getInJail()) {
            JOptionPane.showMessageDialog(null, cPlayer.getName() + ": Go forward " + steps + " steps.", "Monopoly",
                    JOptionPane.INFORMATION_MESSAGE);

            for (int i = 0; i < steps; i++) {
                cPlayer.forward();
                this.Display();
                try {
                    thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (cPlayer.getCurrentPos() == 0) {
                cPlayer.setCash(cPlayer.getCash() + 200);
                JOptionPane.showMessageDialog(null,
                        cPlayer.getName()+": You landed on GO!",
                        "GO", JOptionPane.INFORMATION_MESSAGE);
            } else if (gameBoard.getPosition(cPlayer.getCurrentPos()).getName() == "Community Chest") {
                ccDeck.Draw(allPlayer, cPlayer);
                this.Display();
            } else if (gameBoard.getPosition(cPlayer.getCurrentPos()).getName() == "Chance") {
                chanceDeck.Draw(allPlayer, cPlayer);
                this.Display();
                if (gameBoard.getPosition(cPlayer.getCurrentPos()) instanceof Property){
                    if (((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner() == null) { //open space
                        int ans = JOptionPane.showConfirmDialog(null,
                                cPlayer.getName()
                                        + ": Buy "
                                        + gameBoard.getPosition(cPlayer.getCurrentPos()).getName()
                                        + "?"
                                , "Buy property", JOptionPane.YES_NO_OPTION);
                        if (ans == 0) {  //buy
                            ((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).buyProperty(cPlayer);
                            gameBoard.checkMonopoly(cPlayer.getCurrentPos());
                        }  //not buy
                    } else if (((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner() == cPlayer) {
                        //this is player's own property
                        if (gameBoard.getPosition(cPlayer.getCurrentPos()) instanceof Land) {
                            ((Land) gameBoard.getPosition(cPlayer.getCurrentPos())).buyHouseOrHotel(cPlayer);
                        }
                    } else {  //other player's property, pay rent
                        JOptionPane.showMessageDialog(null,
                                cPlayer.getName()
                                        +": You landed on "
                                        +((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner().getName()
                                        + "'s property!",
                                "Pay rent", JOptionPane.INFORMATION_MESSAGE);
                        ((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).payRent(gameBoard, cPlayer, steps);
                    }
                }

            } else if (gameBoard.getPosition(cPlayer.getCurrentPos()).getName().endsWith("Tax")) {
                if (cPlayer.getCurrentPos() == 4) {
                    cPlayer.incomeTax();
                } else {
                    cPlayer.setCash(cPlayer.getCash() - 75);
                    JOptionPane.showMessageDialog(null,
                            "You paid $75 Luxury tax!" , "Success", JOptionPane.INFORMATION_MESSAGE);

                }
            } else if (cPlayer.getCurrentPos() == 30) {
                cPlayer.setCurrentPos(10);
                cPlayer.setInJail(true);
                System.out.println("Now in jail?" + cPlayer.getInJail());
                this.Display();
            } else if (gameBoard.getPosition(cPlayer.getCurrentPos()) instanceof Property) {
                if (((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner() == null) { //open space
                    int ans = JOptionPane.showConfirmDialog(null,
                            cPlayer.getName()
                                    + ": Buy "
                                    + gameBoard.getPosition(cPlayer.getCurrentPos()).getName()
                                    + "?"
                            , "Buy property", JOptionPane.YES_NO_OPTION);
                    if (ans == 0) {  //buy
                        ((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).buyProperty(cPlayer);
                        gameBoard.checkMonopoly(cPlayer.getCurrentPos());
                    }  //not buy
                } else if (((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner() == cPlayer) {
                    //this is player's own property
                    if (gameBoard.getPosition(cPlayer.getCurrentPos()) instanceof Land) {
                        ((Land) gameBoard.getPosition(cPlayer.getCurrentPos())).buyHouseOrHotel(cPlayer);
                    }
                } else {  //other player's property, pay rent
                    JOptionPane.showMessageDialog(null,
                            cPlayer.getName()
                                    +": You landed on "
                                    +((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).getOwner().getName()
                                    + "'s property!",
                            "Pay rent", JOptionPane.INFORMATION_MESSAGE);
                    ((Property) gameBoard.getPosition(cPlayer.getCurrentPos())).payRent(gameBoard, cPlayer, steps);
                }

            } else
            {
                JOptionPane.showMessageDialog(null,
                        cPlayer.getName()+": You landed on " + gameBoard.getPosition(cPlayer.getCurrentPos()).getName(),
                        gameBoard.getPosition(cPlayer.getCurrentPos()).getName(), JOptionPane.INFORMATION_MESSAGE);
            }

        }

        if (cPlayer.getDoublesRolled() == 3) {
            cPlayer.setCurrentPos(10);
            cPlayer.setInJail(true);
            cPlayer.setDoublesRolled(0);
        }
        else if (cPlayer.getDoublesRolled() > 0 && cPlayer.getDoublesRolled() < 3){
            if (cPlayer.getIsDouble()){
                JOptionPane.showMessageDialog(null,
                        cPlayer.getName()
                                + ": You rolled a double!" , "Continue to roll!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println("Doubles rolled"+cPlayer.getDoublesRolled());
            System.out.println("Rolled double? "+cPlayer.getIsDouble());
        }
        else {
            if (cPlayer.checkBankruptcy()){
                JOptionPane.showMessageDialog(null, cPlayer.getName()+
                                ": You went bankrupt! You lose!",
                        "You lose!", JOptionPane.WARNING_MESSAGE);
                allPlayer.remove(cPlayer);
            }
            else {
                cPlayer.setIsDouble(false);
                cPlayer.setDoublesRolled(0);
                if (nextPlayer < allPlayer.size() - 1) {
                    nextPlayer ++;
                }
                else
                {
                    nextPlayer = 0;
                }
            }
        }

        System.out.println(cPlayer.getName() +"End position:" + cPlayer.getCurrentPos());
        System.out.println(cPlayer.getName() +"End balance: " + cPlayer.getCash());
        sPanel.updateBoard(allPlayer);

    }

    public void buttons(){
        JButton start = new JButton("START");
        JButton restart = new JButton("RESTART");
        JButton cont = new JButton("CONTINUE");
        start.setBounds(1300, 120, 100, 60);
        restart.setBounds(1300, 420, 100, 60);
        cont.setBounds(1300, 720, 100, 60);
        start.setVisible(true);
        restart.setVisible(true);
        cont.setVisible(true);
        start.setLayout(null);
        restart.setLayout(null);
        cont.setLayout(null);
        start.addActionListener(this);
        RestartAction ra = new RestartAction();
        restart.addActionListener(ra);
        ContinueAction ca = new ContinueAction();
        cont.addActionListener(ca);
        bImage.add(start);
        bImage.add(restart);
        bImage.add(cont);
    }

    public void Display(){
        g = bPanel.getGraphics();
        bPanel.paintComponent(g, allPlayer);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.init();

    }

    public static void main(String[] args) {
        new Monopoly();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        newGame();
    }

    private class RestartAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            init();
            newGame();

        }
    }

    private class ContinueAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (allPlayer.size() >1){
                Play();
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Congrats! "+ allPlayer.get(0).getName()+ ", you won!", "Success", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }

}
