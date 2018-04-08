package com.example.su.kniffel4fun;

import java.util.Random;

/**
 * @author Merle Friedrichsen on 28.02.2018.
 * @version 1
 * class describes the object Dice and its methods
 * a Dice shows a number between 1-6 called pipes
 * a Dice may be rollable or not
 */
public class dice {
    private int pipes;
    private boolean rollable;
    private Random randomGenerator;

    /*
    * contructor
    * creates a new object dice,
    * set pipes to 0 (because the dice has not been rolled yet)
    * the dice is rollable
     */
    public dice() {
        this.pipes = 0;
        this.rollable = true;
    }

    /*
    * method that return the pipes a dice is showing (between 1-6, or 0 if haven't been rolled yet)
    * @return int, pipes
     */
    public int getPipes() {
        return pipes;
    }

    /**
     *method to set the pipes that are shown (the number that has been rolled)
     * @param pipes
     */
    public void setPipes(int pipes) {
        this.pipes = pipes;
    }

    /*
    *method that return if a dice is rollable or not
    * a dice is not rollable if tha player decides to keep the result of the dice
    * @return boolean, true if rollable, false if not
     */
    public boolean isRollable() {
        return rollable;
    }

    /*
    * method to set if a dice is rollable or not
    * a player can decide to  keep the result of a dice and to no roll it again
    * @param boolean, true if rollable, false if not
     */
    public void setRollable(boolean rollable) {
        this.rollable = rollable;
    }

    /*public method rollDice
    * generates a random number between 1 and 6 (like a dice)
    * and sets the pipes of the dice
    */
    public void rollThisDice() {
        if (this.isRollable() == true){
            randomGenerator = new Random();
            setPipes(randomGenerator.nextInt(6) + 1);
        }
    }
}

