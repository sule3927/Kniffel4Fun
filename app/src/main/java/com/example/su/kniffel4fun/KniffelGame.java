package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private ImageButton dice3Btn;
    private ImageButton dice4Btn;
    private ImageButton dice5Btn;
    private ImageButton dice6Btn;
    private Button tripletsBtn;
    private Button allfoursBtn;
    private ImageButton houseBtn;
    private ImageButton smallStreetBtn;
    private ImageButton largeStreetBtn;
    private ImageButton chanceBtn;
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

        dice2Btn = (ImageButton) findViewById(R.id.btnDice2);
        dice2Btn.setOnClickListener(this);

        dice3Btn = (ImageButton) findViewById(R.id.btnDice3);
        dice3Btn.setOnClickListener(this);

        dice4Btn = (ImageButton) findViewById(R.id.btnDice4);
        dice4Btn.setOnClickListener(this);

        dice5Btn = (ImageButton) findViewById(R.id.btnDice5);
        dice5Btn.setOnClickListener(this);

        dice6Btn = (ImageButton) findViewById(R.id.btnDice6);
        dice6Btn.setOnClickListener(this);

        tripletsBtn = (Button) findViewById(R.id.btn3er);
        tripletsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hallo");
            }
        });

        allfoursBtn = (Button) findViewById(R.id.btn4er);
        allfoursBtn.setOnClickListener(this);

        houseBtn = (ImageButton) findViewById(R.id.btnHouse);
        houseBtn.setOnClickListener(this);

        smallStreetBtn = (ImageButton) findViewById(R.id.btnSmallStreet);
        smallStreetBtn.setOnClickListener(this);

        largeStreetBtn = (ImageButton) findViewById(R.id.btnLargeStreet);
        largeStreetBtn.setOnClickListener(this);

        chanceBtn = (ImageButton) findViewById(R.id.btnChance);
        chanceBtn.setOnClickListener(this);

        kniffelBtn = (Button) findViewById(R.id.btnKniffel);
        kniffelBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame.changePlayer();
                txtPlayer.setText(PlayGame.getCurrPlayer().getName());
                //iviewAvatar.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
                txtDice1.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(0)));
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
                Log.d("SENSO", "Würfel sind "+ allDice[0] + " , "+ allDice[1] + " , "+ allDice[2] + " , "+ allDice[3] + " , "+ allDice[4]);
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


    @Override
    public void onClick(View view) {

        finish();

        int clickedElementScore = view.getId();

        if (clickedElementScore == R.id.btnScore) {
            Intent intent = new Intent(KniffelGame.this, ScoreGame.class);
            startActivity(intent);
        }
    }

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

