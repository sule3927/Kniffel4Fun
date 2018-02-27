package com.example.su.kniffel4fun;

import java.util.Arrays;

/**
 * Created by Merle on 26.02.2018.
 */



public class checkDice {

    /*testweise Befüllung des Arrays*/
    int[] dice = {2,2,2,2,2};

    /*
    * public method checkNumber
    * @author: Merle Friedrichsen
    * @params: dice-pips (Würfelaugen) that the user wants to count
    * @return: number of dices that show the number of pips / 0 if no dice shows number of pips*/
    public int checkNumber (int number) {
        int i;
        int returnvalue = 0;
        for(i =0; i<5 ; i++)
        {
            if (dice[i] == number) {
                returnvalue += 1;
            }
        }
        return returnvalue;
    }

    /*
    * public method checkFullhouse, checks if the dices fullfill the requirements of a fullhouse
    * @author: Merle Friedrichsen
    * @return: points for fullhouse / 0 if no no fullhouse*/
    public int checkFullhouse () {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[3] == dice[4]) && ((dice[2] == dice[1]) || (dice[2] == dice[3]))){
            return 25;
        } else {
            return 0;
        }
    }


    /*
    * public method check3OfAKind, checks if the dices fullfill the requirements of 3 of a kind
    * @author: Judith Balss
    * @return: points for 3 of a kind  / 0 if not 3 of a kind or more*/
    public int check3OfAKind () {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) || (dice[1] == dice[2]) && (dice[1] == dice [3]) || (dice[2] == dice[3]) && (dice[2] == dice [4])){
            int sum = 0;
            for (int i : dice) {
                sum += i;
            }
            return sum;
        } else {
            return 0;
        }
    }

    /*
    * public method check4OfAKind, checks if the dices fullfill the requirements of 4 of a kind
    * @author: Judith Balss
    * @return: points for 4 of a kind  / 0 if not 4 of a kind or more*/
    public int check4OfAKind () {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) && (dice[0] == dice[3]) || (dice[1] == dice[2]) && (dice[1] == dice [3]) && (dice[1] == dice[4])){
            int sum = 0;
            for (int i : dice) {
                sum += i;
            }
            return sum;
        } else {
            return 0;
        }
    }

    /*
    * public method checkYatzy, checks if the dices fullfill the requirements of a yatzy
    * @author: Judith Balss
    * @return: points for yatzy  / 0 if not a yatzy */
    public int checkYatzy () {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) && (dice[0] == dice[3]) && (dice[0] == dice[4])){
            return 50;
        } else {
            return 0;
        }
    }

    /*
    * public method check4OfAKind, checks if the dices fullfill the requirements of 4 of a kind
    * @author: Judith Balss
    * @return: points for 4 of a kind  / 0 if not 4 of a kind or more*/
    public int checkChance () {
        int sum = 0;
        for (int i : dice) {
            sum += i;
        }
        return sum;

    }


}
