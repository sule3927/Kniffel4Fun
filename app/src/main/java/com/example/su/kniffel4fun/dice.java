package com.example.su.kniffel4fun;

import java.util.Random;

/**
 * Created by Merle on 28.02.2018.
 */

public class dice {
    //Attributes
    private int pipes;
    private boolean rollable;
    private Random randomGenerator;
    private int countRolls;

    //contructors
    public dice() {
        pipes = 0;
        rollable = true;
        countRolls = 0;
    }

    //methods
    //getter and setter
    public int getPipes() {
        return pipes;
    }

    public void setPipes(int pipes) {
        this.pipes = pipes;
    }

    public boolean isRollable() {
        return rollable;
    }

    public void setRollable(boolean rollable) {
        this.rollable = rollable;
    }

    public int getCountRolls() {
        return countRolls;
    }

    public void setCountRolls(int countRolls) {
        this.countRolls = countRolls;
    }

    /*public method rollDice
    * generates a random number between 1 and 6 (like a dice)
    * and sets the pipes of the dice
    * counts how often the dice was rolled*/
    public void rollThisDice() {
        if (this.isRollable() == true && this.getCountRolls()< 3){
            randomGenerator = new Random();
            setPipes(randomGenerator.nextInt(6) + 1);
            setCountRolls(getCountRolls()+1);
        }
    }
}
