package com.example.su.kniffel4fun;

import java.util.Arrays;

/**
 * Created by Merle on 26.02.2018.
 */



public class checkDice {

    /*testweise BefÃ¼llung des Arrays*/
    //int[] dice = {5,2,3,4,2};

    /*
    * public method checkNumber
    * @author: Merle Friedrichsen
    * @params: dice-pips (WÃ¼rfelaugen) that the user wants to count
    * @return: number of dices that show the number of pips / 0 if no dice shows number of pips*/
    public static int checkNumber(int number, int[] dice) {
        int i;
        int returnvalue = 0;
        int sum = 0;
        int arrayIndex = number - 1;
        for (i = 0; i < 5; i++) {
            if (dice[i] == number) {
                returnvalue += 1;
                sum = returnvalue*number;
            }
        }
        return sum;
        //PlayGame.getCurrPlayer().setPoints(sum, arrayIndex);
    }

    /*
    * public method checkFullhouse, checks if the dices fullfill the requirements of a fullhouse
    * @author: Merle Friedrichsen
    * @return: points for fullhouse / 0 if no no fullhouse*/
    public static int checkFullhouse (int[]dice) {

        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[3] == dice[4]) && ((dice[2] == dice[1]) || (dice[2] == dice[3]))){
            //PlayGame.getCurrPlayer().setPoints(25,8);
            return 25;
        } else {
            return 0;
        }
    }


    /*
    * public method check3OfAKind, checks if the dices fullfill the requirements of 3 of a kind
    * @author: Judith Balss
    * @return: points for 3 of a kind  / 0 if not 3 of a kind or more*/
    public static int check3OfAKind(int[] dice) {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) || (dice[1] == dice[2]) && (dice[1] == dice [3]) || (dice[2] == dice[3]) && (dice[2] == dice [4])){
            int sum = 0;
            for (int i : dice) {
                sum += i;
            }
            return sum;
            //PlayGame.getCurrPlayer().setPoints(sum,6);

        } else {
            return 0;
           // PlayGame.getCurrPlayer().setPoints(1000,6);
        }
    }

    /*
    * public method check4OfAKind, checks if the dices fullfill the requirements of 4 of a kind
    * @author: Judith Balss
    * @return: points for 4 of a kind  / 0 if not 4 of a kind or more*/
    public static int check4OfAKind (int [] dice) {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) && (dice[0] == dice[3]) || (dice[1] == dice[2]) && (dice[1] == dice [3]) && (dice[1] == dice[4])){
            int sum = 0;
            for (int i : dice) {
                sum += i;
            }
            return sum;
            //PlayGame.getCurrPlayer().setPoints(sum,7);
        } else {
            return 0;
            //PlayGame.getCurrPlayer().setPoints(1000,7);
        }
    }

    /*
    * public method checkYatzy, checks if the dices fullfill the requirements of a yatzy
    * @author: Judith Balss
    * @return: points for yatzy  / 0 if not a yatzy */
    public static int checkYatzy (int [] dice) {
        Arrays.sort(dice);
        if ((dice[0] == dice[1]) && (dice[0] == dice [2]) && (dice[0] == dice[3]) && (dice[0] == dice[4]) && dice[0]>0){
            return 50;
            //PlayGame.getCurrPlayer().setPoints(50,11);
        } else {
            return 0;
            //PlayGame.getCurrPlayer().setPoints(1000,11);
        }
    }

    /*
    * public method check4OfAKind, sums all pips of the selceted dices as a chance
    * @author: Judith Balss
    * @return: points for 4 of a kind  / 0 if not 4 of a kind or more*/
    public static int checkChance (int [] dice) {
        int sum = 0;
        for (int i : dice) {
            sum += i;
        }
        return sum;
        //PlayGame.getCurrPlayer().setPoints(sum,12);

    }

    /*
    * public method checkSmallStraight (kleine StraÃŸe), checks if the dices fullfill the requirements of a smallStraight
    * @author: Merle Friedrichsen
    * @return: points for smallStraight / 0 if no smallStraight*/
    public static int checkSmallStraight (int [] dice) {
        Arrays.sort(dice);
        int longestRow = 1;
        int i;
        for (i = 0; i < 4; i++) {
            int distance = dice[i+1] - dice[i];
            if (distance == 1) {
                longestRow++;
            } else if (distance >=1) {
                longestRow = 1;
            }
        }
        if (longestRow >= 4) {
            return 30;
            //PlayGame.getCurrPlayer().setPoints(30,9);
        } else {
            return 0;
            //PlayGame.getCurrPlayer().setPoints(1000,9);
        }
    }

    /*
    * public method checkLargeStraight (groÃŸe StraÃŸe), checks if the dices fullfill the requirements of a LargeStraight
    * @author: Merle Friedrichsen
    * @return: points for LargeStraight / 0 if no no LargeStraight*/
    public static int checkLargeStraight (int []dice) {
        Arrays.sort(dice);
        boolean largeStraight = true;
        int i = 0;
        while ((largeStraight == true) && (i <= 3)){
            if (dice[i]+1 != dice [i+1]){
                largeStraight = false;
            }
            i++;
        }

        if (largeStraight == true) {
            return 40;
            //PlayGame.getCurrPlayer().setPoints(40,10);
        } else {
            return 0;
            //PlayGame.getCurrPlayer().setPoints(1000,10);
        }
    }

}
