package com.example.su.kniffel4fun;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Judith Balß on  28.02.2018.
 * @version 1
 *          describes an object Player
 *          a Player has a name, an avatarID that point to an Image,
 *          an array scoreSet of booleans that describes which scores have been set (f.ex if the player had 3 of a Kind),
 *          an array scores with the points the player made,
 *          an array where the final scores of the Player are saved
 *          and each Player is added to an ArrayList of Players
 */
public class Player {
    private String name = "";
    private int avatarID = 0;
    public boolean[] scoreSet = new boolean[13];
    public int[] scores = new int[13];
    public int[] finalScore = new int[5];
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    /**
     * constructor to create new Player,
     * fills the array scoreSet with false because the new player can not have any points yet,
     * adds the player to the arrayList allPlayers
     *
     * @param newName  with the name of the player
     * @param avatarID with the ID of the Image of the avatar
     */
    public Player(String newName, int avatarID) {
        this.name = newName;
        this.avatarID = avatarID;
        Arrays.fill(this.scoreSet, Boolean.FALSE);
        allPlayers.add(this);
    }

    /**
     * method to get the name of a player
     *
     * @return String, the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * method to get the ID of the Avatar of the Player
     *
     * @return int, the ID of the Image
     */
    public int getAvatarID() {
        return avatarID;
    }

    /**
     * * methods  that returns the point at a given position of the array scores
     *
     * @param arrayIndex -> the position where the value is saved
     * @return the points at the arraypostition
     */
    public int getPoints(int arrayIndex) {
        return this.scores[arrayIndex];
    }

    /**
     * method to set the points at a given position of the array scores
     *
     * @param points     that are to be set
     * @param arrayIndex the position of the array
     */
    public void setPoints(int points, int arrayIndex) {
        this.scores[arrayIndex] = points;
        this.scoreSet[arrayIndex] = true;
    }

    /**
     * method that return true if the score has been set
     *
     * @param arrayIndex the position of the array scoreSet
     * @return true if scores have been set, false if no result has been set yet
     */
    public boolean isScoresSet(int arrayIndex) {
        return this.scoreSet[arrayIndex];
    }

    /**
     * method that returns the array finalScore
     *
     * @param arrayIndex the index of array finalscore
     * @return the points that are saved at index position
     */
    public int getFinalScore(int arrayIndex) {
        return this.finalScore[arrayIndex];
    }
}