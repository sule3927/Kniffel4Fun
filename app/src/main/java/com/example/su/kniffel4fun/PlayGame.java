package com.example.su.kniffel4fun;

/**
 * Created by judith on 06.03.2018.
 */

public class PlayGame {
    private static Player currPlayer;
    private static turn currTurn;
    private static int countRounds = 0;

    public PlayGame() {
        turn turn = new turn();
        setCurrTurn(turn);
        setCurrPlayer(Player.allPlayers.get(0));
    }

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
        if (countRounds <= 13){
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
        else {
            //Spiel beenden
        }
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
    
    public void rollThisDice () {
        //nicht ausgewählte Würfel würfeln
    }

    public void pickDice () {
        //Würfel auswählen
    }

    public void setScoreNull (){
        // alertDialog "Möchtest du den ... streichen?"
    }


    int[] scores = {4,8,6,12,15,12,19,0,25,30,0,50,24};

    public int calculateResult () {
        int sumTotal = 0;

        for (int i : scores) {
            sumTotal += i;
        }

        int sumTop = scores[0]+scores[1]+scores[2]+scores[3]+scores[4]+scores[5];

        if (sumTop>=63){
            sumTotal+=35;
        }
        return sumTotal;
    }

}
