package com.example.su.kniffel4fun;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Merle on 28.02.2018.
 */

public class dice {
    //Attributes
    private int pipes;
    private boolean rollable;
    private Random randomGenerator;






    //constructor
    public dice() {
        this.pipes = 0;
        this.rollable = true;
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

    /*public method rollDice
    * generates a random number between 1 and 6 (like a dice)
    * and sets the pipes of the dice*/


    public void rollThisDice() {

        if (this.isRollable() == true){
            randomGenerator = new Random();
            setPipes(randomGenerator.nextInt(6) + 1);
            System.out.println(getPipes());



        }
    }
}

