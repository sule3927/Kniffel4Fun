package com.example.su.kniffel4fun;

/**
 * Created by judith on 28.02.2018.
 */

public class Player {
    public class player {
        private String name = "";
        private int highscore = 0;


        public int[] scores = new int[13];


        public String getName() {
            return name;
        }

        public player (String newName) {
            name = newName;
        }

    }

}
