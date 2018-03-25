package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by Su on 25.03.2018.
 */

public class ScoreGame extends Activity implements View.OnClickListener {

    private ImageButton dice1Btn;
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
    private Button endGameBtn;
    private ImageButton finishBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_game);

        dice1Btn = (ImageButton) findViewById(R.id.btnDice1);
        dice1Btn.setOnClickListener(this);

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
        tripletsBtn.setOnClickListener(this);

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
        kniffelBtn.setOnClickListener(this);

        endGameBtn = (Button) findViewById(R.id.btnEndGame);
        endGameBtn.setOnClickListener(this);

        finishBtn = (ImageButton) findViewById(R.id.ibtnFinish);
        finishBtn.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {

        finish();

        int clickedElementEnd = view.getId();

        if (clickedElementEnd == R.id.btnEndGame) {
            Intent intent = new Intent(ScoreGame.this, EndGame.class);
            startActivity(intent);
        }

    }
}
