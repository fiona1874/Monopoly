package main;

public class RailRoad extends Property{
    private Player owner;
    private int rent, rent_2, rent_3, rent_4;
    private boolean isMonopoly, isMortgaged;
    public RailRoad(String name, int price, int mortgage, int rent, int rent_2, int rent_3, int rent_4){
        super(name, price, mortgage);
        this.owner = null;
        this.rent = rent;
        this.rent_2 = rent_2;
        this.rent_3 = rent_3;
        this.rent_4 = rent_4;
        this.isMonopoly = false;
        this.isMortgaged = false;
    }


}
