package main;

import javax.swing.*;
import java.util.ArrayList;

public class Property extends Position{
    private int price, mortgage;
    private boolean isMonopoly, isMortgaged;
    private Player owner;
    public Property(String name, int price, int mortgage){
        super(name);
        this.price = price;
        this.mortgage = mortgage;
        this.owner = null;
        this.isMonopoly = false;
        this.isMortgaged = false;
    }



    public void buyProperty(Player player){
        if (player.getCash() < this.getPrice()) {
            int ans = JOptionPane.showConfirmDialog(null,
                    "Take out mortgage?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
            while (ans == 0) {
                    player.getMortgage();

                if (player.getCash() > this.getPrice()){
                    this.setOwner(player);
                    player.setCash(player.getCash() - this.getPrice());
                    player.addPropertyOwned(this);
                    JOptionPane.showMessageDialog(null,
                            "You bought "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ans = 1;
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient Fund!", "Purchase Failed", JOptionPane.INFORMATION_MESSAGE);
                    ans = JOptionPane.showConfirmDialog(null,
                            "Continue to buy?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
                }
            }



        }
        else{
            this.setOwner(player);
            player.setCash(player.getCash() - this.getPrice());
            player.addPropertyOwned(this);
            JOptionPane.showMessageDialog(null,
                    "You bought "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void payRent(GameBoard gb, Player player, int numRolled){
        if (this instanceof RailRoad){
            int numOFrr = 0;
            Player p1 = this.getOwner();
            ArrayList<RailRoad> rr = new ArrayList<>();
            rr.add((RailRoad) gb.getPosition(5));
            rr.add((RailRoad) gb.getPosition(15));
            rr.add((RailRoad) gb.getPosition(25));
            rr.add((RailRoad) gb.getPosition(35));
            for(RailRoad r1 : rr){
                if(r1.getOwner() == p1){
                    numOFrr++;
                }
            }
            if (numOFrr == 1){
                player.setCash(player.getCash() - 25);
                this.getOwner().setCash(this.getOwner().getCash() + 25);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $25 rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (numOFrr == 2){
                player.setCash(player.getCash() - 50);
                this.getOwner().setCash(this.getOwner().getCash() + 50);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $50 rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (numOFrr == 3){
                player.setCash(player.getCash() - 100);
                this.getOwner().setCash(this.getOwner().getCash() + 100);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $100 rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (numOFrr == 4){
                player.setCash(player.getCash() - 200);
                this.getOwner().setCash(this.getOwner().getCash() + 200);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $200 rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (this instanceof Utility){
            if (this.getMonopoly()){
                player.setCash(player.getCash() - 10 * numRolled);
                this.getOwner().setCash(this.getOwner().getCash() + 10 * numRolled);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $"+ 10*numRolled + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                player.setCash(player.getCash() - 4 * numRolled);
                this.getOwner().setCash(this.getOwner().getCash() + 4 * numRolled);
                JOptionPane.showMessageDialog(null,
                        "You paid "+ this.getOwner().getName() +" $"+ 4*numRolled + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (this instanceof Land){
            if (this.getMonopoly()){
                if (((Land) this).hasHotel()){
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent_hotel());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent_hotel());
                    JOptionPane.showMessageDialog(null,
                            "You paid $" + 2 * ((Land) this).getRent_hotel() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (((Land) this).getNumOfHouse() == 4){
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent_4());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent_4());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ 2 * ((Land) this).getRent_4() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 3){
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent_3());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent_3());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ 2 * ((Land) this).getRent_3() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 2){
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent_2());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent_2());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ 2 * ((Land) this).getRent_2() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 1){
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent_1());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent_1());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $" + 2 * ((Land) this).getRent_1() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    player.setCash(player.getCash() - 2 * ((Land) this).getRent());
                    this.getOwner().setCash(this.getOwner().getCash() + 2 * ((Land) this).getRent());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $" + 2 * ((Land) this).getRent() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
            }
            else {
                if (((Land) this).hasHotel()){
                    player.setCash(player.getCash() - ((Land) this).getRent_hotel());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent_hotel());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent_hotel() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 4){
                    player.setCash(player.getCash() - ((Land) this).getRent_4());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent_4());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent_4() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 3){
                    player.setCash(player.getCash() - ((Land) this).getRent_3());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent_3());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent_3() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 2){
                    player.setCash(player.getCash() - ((Land) this).getRent_2());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent_2());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent_2() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else if (((Land) this).getNumOfHouse() == 1){
                    player.setCash(player.getCash() - ((Land) this).getRent_1());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent_1());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent_1() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    player.setCash(player.getCash() - ((Land) this).getRent());
                    this.getOwner().setCash(this.getOwner().getCash() + ((Land) this).getRent());
                    JOptionPane.showMessageDialog(null,
                            "You paid "+ this.getOwner().getName() +" $"+ ((Land) this).getRent() + " rent.", "Pay rent", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }

    }


    //get
    public int getPrice(){
        return this.price;
    }
    public Player getOwner(){
        return this.owner;
    }

    public boolean getMonopoly(){
        return this.isMonopoly;
    }

    public boolean isMortgaged(){
        return this.isMortgaged;
    }

    public int getMortgageValue(){
        return this.mortgage;
    }

    //set
    public void setOwner(Player player){
        this.owner = player;
    }
    public void setMonopoly(boolean boo){
        this.isMonopoly = boo;
    }
    public void setMortgaged(boolean boo){this.isMortgaged = boo;}

}
