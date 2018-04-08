package com.example.su.kniffel4fun;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by judith on 28.02.2018.
 */

public class Player {
    private String name = "";
    private int avatarID = 0;
    public boolean[] scoreSet = new boolean[13];
    public int[] scores = new int[13];
    public int[] finalScore = new int[5];
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    /*constructor*/
    public Player(String newName, int avatarID) {
        this.name = newName;
        this.avatarID = avatarID;
        Arrays.fill(this.scoreSet, Boolean.FALSE);
        allPlayers.add(this);
    }

    /*methods*/
    public String getName() {
        return name;
    }

    public int getAvatarID() {
        return avatarID;
    }

    /*methos getPoints
               * return int -> the points at the arraypostition
               * param: Player and arrayIndex -> the position where the value is saved*/
    public int getPoints(int arrayIndex) {
        return this.scores[arrayIndex];
    }

    public void setPoints(int points, int arrayIndex) {
        this.scores[arrayIndex] = points;
        this.scoreSet[arrayIndex] = true;
    }

    public boolean isScoresSet(int arrayIndex) {
        return this.scoreSet[arrayIndex];
    }

    /*methods finalScore*/
    public int getFinalScore(int arrayIndex) {
        return this.finalScore[arrayIndex];
    }
}