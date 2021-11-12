package main;

import javax.swing.*;

public class Land extends Property{
    private String color;
    private int rent, rent_1, rent_2, rent_3, rent_4, rent_hotel, housePrice, hotelPrice, numOfHouse;
    private boolean isMonopoly, isMortgaged, hasHotel;
    private Player owner;
    public Land(String name, String color, int price, int mortgage,
                    int rent, int rent_1, int rent_2, int rent_3, int rent_4, int rent_hotel,
                    int housePrice, int hotelPrice){
        super(name, price, mortgage);
        this.color = color;
        this.owner = null;
        this.rent = rent;
        this.numOfHouse = 0;
        this.rent_1 = rent_1;
        this.rent_2 = rent_2;
        this.rent_3 = rent_3;
        this.rent_4 = rent_4;
        this.rent_hotel = rent_hotel;
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.isMonopoly = false;
        this.isMortgaged = false;
        this.hasHotel = false;
    }

    public void buyHouseOrHotel(Player player){
        if (this.getHasHotel() == false && this.getNumOfHouse() <= 4){
            int ans = JOptionPane.showConfirmDialog(null,
                    "Buy house on this property?", "Buy house", JOptionPane.YES_NO_OPTION);
            if (ans == 0 && player.getCash() >= this.getHousePrice()){ //check for enough money to buy
                this.setNumOfHouse(getNumOfHouse() + 1);
                player.setCash(player.getCash() - this.getHousePrice());
                JOptionPane.showMessageDialog(null,
                        "You bought a house at "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
            else if (ans == 0 && player.getCash() < this.getHousePrice()){
                int ans2 = JOptionPane.showConfirmDialog(null,
                        "Take out mortgage?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
                if (ans2 == 0) {
                    if (player.getCash() < this.getHousePrice())
                        player.getMortgage();

                    if (player.getCash() > this.getHousePrice()){
                        this.setNumOfHouse(getNumOfHouse() + 1);
                        player.setCash(player.getCash() - this.getHousePrice());
                        JOptionPane.showMessageDialog(null,
                                "You bought a house at "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                                "Insufficient Fund!", "Failed", JOptionPane.INFORMATION_MESSAGE);
                }
                else return;

            }
            else return;
        }
        else if (!this.getHasHotel() && this.getNumOfHouse() == 4){
            int ans1 = JOptionPane.showConfirmDialog(null,
                    "Buy hotel on this property?", "Buy hotel", JOptionPane.YES_NO_OPTION);
            if (ans1 == 0 && player.getCash() >= this.getHotelPrice()){ //check for enough money to buy
                this.setHasHotel(true);
                player.setCash(player.getCash() - this.getHotelPrice());
                JOptionPane.showMessageDialog(null,
                        "You bought a hotel at "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
            else if (ans1 == 0 && player.getCash() < this.getHotelPrice()){
                int ans3 = JOptionPane.showConfirmDialog(null,
                        "Take out mortgage?", "Out of Cash!!", JOptionPane.YES_NO_OPTION);
                if (ans3 == 0) {
                    if (player.getCash() < this.getHotelPrice())
                        player.getMortgage();

                    if (player.getCash() > this.getHotelPrice()){
                        this.setHasHotel(true);
                        player.setCash(player.getCash() - this.getHotelPrice());
                        JOptionPane.showMessageDialog(null,
                                "You bought a hotel at "+this.getName()+ "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,
                                "Insufficient Fund!", "Failed", JOptionPane.INFORMATION_MESSAGE);
                }
                else return;
            }
            else return;
        }
        else return;
    }

    public String getColor(){
        return this.color;
    }

    public boolean hasHotel(){
        return this.hasHotel;
    }

    public int getNumOfHouse(){return this.numOfHouse;}

    public int getRent(){return this.rent;}

    public int getRent_1(){return this.rent_1;}

    public int getRent_2(){return this.rent_2;}

    public int getRent_3(){return this.rent_3;}

    public int getRent_4(){return this.rent_4;}

    public int getRent_hotel(){return this.rent_hotel;}

    public int getHousePrice(){return this.housePrice;}

    public int getHotelPrice(){return this.hotelPrice;}

    public boolean getHasHotel(){return this.hasHotel;}

    public void setNumOfHouse(int num){
        this.numOfHouse = num;
    }

    public void setHasHotel(boolean boo){
        this.hasHotel = boo;
    }

}
