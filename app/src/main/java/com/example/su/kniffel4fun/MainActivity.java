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
        int result = dice.checkNumber(2);
        Log.d("SENSO", "Ergebnis ist "+result);
        int fullhouse = dice.checkFullhouse();
        Log.d("SENSO", "Fullhouse ist "+fullhouse);
        int largeStraight = dice.checkLargeStraight();
        Log.d("SENSO", "große Straße bringt "+largeStraight+" Punkte!");
        int smallStraight = dice.checkSmallStraight();
        Log.d("SENSO", "kleine Straße bringt "+smallStraight+" Punkte!");
    }

}
