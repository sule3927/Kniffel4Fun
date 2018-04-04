package com.example.su.kniffel4fun;

import java.util.ArrayList;

/**
 * Created by judith on 28.02.2018.
 */

public class Player {
       private String name = "";
       private int highscore = 0;
       private int avatarID = 0;
       public int[] scores = new int[13];
       public int [] finalScore = new int[5];
       public static ArrayList<Player> allPlayers = new ArrayList<Player>();
       private static int numberOfPlayer;

       /*constructor*/
       public Player (String newName) {
            this.name = newName;
        this.avatarID = 2131099732;
        allPlayers.add(this);
        numberOfPlayer++;
       }

    public Player(String newName, int avatarID) {
        this.name = newName;
        this.avatarID = avatarID;
        allPlayers.add(this);
    }

       /*methods*/
       public String getName() {
            return name;
        }

    public static int getNumberOfPlayer(){return numberOfPlayer;}

    public int getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(int avatarID) {
        this.avatarID = avatarID;
    }

    /*methos getPoints
               * return int -> the points at the arraypostition
               * param: Player and arrayIndex -> the position where the value is saved*/
       public int getPoints(int arrayIndex){
        return this.scores[arrayIndex];
    }

    public void setPoints(int points, int arrayIndex){
        this.scores[arrayIndex] = points;      }


    /*methods finalScore*/

    public int getFinalScore(int arrayIndex){
        return this.finalScore[arrayIndex];
    }

    public void setFinalScore(int finalPoints, int arrayIndex){
        this.finalScore[arrayIndex] = finalPoints;      }
}
