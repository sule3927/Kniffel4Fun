package com.example.su.kniffel4fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ArrayList<AvatarItem> mAvatarList;
    private AvatarAdapter mAdapter;

    private Button startBtn;
    private Button btnNewPlayer;
    private EditText editName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);

        startBtn = (Button) findViewById(R.id.btnStart);
        startBtn.setOnClickListener(this);

        initList();

        Spinner spinnerAvatar = findViewById(R.id.spiAvatar);
        final int selectedID = spinnerAvatar.getSelectedItemPosition();

        mAdapter = new AvatarAdapter(this, mAvatarList);
        spinnerAvatar.setAdapter(mAdapter);

        spinnerAvatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvatarItem clickedItem = (AvatarItem) parent.getItemAtPosition(position);
                Log.d("SENSO", "Ergebnis ist "+clickedItem.getAvatarImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        btnNewPlayer = (Button) findViewById(R.id.btnNewPlayer);
        btnNewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player(editName.getText().toString());
                //player.setAvatarID(selectedID);
                PlayGame.setCurrPlayer(Player.allPlayers.get(0));

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

       /*test lege zwei Spieler an - dieses geschieht nachher über die Oberfläche*/
        PlayGame game = new PlayGame();
        int i = game.testPlayer();

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


