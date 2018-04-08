package com.example.su.kniffel4fun;

/**
 * @author Merle Friedrichsen on 25.03.2018.
 * @version 1
 */
public class turn {
    private dice dice1 = new dice();
    private dice dice2 = new dice();
    private dice dice3 = new dice();
    private dice dice4 = new dice();
    private dice dice5 = new dice();
    private int[] allDice;
    private int countRolls;
    private boolean scored = false;

    /*
    * Constructor to create a new turn
    * sets countRolls to 0, and fills the array allDice with the pipes currently shown
     */
    public turn() {
        this.countRolls = 0;
        this.setAllDice();
    }
    /*
    * method to return dice1
    * @return dice1
     */
    public dice getDice1() {
        return dice1;
    }

    /*
    * method to return dice2
    * @return dice2
     */
    public dice getDice2() {
        return dice2;
    }

    /*
    * method to return dice3
    * @return dice3
     */
    public dice getDice3() {
        return dice3;
    }

    /*
     * method to return dice4
     * @return dice4
      */
    public dice getDice4() {
        return dice4;
    }

    /*
    * method to return dice5
    * @return dice5
     */
    public dice getDice5() {
        return dice5;
    }

    /*
    * method to return the array allDice
    * @return an array of five integers that represent the pipes of the dice
     */
    public int[] getAllDice() {
        return allDice;
    }

    /*
    * method to fill the array allDice with the pipes of the dices
     */
    public void setAllDice() {
        int pipesDice1 = dice1.getPipes();
        int pipesDice2 = dice2.getPipes();
        int pipesDice3 = dice3.getPipes();
        int pipesDice4 = dice4.getPipes();
        int pipesDice5 = dice5.getPipes();
        int[] allDice = {pipesDice1,pipesDice2,pipesDice3,pipesDice4,pipesDice5};
        this.allDice = allDice;
    }

    /*
    * method to return false, if no score has been set during this turn
    * @return boolean, that indicates whether a score has been set of not
     */
    public boolean isScored() {
        return scored;
    }

    /*
    * method to set the boolean scored, that indicates if a score has been set during the turn
    * @param boolean true if score has been set, false if no score has been set
     */
    public void setScored(boolean scored) {
        this.scored = scored;
    }

    /*
    * method to get how often the dice have been rolled during the turn
    * @return int, the times that the dice have been rolled
     */
    public int getCountRolls() {
        return countRolls;
    }

    /*
    * method to set how often the dice have been rolled during this turn
    * @param int, how often the dice have been turned
     */
    public void setCountRolls(int countRolls) {
        this.countRolls = countRolls;
    }

    /*
    * method to roll all 5 dices of the turn.
    * Note that dices may be set to rollable = false and thus do not get rolled
    * method also increments countRolls (the times the dice have been rolled)
    * and fills the array allDice with the current pipes that are shown
     */
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
