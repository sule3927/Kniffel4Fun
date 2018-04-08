package com.example.su.kniffel4fun;

/**
 * @author Judith Balß on 06.03.2018.
 */

/**
 * the class PlayGame is the model,
 * it includes an object currPlayer that points to the current Player,
 * an object currTurn, that points to the current turn,
 * and it counts the played rounds
 */
public class PlayGame {
    private static Player currPlayer;
    private static turn currTurn;
    private static int countRounds = 0;

    /**
     * constructor of a PlayGame,
     * creates a new turn, set the newly created turn to currTurn,
     * und sets the first Player from the arrayList allPlayers to the current Player
     */
    public PlayGame() {
        turn turn = new turn();
        setCurrTurn(turn);
        setCurrPlayer(Player.allPlayers.get(0));
    }

    /**
     * method to get how many rounds have been player
     *
     * @return int, the number of played rounds
     */
    public static int getCountRounds() {
        return countRounds;
    }

    /**
     * method to return the currently Player-Object
     *
     * @return Player who is playing
     */
    public static Player getCurrPlayer() {
        return currPlayer;
    }

    /**
     * method to declare which is the current player
     *
     * @param currPlayer Player whos turn it shall be
     */
    public static void setCurrPlayer(Player currPlayer) {
        PlayGame.currPlayer = currPlayer;
    }

    /**
     * method to get the current player
     *
     * @return Player whos turn it is
     */
    public static turn getCurrTurn() {
        return currTurn;
    }

    /**
     * method to set the current turn
     *
     * @param currTurn
     */
    public static void setCurrTurn(turn currTurn) {
        PlayGame.currTurn = currTurn;
    }

    /**
     * method to change the player,
     * creates a new turn and sets it a current turn,
     * sets the next player as current player,
     * it the end of the arrayList allPlayers is reached, it switches to the first player and increments contRounds
     */
    public static void changePlayer() {
        turn turn = new turn();
        setCurrTurn(turn);
        Player currPlayer = PlayGame.getCurrPlayer();
        int indexNext = 1 + Player.allPlayers.indexOf(currPlayer);
        if (indexNext == Player.allPlayers.size()) {
            indexNext = 0;
            PlayGame.countRounds++;
        }
        Player nextPlayer = Player.allPlayers.get(indexNext);
        PlayGame.setCurrPlayer(nextPlayer);
    }

    /**
     * this method interates over allPlayers and calculates the results
     */
    public static void nextResult() {
        int thisPlayer = 0;
        while (thisPlayer < Player.allPlayers.size()) {
            Player nextPlayer = Player.allPlayers.get(thisPlayer);
            PlayGame.setCurrPlayer(nextPlayer);
            calculateResult();
            thisPlayer++;
        }
    }

    /**
     * this method calculates the end-result for the current Player
     */
    public static void calculateResult() {
        int[] scores = currPlayer.scores;
        int sumTop = scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + scores[5];
        currPlayer.finalScore[0] = sumTop;
        int sumBottom = scores[6] + scores[7] + scores[8] + scores[9] + scores[10] + scores[11];
        currPlayer.finalScore[2] = sumBottom;
        if (sumTop >= 63) {
            currPlayer.finalScore[1] = 35;
        } else {
            currPlayer.finalScore[1] = 0;
        }
        currPlayer.finalScore[3] = scores[12];
        currPlayer.finalScore[4] = currPlayer.finalScore[0] + currPlayer.finalScore[1] + currPlayer.finalScore[2] + currPlayer.finalScore[3];
    }
}
