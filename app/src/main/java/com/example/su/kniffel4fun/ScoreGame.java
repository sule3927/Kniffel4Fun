package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author Susann Leonhardt on 25.03.2018.
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
    private ImageButton backBtn;
    private Button quitBtn;
    private TextView txtPlayer1Name;
    private TextView txtPlayer2Name;
    private TextView txtPlayer3Name;
    private ImageView iviewPlayer1;
    private ImageView iviewPlayer2;
    private ImageView iviewPlayer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_game);
        setResults();

        backBtn = (ImageButton) findViewById(R.id.ibtnFinish);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreGame.this, MainActivity.class);
                startActivity(intent);
            }
        });

        quitBtn = (Button) findViewById(R.id.btnEndGame);
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    /**
     * method to show the final scores of all Players to the user
     */
    public void setResults() {
        int thisPlayer = 0;
        while (thisPlayer < Player.allPlayers.size()) {
            Player nextPlayer = Player.allPlayers.get(thisPlayer);
            PlayGame.setCurrPlayer(nextPlayer);
            switch (thisPlayer) {
                case 0:
                    iviewPlayer1 = (ImageView) findViewById(R.id.iviewPlayer1);
                    iviewPlayer1.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
                    txtPlayer1Name = (TextView) findViewById(R.id.txtPlayer1Name);
                    txtPlayer1Name.setText(PlayGame.getCurrPlayer().getName());
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
                    iviewPlayer2 = (ImageView) findViewById(R.id.iviewPlayer2);
                    iviewPlayer2.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
                    txtPlayer2Name = (TextView) findViewById(R.id.txtPlayer2Name);
                    txtPlayer2Name.setText(PlayGame.getCurrPlayer().getName());
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
                    iviewPlayer3 = (ImageView) findViewById(R.id.iviewPlayer3);
                    iviewPlayer3.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
                    txtPlayer3Name = (TextView) findViewById(R.id.txtPlayer3Name);
                    txtPlayer3Name.setText(PlayGame.getCurrPlayer().getName());
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
    public void onClick(View view) {
        int clickedElementQuit = view.getId();

        if (clickedElementQuit == R.id.btnEndGame) {
            finish();
            System.exit(0);

        }
    }
}
