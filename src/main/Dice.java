package main;

public class Dice {
    private final int min,max;
    public Dice(){
        min = 1;
        max = 6;
    }

    public int roll(){
        return (int) Math.floor(Math.random() * (max) ) + min;
    }
}
