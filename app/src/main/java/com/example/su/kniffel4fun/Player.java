package com.example.su.kniffel4fun;

import java.util.ArrayList;

/**
 * Created by judith on 28.02.2018.
 */

public class Player {
       private String name = "";
       private int highscore = 0;
       public int[] scores = new int[13];
       public static ArrayList<Player> allPlayers = new ArrayList<Player>();

       /*constructor*/
       public Player (String newName) {
            name = newName;
            allPlayers.add(this);
        }

       /*methods*/
       public String getName() {
            return name;
        }

       /*methos getPoints
       * return int -> the points at the arraypostition
       * param: Player and arrayIndex -> the position where the value is saved*/
       public int getPoints(Player player, int arrayIndex){
          return player.scores[arrayIndex];

       }
}
