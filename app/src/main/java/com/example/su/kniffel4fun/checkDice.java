package com.example.su.kniffel4fun;

import java.util.Arrays;

/**
 * Created by Merle on 26.02.2018.
 */



public class checkDice {

    /*testweise Befüllung des Arrays*/
    int[] dice = {1,2,3,2,2};

    public int checkOne () {
        int i;
        int returnvalue = 0;
        for(i =0; i<5 ; i++)
        {
            if (dice[i] == 1) {
                returnvalue += 1;
            }
        }
        return returnvalue;
    }

    public int checkFullhouse () {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[3] == dice[4]) && ((dice[2] == dice[1]) || (dice[2] == dice[3]))){
            return 25;
        } else {
            return 0;
        }
    }



}
