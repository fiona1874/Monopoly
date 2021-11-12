package main;


public class Utility extends Property{
    private boolean isMonopoly;
    private Player owner;
    public Utility(String name, int price, int mortgage) {
        super(name, price, mortgage);
        this.owner = null;
        this.isMonopoly = false;
    }



}
