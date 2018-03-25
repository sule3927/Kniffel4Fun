package com;

/**
 * Created by judith on 06.03.2018.
 */

public class PlayGame {

    public void playGame (int numberOfPlayers){
        for (int playedRounds = 0; playedRounds <= 13; playedRounds ++){
            for (int currentPlayer = 0; currentPlayer <= numberOfPlayers; currentPlayer ++ ) {


            }
        }
    }

    public void rollThisDice () {
        //nicht ausgewählte Würfel würfeln
    }

    public void pickDice () {
        //Würfel auswählen
    }

    public void setScoreNull (){
        // alertDialog "Möchtest du den ... streichen?"
    }


    int[] scores = {4,8,6,12,15,12,19,0,25,30,0,50,24};

    public int calculateResult () {
        int sumTotal = 0;

        for (int i : scores) {
            sumTotal += i;
        }

        int sumTop = scores[0]+scores[1]+scores[2]+scores[3]+scores[4]+scores[5];

        if (sumTop>=63){
            sumTotal+=35;
        }
        return sumTotal;
    }

}
