package main;

import javax.swing.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private int cash, doublesRolled, currentPos, numOfHouse, numOfHotel, jailRound;
    private boolean isInJail, isDouble, JailFreeCard;
    private Dice dice;
    private ArrayList<Property> propertyOwned;
    public Player() {
        this.name = "Player1";
        this.cash = 1500;
        this.doublesRolled = 0;
        this.currentPos = 0;
        this.numOfHouse = 0;
        this.numOfHotel = 0;
        this.jailRound = 0;
        this.isInJail = false;
        this.isDouble = false;
        this.JailFreeCard = false;
        propertyOwned = new ArrayList<>();
    }

    public void forward(){
        if (this.currentPos <39){
            this.currentPos++;
        }
        else {
            this.currentPos = 0;
            JOptionPane.showMessageDialog(null,
                    "You passed GO! Received $200 salary", "Go!",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setCash(getCash() + 200);
        }
    }

    public int rollDice() {
        dice = new Dice();
        int dice1 = dice.roll();
        int dice2 = dice.roll();
       if (dice1 == dice2){
           this.setIsDouble(true);
           this.setDoublesRolled(this.getDoublesRolled() + 1);
       }
       else {
           this.setIsDouble(false);
           this.setDoublesRolled(0);
       }
        return dice1+dice2;
    }

    public void getMortgage(){
        ArrayList<Property> properties = this.getPropertyOwned();
        ArrayList<Property> notMortgaged = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        int resp = 0;
        while (resp == 0){
            if (properties.size() != 0){
                for (Property p : properties){
                    if (!p.isMortgaged()){
                        notMortgaged.add(p);
                    }
                }
                if (notMortgaged.size() > 0){
                    String[] pNames = new String[notMortgaged.size()];
                    for (int i = 0; i < pNames.length; i++) {
                        pNames[i] = notMortgaged.get(i).getName(); //create an array of property names to choose from
                        names.add(notMortgaged.get(i).getName()); //to help get the index
                    }

                    String s = (String) JOptionPane.showInputDialog(null, "Get mortgage from which property?",
                            "Get Mortgage", JOptionPane.QUESTION_MESSAGE, null, pNames, 0);
                    if (names.contains(s)){
                        for (Property p : this.getPropertyOwned()){
                            if (p.getName() == s){
                                p.setMortgaged(true);
                                this.setCash(this.getCash() + p.getMortgageValue());
                            }
                        }

                        notMortgaged.clear();
                        for (Property p : this.getPropertyOwned()){
                            if (!p.isMortgaged()){
                                notMortgaged.add(p);
                            }
                        }
                        resp = JOptionPane.showConfirmDialog(null,
                                "Continue to take mortgage?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
                    }

                }
                else return;

            }
            else {
                JOptionPane.showMessageDialog(null,
                        "No property!",
                        "Get Mortgage", JOptionPane.WARNING_MESSAGE);
            }

        }


    }

    public void inJail(){
        if (this.getJailFreeCard()){
            String[] opt = {"Use get out of jail free card", "Try to roll doubles", "Pay $50."};
            String ans = (String) JOptionPane.showInputDialog(null, "Select an option below",
                    "Jail", JOptionPane.QUESTION_MESSAGE, null, opt,0);
            if (this.getJailRound() < 3 ){
                if (ans.startsWith("Use")){
                    this.setJailFreeCard(false);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You used a Get out of jail free card! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (ans.startsWith("Pay")){
                    this.setCash(this.getCash() - 50);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You just payed $50! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if (this.getIsDouble()){
                        this.setInJail(false);
                        this.setDoublesRolled(0);
                        this.setIsDouble(false);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You rolled a double! " , "Success!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        this.setJailRound(this.getJailRound() + 1);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You did not roll double! " , "failed!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            else {
                if (ans.startsWith("Use")){
                    this.setJailFreeCard(false);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You used a Get out of jail free card! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (ans.startsWith("Pay")){
                    this.setCash(this.getCash() - 50);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You just payed $50! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    this.setInJail(false);
                    if (!this.getIsDouble()){
                        this.setCash(this.getCash() - 50);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You did not roll double! You payed $50! " , "Failed!" ,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        this.setDoublesRolled(0);
                        this.setIsDouble(false);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You rolled a double! " , "Success!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        else {
            String[] opt = {"Try to roll doubles", "Pay $50."};
            String ans = (String) JOptionPane.showInputDialog(null, "Select an option below",
                    "Jail", JOptionPane.QUESTION_MESSAGE, null, opt,0);
            if (this.getJailRound() < 3 ){
                if (ans.startsWith("Pay")){
                    this.setCash(this.getCash() - 50);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You just payed $50! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if (this.getIsDouble()){
                        this.setInJail(false);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You rolled a double! " , "Success!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        this.setJailRound(this.getJailRound() + 1);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You did not roll double! Stay in jail." , "failed!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            else {
                if (ans.startsWith("Pay")){
                    this.setCash(this.getCash() - 50);
                    this.setInJail(false);
                    this.setJailRound(0);
                    JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You just payed $50! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    this.setInJail(false);
                    if (!this.getIsDouble()){
                        this.setCash(this.getCash() - 50);
                        JOptionPane.showMessageDialog(null,
                                this.getName()
                                        + ": You did not roll double! You payed $50! " , "Failed!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                            this.getName()
                                    + ": You rolled a double! " , "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }
        System.out.println("Is in jail? " + this.getInJail());
    }

    public boolean checkBankruptcy(){
        if (this.getCash() < 0) {
            int ans = JOptionPane.showConfirmDialog(null,this.getName()+
                    ": Take out mortgage?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
            while (ans == 0) {
                    this.getMortgage();
                    ans = JOptionPane.showConfirmDialog(null,
                            "Continue?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
                }
            if (this.getCash() >= 0){
                return false;
            }
            else return true;
        }
        else
        return false;
    }

    public void incomeTax(){
        int totalAsset = 0;
        String[] opt = {"Pay 10%", "Pay $200"};
        int ans = JOptionPane.showOptionDialog(null,
                "Pay income tax:",
                "Income tax",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,opt,0);
        if (ans == 1){
            this.setCash(this.getCash() - 200);
            JOptionPane.showMessageDialog(null,
                    "You paid $200 income tax!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }
        else {
            for (Property p : this.propertyOwned){
                if (p.isMortgaged()){
                    totalAsset += p.getMortgageValue();
                }
                else
                {
                    totalAsset += p.getPrice();
                }
                if (p instanceof Land){
                    totalAsset += ((Land) p).getNumOfHouse() * ((Land) p).getHousePrice();
                    if (((Land) p).getHasHotel()){
                        totalAsset += ((Land) p).getHotelPrice();
                    }
                }
            }
            this.setCash(this.getCash() - (totalAsset + this.getCash()) / 10);
            JOptionPane.showMessageDialog(null,
                    "You paid $" + (totalAsset + this.getCash()) / 10+ " income tax!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }


    }


    //get
    public String getName(){return this.name;}

    public int getCurrentPos(){
        return this.currentPos;
    }

    public int getCash(){
        return this.cash;
    }

    public boolean getJailFreeCard() { return this.JailFreeCard; }

    public boolean getInJail(){return this.isInJail;}

    public int getNumOfHouse() {return this.numOfHouse;}

    public int getNumOfHotel() {return this.numOfHotel;}

    public int getDoublesRolled() {
        return this.doublesRolled;
    }

    public ArrayList<Property> getPropertyOwned(){
        return this.propertyOwned;
    }

    public int getJailRound(){
        return this.jailRound;
    }

    public boolean getIsDouble(){
        return this.isDouble;
    }

    //set
    public void setCurrentPos(int position){
        this.currentPos = position;
    }

    public void setCash(int cash){
        this.cash = cash;
    }

    public void setJailFreeCard(boolean bool){
        this.JailFreeCard = bool;
    }

    public void setInJail(boolean bool){
        this.isInJail = bool;
    }

    public void setDoublesRolled(int num){
        this.doublesRolled = num;
    }

    public void addPropertyOwned(Property property){
        this.propertyOwned.add(property);
    }

    public void setJailRound(int num){
        this.jailRound = num;
    }

    public void setIsDouble(boolean boo){
        this.isDouble = boo;
    }

    public void setName(String name){
        this.name = name;
    }

}
