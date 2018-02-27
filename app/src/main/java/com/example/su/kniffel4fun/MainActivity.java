package com.example.su.kniffel4fun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*test MF*/
        checkDice dice = new checkDice();
        int result = dice.checkNumber(1);
        Log.d("SENSO", "Ergebnis ist "+result);
        int fullhouse = dice.checkFullhouse();
        Log.d("SENSO", "Fullhouse ist "+fullhouse);

        /*test JB*/
        int threeofakind = dice.check3OfAKind();
        Log.d("SENSO", "3 of a kind ist "+threeofakind);

        int fourofakind = dice.check4OfAKind();
        Log.d("SENSO", "4 of a kind ist "+fourofakind);

        int yatzy = dice.checkYatzy();
        Log.d("SENSO", "Yatzy ist "+yatzy);

        int chance = dice.checkChance();
        Log.d("SENSO", "Chance ist "+chance);
    }

}
