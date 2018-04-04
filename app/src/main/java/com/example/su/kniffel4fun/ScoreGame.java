package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Su on 25.03.2018.
 */

public class ScoreGame extends Activity implements View.OnClickListener {

    private TextView txtPlayer1UpperSection;
    private TextView txtPlayer1LowerSection;
    private TextView txtPlayer1Yatzy;
    private TextView txtPlayer1Bonus;
    private TextView txtPlayer1ScoreAll;
    private TextView txtPlayer2UpperSection;
    private TextView txtPlayer2LowerSection;
    private TextView txtPlayer2Yatzy;
    private TextView txtPlayer2Bonus;
    private TextView txtPlayer2ScoreAll;
    private TextView txtPlayer3UpperSection;
    private TextView txtPlayer3LowerSection;
    private TextView txtPlayer3Yatzy;
    private TextView txtPlayer3Bonus;
    private TextView txtPlayer3ScoreAll;

    public void setResults(){
        int thisPlayer = 0;
        while ( thisPlayer <Player.allPlayers.size()) {
            Player nextPlayer = Player.allPlayers.get(thisPlayer);
            PlayGame.setCurrPlayer(nextPlayer);
            switch (thisPlayer){
                case 0:
                    txtPlayer1UpperSection = (TextView) findViewById(R.id.txtPlayer1UpperSection);
                    txtPlayer1UpperSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(0)));
                    txtPlayer1LowerSection = (TextView) findViewById(R.id.txtPlayer1LowerSection);
                    txtPlayer1LowerSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(2)));
                    txtPlayer1Yatzy = (TextView) findViewById(R.id.txtPlayer1Yatzy);
                    txtPlayer1Yatzy.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(3)));
                    txtPlayer1Bonus = (TextView) findViewById(R.id.txtPlayer1Bonus);
                    txtPlayer1Bonus.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(1)));
                    txtPlayer1ScoreAll = (TextView) findViewById(R.id.txtPlayer1ScoreAll);
                    txtPlayer1ScoreAll.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(4)));
                    break;
                case 1:
                    txtPlayer2UpperSection = (TextView) findViewById(R.id.txtPlayer2UpperSection);
                    txtPlayer2UpperSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(0)));
                    txtPlayer2LowerSection = (TextView) findViewById(R.id.txtPlayer2LowerSection);
                    txtPlayer2LowerSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(2)));
                    txtPlayer2Yatzy = (TextView) findViewById(R.id.txtPlayer2Yatzy);
                    txtPlayer2Yatzy.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(3)));
                    txtPlayer2Bonus = (TextView) findViewById(R.id.txtPlayer2Bonus);
                    txtPlayer2Bonus.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(1)));
                    txtPlayer2ScoreAll = (TextView) findViewById(R.id.txtPlayer2ScoreAll);
                    txtPlayer2ScoreAll.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(4)));
                    break;
                case 2:
                    txtPlayer3UpperSection = (TextView) findViewById(R.id.txtPlayer3UpperSection);
                    txtPlayer3UpperSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(0)));
                    txtPlayer3LowerSection = (TextView) findViewById(R.id.txtPlayer3LowerSection);
                    txtPlayer3LowerSection.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(2)));
                    txtPlayer3Yatzy = (TextView) findViewById(R.id.txtPlayer3Yatzy);
                    txtPlayer3Yatzy.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(3)));
                    txtPlayer3Bonus = (TextView) findViewById(R.id.txtPlayer3Bonus);
                    txtPlayer3Bonus.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(1)));
                    txtPlayer3ScoreAll = (TextView) findViewById(R.id.txtPlayer3ScoreAll);
                    txtPlayer3ScoreAll.setText(Integer.toString(PlayGame.getCurrPlayer().getFinalScore(4)));
                    break;
            }
            thisPlayer++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_game);
        setResults();
    }

    @Override
    public void onClick(View view) {

        finish();
        }


    public void OnButtonClick(View view) {

        System.exit(0);

    }}
