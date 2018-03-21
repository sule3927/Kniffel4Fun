package com.example.su.kniffel4fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ArrayList<AvatarItem> mAvatarList;
    private AvatarAdapter mAdapter;

    private Button startBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.btnStart);
        startBtn.setOnClickListener(this);

        initList();

        Spinner spinnerAvatar = findViewById(R.id.spiAvatar);

        mAdapter = new AvatarAdapter(this, mAvatarList);
        spinnerAvatar.setAdapter(mAdapter);

        spinnerAvatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvatarItem clickedItem = (AvatarItem) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }
    private void initList(){
        mAvatarList = new ArrayList<>();
        mAvatarList.add(new AvatarItem(R.drawable.astronaut));
        mAvatarList.add(new AvatarItem(R.drawable.thief));
        mAvatarList.add(new AvatarItem(R.drawable.mario));
    }

    @Override
    public void onClick(View view) {
        int clickedElement = view.getId();

        if (clickedElement == R.id.btnStart){
            Intent intent = new Intent(MainActivity.this, KniffelGame.class);
            startActivity(intent);

        }
    }

/*        /*test MF
        checkDice dice = new checkDice();
        int result = dice.checkNumber(2);
        Log.d("SENSO", "Ergebnis ist "+result);
        int fullhouse = dice.checkFullhouse();
        Log.d("SENSO", "Fullhouse ist "+fullhouse);
        int largeStraight = dice.checkLargeStraight();
        Log.d("SENSO", "große Straße bringt "+largeStraight+" Punkte!");
        int smallStraight = dice.checkSmallStraight();
        Log.d("SENSO", "kleine Straße bringt "+smallStraight+" Punkte!");

        /*test JB
        int threeofakind = dice.check3OfAKind();
        Log.d("SENSO", "3 of a kind ist "+threeofakind);

        int fourofakind = dice.check4OfAKind();
        Log.d("SENSO", "4 of a kind ist "+fourofakind);

        int yatzy = dice.checkYatzy();
        Log.d("SENSO", "Yatzy ist "+yatzy);

        int chance = dice.checkChance();
        Log.d("SENSO", "Chance ist "+chance);
    }*/
}


