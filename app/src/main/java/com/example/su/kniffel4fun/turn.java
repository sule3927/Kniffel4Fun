package com.example.su.kniffel4fun;

/**
 * Created by Merle on 25.03.2018.
 */

public class turn {
    private dice dice1 = new dice();
    private dice dice2 = new dice();
    private dice dice3 = new dice();
    private dice dice4 = new dice();
    private dice dice5 = new dice();
    private int[] allDice;
    private int countRolls;

    //constructor
    public turn() {
        this.countRolls = 0;
        this.setAllDice();
    }

    public dice getDice1() {
        return dice1;
    }

    public void setDice1(dice dice1) {
        this.dice1 = dice1;
    }

    public dice getDice2() {
        return dice2;
    }

    public void setDice2(dice dice2) {
        this.dice2 = dice2;
    }

    public dice getDice3() {
        return dice3;
    }

    public void setDice3(dice dice3) {
        this.dice3 = dice3;
    }

    public dice getDice4() {
        return dice4;
    }

    public void setDice4(dice dice4) {
        this.dice4 = dice4;
    }

    public dice getDice5() {
        return dice5;
    }

    public void setDice5(dice dice5) {
        this.dice5 = dice5;
    }

    public int[] getAllDice() {
        return allDice;
    }

    public void setAllDice() {
        int pipesDice1 = dice1.getPipes();
        int pipesDice2 = dice2.getPipes();
        int pipesDice3 = dice3.getPipes();
        int pipesDice4 = dice4.getPipes();
        int pipesDice5 = dice5.getPipes();
        int[] allDice = {pipesDice1,pipesDice2,pipesDice3,pipesDice4,pipesDice5};
        this.allDice = allDice;
    }

    public int getCountRolls() {
        return countRolls;
    }

    public void setCountRolls(int countRolls) {
        this.countRolls = countRolls;
    }

    public void rollAllDice(){
        if (this.getCountRolls() <=2) {
            dice1.rollThisDice();
            dice2.rollThisDice();
            dice3.rollThisDice();
            dice4.rollThisDice();
            dice5.rollThisDice();
            this.setCountRolls(this.getCountRolls() + 1);
            this.setAllDice();
        }
    }

}