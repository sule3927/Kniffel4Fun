package com.example.su.kniffel4fun;

/**
 * Created by judith on 06.03.2018.
 */

import android.util.Log;

public class PlayGame {
    private static Player currPlayer;
    private static turn currTurn;
    private static int countRounds = 0;

    public PlayGame() {
        turn turn = new turn();
        setCurrTurn(turn);
    }

    public static int getCountRounds () {return countRounds; }

    public static Player getCurrPlayer() {
        return currPlayer;
    }

    public static void setCurrPlayer(Player currPlayer) {
        PlayGame.currPlayer = currPlayer;
    }

    public static turn getCurrTurn() {
        return currTurn;
    }

    public static void setCurrTurn(turn currTurn) {
        PlayGame.currTurn = currTurn;
    }

    public static void changePlayer(){
        turn turn = new turn();
        setCurrTurn(turn);
        Player currPlayer = PlayGame.getCurrPlayer();
        int indexNext = 1+Player.allPlayers.indexOf(currPlayer);
        //wenn Ende des Array erreicht, fange von vorne an
        if (indexNext == Player.allPlayers.size()){
            indexNext = 0;
            PlayGame.countRounds++;
        }
        Player nextPlayer = Player.allPlayers.get(indexNext);
        PlayGame.setCurrPlayer(nextPlayer);
        }

    /*this method creates two players for test purposes*/
    public int testPlayer() {
        Player player1 = new Player("Susann", 2131099732);
        Player player2 = new Player("Judith", 2131099758);
        setCurrPlayer(Player.allPlayers.get(0));
        //player1.setPoints(3, 0);
        //player2.setPoints(4, 0);
        //turn turn = new turn();
        //setCurrTurn(turn);
        return 12; /*dieser Returnwert wird nicht gebraucht, allerdings funktionierte die Methode nur, wenn ich einer Varaiblen den WErt zuweise*/
    }


    public static void calculateResult(){
            turn turn = new turn();
            setCurrTurn(turn);
            Player currPlayer = PlayGame.getCurrPlayer();
            int [] scores = currPlayer.scores;
            int sumTop = scores[0]+scores[1]+scores[2]+scores[3]+scores[4]+scores[5];
            currPlayer.finalScore[1] = sumTop;
            int sumBottom = scores[6]+scores[7]+scores[8]+scores[9]+scores[10]+scores[12];
            currPlayer.finalScore[2] = sumBottom;
            if (sumTop>=63) {
                currPlayer.finalScore[1] = 35;
            }
            else {
                currPlayer.finalScore[1] = 0;
            }
            currPlayer.finalScore[3] = scores[11];
            currPlayer.finalScore[4] = currPlayer.finalScore[0] +currPlayer.finalScore[1]+currPlayer.finalScore[2]+currPlayer.finalScore[3];
            Log.d("SENSO", getCurrPlayer()+ " oben" +currPlayer.finalScore[0] + " bonus "+ currPlayer.finalScore[1] + " unten "+ currPlayer.finalScore[2] + " Kniffel "+ currPlayer.finalScore[3] + " Total "+ currPlayer.finalScore[4]);
            int indexNext = 1+Player.allPlayers.indexOf(currPlayer);
            Player nextPlayer = Player.allPlayers.get(indexNext);
            PlayGame.setCurrPlayer(nextPlayer);
            calculateResult();
        }
    }
