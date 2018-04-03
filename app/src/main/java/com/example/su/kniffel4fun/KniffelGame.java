package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Su on 18.03.2018.
 */

public class KniffelGame extends Activity implements View.OnClickListener {

    private TextView txtPlayer;
    private ImageView iviewAvatar;
    private ImageButton dice1Btn;
    private TextView txtDice1;
    private ImageButton dice2Btn;
    private TextView txtDice2;
    private ImageButton dice3Btn;
    private TextView txtDice3;
    private ImageButton dice4Btn;
    private TextView txtDice4;
    private ImageButton dice5Btn;
    private TextView txtDice5;
    private ImageButton dice6Btn;
    private TextView txtDice6;
    private Button tripletsBtn;
    private TextView txt3er;
    private Button allfoursBtn;
    private TextView txt4er;
    private ImageButton houseBtn;
    private TextView txtHouse;
    private ImageButton smallStreetBtn;
    private TextView txtSmallStreet;
    private ImageButton largeStreetBtn;
    private TextView txtLargeStreet;
    private ImageButton chanceBtn;
    private TextView txtChance;
    private Button kniffelBtn;
    private ImageView iviewDice1;
    private ImageView iviewDice2;
    private ImageView iviewDice3;
    private ImageView iviewDice4;
    private ImageView iviewDice5;
    private Button rollDiceBtn;
    private ImageButton backBtn;
    private Button scoreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kniffelgame_view);

        txtPlayer = (TextView) findViewById(R.id.txtPlayer);
        txtPlayer.setText(PlayGame.getCurrPlayer().getName());

        iviewAvatar = (ImageView) findViewById(R.id.iviewAvatar) ;
        iviewAvatar.setImageResource(PlayGame.getCurrPlayer().getAvatarID());

        dice1Btn = (ImageButton) findViewById(R.id.btnDice1);
        dice1Btn.setOnClickListener(this);

        txtDice1 = (TextView) findViewById(R.id.txtDice1);
        txtDice1.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(0)));

        txtDice2 = (TextView) findViewById(R.id.txtDice2);
        txtDice2.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(1)));

        txtDice3 = (TextView) findViewById(R.id.txtDice3);
        txtDice3.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(2)));

        txtDice4 = (TextView) findViewById(R.id.txtDice4);
        txtDice4.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(3)));

        txtDice5 = (TextView) findViewById(R.id.txtDice5);
        txtDice5.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(4)));

        txtDice6 = (TextView) findViewById(R.id.txtDice6);
        txtDice6.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(5)));

        txt3er = (TextView) findViewById(R.id.txt3er);
        txt3er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(6)));

        txt4er = (TextView) findViewById(R.id.txt4er);
        txt4er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(7)));

        txtHouse = (TextView) findViewById(R.id.txtHouse);
        txtHouse.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(8)));

        txtSmallStreet = (TextView) findViewById(R.id.txtSmallStreet);
        txtSmallStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(9)));

        txtLargeStreet = (TextView) findViewById(R.id.txtLargeStreet);
        txtLargeStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(10)));

        txtChance = (TextView) findViewById(R.id.txtChance);
        txtChance.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(11)));

        dice1Btn = (ImageButton) findViewById(R.id.btnDice1);
        dice1Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {1,2,2,3,5};
                checkDice.checkNumber(1,PlayGame.getCurrTurn().getAllDice());
                showScores();

            }
        });

        dice2Btn = (ImageButton) findViewById(R.id.btnDice2);
        dice2Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {1,2,2,3,5};
                checkDice.checkNumber(2,PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        dice3Btn = (ImageButton) findViewById(R.id.btnDice3);
        dice3Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,3,5};
                checkDice.checkNumber(3,PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        dice4Btn = (ImageButton) findViewById(R.id.btnDice4);
        dice4Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               // int [] testDice = {2,2,2,3,4};
                checkDice.checkNumber(4, PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        dice5Btn = (ImageButton) findViewById(R.id.btnDice5);
        dice5Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {4,4,2,3,5};
                checkDice.checkNumber(5,PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        dice6Btn = (ImageButton) findViewById(R.id.btnDice6);
        dice6Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,6,6};
                checkDice.checkNumber(6, PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        tripletsBtn = (Button) findViewById(R.id.btn3er);
        tripletsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,3,5};
                checkDice.check3OfAKind(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        allfoursBtn = (Button) findViewById(R.id.btn4er);
        allfoursBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,2,5};
                checkDice.check4OfAKind(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        houseBtn = (ImageButton) findViewById(R.id.btnHouse);
        houseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,3,3};
                checkDice.checkFullhouse(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        smallStreetBtn = (ImageButton) findViewById(R.id.btnSmallStreet);
        smallStreetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,3,3,4,5};
                checkDice.checkSmallStraight(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        largeStreetBtn = (ImageButton) findViewById(R.id.btnLargeStreet);
        largeStreetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {1,2,3,4,5};
                checkDice.checkLargeStraight(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        chanceBtn = (ImageButton) findViewById(R.id.btnChance);
        chanceBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //int [] testDice = {2,2,2,3,5};
                checkDice.checkChance(PlayGame.getCurrTurn().getAllDice());
                showScores();
            }
        });

        kniffelBtn = (Button) findViewById(R.id.btnKniffel);
        kniffelBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //PlayGame.changePlayer();
                //txtPlayer.setText(PlayGame.getCurrPlayer().getName());
                //iviewAvatar.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
                //showScores();
                nextPlayer();
            }
        });

        iviewDice1 = (ImageView) findViewById(R.id.iviewDice1);
        iviewDice1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice1().isRollable()) {
                    PlayGame.getCurrTurn().getDice1().setRollable(false);
                    iviewDice1.setColorFilter(getResources().getColor(R.color.colorGrey));
                } else {
                    PlayGame.getCurrTurn().getDice1().setRollable(true);
                    iviewDice1.clearColorFilter();
                }
            }
        });

        iviewDice2 = (ImageView) findViewById(R.id.iviewDice2);
        iviewDice2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice2().isRollable()) {
                    PlayGame.getCurrTurn().getDice2().setRollable(false);
                    iviewDice2.setColorFilter(getResources().getColor(R.color.colorGrey));
                } else {
                    PlayGame.getCurrTurn().getDice2().setRollable(true);
                    iviewDice2.clearColorFilter();
                }
            }
        });

        iviewDice3 = (ImageView) findViewById(R.id.iviewDice3);
        iviewDice3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice3().isRollable()) {
                    PlayGame.getCurrTurn().getDice3().setRollable(false);
                    iviewDice3.setColorFilter(getResources().getColor(R.color.colorGrey));
                } else {
                    PlayGame.getCurrTurn().getDice3().setRollable(true);
                    iviewDice3.clearColorFilter();
                }
            }
        });

        iviewDice4 = (ImageView) findViewById(R.id.iviewDice4);
        iviewDice4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice4().isRollable()) {
                    PlayGame.getCurrTurn().getDice4().setRollable(false);
                    iviewDice4.setColorFilter(getResources().getColor(R.color.colorGrey));
                } else {
                    PlayGame.getCurrTurn().getDice4().setRollable(true);
                    iviewDice4.clearColorFilter();
                }
            }
        });

        iviewDice5 = (ImageView) findViewById(R.id.iviewDice5);
        iviewDice5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice5().isRollable()) {
                    PlayGame.getCurrTurn().getDice5().setRollable(false);
                    iviewDice5.setColorFilter(getResources().getColor(R.color.colorGrey));
                } else {
                    PlayGame.getCurrTurn().getDice5().setRollable(true);
                    iviewDice5.clearColorFilter();
                }
            }
        });

        rollDiceBtn = (Button) findViewById(R.id.btnRollDice);
        rollDiceBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame.getCurrTurn().rollAllDice();
                int[] allDice = PlayGame.getCurrTurn().getAllDice();
                //testzwecke
               // Log.d("SENSO", "Würfel sind "+ allDice[0] + " , "+ allDice[1] + " , "+ allDice[2] + " , "+ allDice[3] + " , "+ allDice[4]);
                KniffelGame.showDice(iviewDice1, allDice[0]);
                KniffelGame.showDice(iviewDice2, allDice[1]);
                KniffelGame.showDice(iviewDice3, allDice[2]);
                KniffelGame.showDice(iviewDice4, allDice[3]);
                KniffelGame.showDice(iviewDice5, allDice[4]);

                }
        });

        backBtn = (ImageButton) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(this);

        scoreBtn = (Button) findViewById(R.id.btnScore);
        scoreBtn.setOnClickListener(this);
    }

    public void nextPlayer() {
        PlayGame.changePlayer();
        txtPlayer.setText(PlayGame.getCurrPlayer().getName());
        showScores();
    }

    @Override
    public void onClick(View view) {

        finish();

        int clickedElementScore = view.getId();

        if (clickedElementScore == R.id.btnScore) {
            Intent intent = new Intent(KniffelGame.this, ScoreGame.class);
            startActivity(intent);

        }
    }

    public void showScores()  {
        txtDice1.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(0)));
        txtDice2.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(1)));
        txtDice3.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(2)));
        txtDice4.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(3)));
        txtDice5.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(4)));
        txtDice6.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(5)));
        txt3er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(6)));
        txt4er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(7)));
        txtHouse.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(8)));
        txtSmallStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(9)));
        txtLargeStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(10)));
        txtChance.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(12)));

    }

    //MediaPlayer für den Würfel-Sound
    //final MediaPlayer rollDiceSound;


    public static void showDice(ImageView dice, int pipes) {
        switch (pipes) {
            case 1:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice.setImageResource(R.drawable.dice6);
                break;
        }
    }
}

