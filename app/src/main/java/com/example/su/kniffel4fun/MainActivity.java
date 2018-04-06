package com.example.su.kniffel4fun;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<AvatarItem> mAvatarList;
    private AvatarAdapter mAdapter;

    private Button startBtn;
    private Button btnNewPlayer;
    private EditText editName;
    private Button btnInfo;
    private int selectedID;

    private Animation animationJiggle;
    private Handler handler = new Handler();


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new JiggleButton(),1000*10);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationJiggle = AnimationUtils.loadAnimation(this, R.anim.jigglestartbtn);

        class JiggleButton implements Runnable{

            @Override
            public void run() {
                startBtn.startAnimation(animationJiggle);
            }
        }

        editName = (EditText) findViewById(R.id.editName);

        startBtn = (Button) findViewById(R.id.btnStart);
        startBtn.setOnClickListener(this);

        initList();

        final Spinner spinnerAvatar = findViewById(R.id.spiAvatar);

        mAdapter = new AvatarAdapter(this, mAvatarList);
        spinnerAvatar.setAdapter(mAdapter);

        spinnerAvatar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvatarItem clickedItem = (AvatarItem) parent.getItemAtPosition(position);
                Log.d("SENSO", "Ergebnis ist " + clickedItem.getAvatarImage());
                setSelectedID(clickedItem.getAvatarImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnNewPlayer = (Button) findViewById(R.id.btnNewPlayer);
        btnNewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player(editName.getText().toString(), getSelectedID());
                Toast.makeText(MainActivity.this, editName.getText().toString()+" "+ getString(R.string.strPlayerCreated), Toast.LENGTH_SHORT).show();
            }
        });

        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTxt();
            }
        });

        /*btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTxt();
            }
        });*/

    }

    private void initList() {
        mAvatarList = new ArrayList<>();
        mAvatarList.add(new AvatarItem(R.drawable.astronaut));
        mAvatarList.add(new AvatarItem(R.drawable.thief));
        mAvatarList.add(new AvatarItem(R.drawable.mario));
    }


    @Override
    public void onClick(View view) {
        int clickedElement = view.getId();

        if (clickedElement == R.id.btnStart) {
            if (Player.allPlayers.isEmpty() == true) {
                Toast.makeText(MainActivity.this, getString(R.string.strPlsEnterName), Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                Intent intent = new Intent(MainActivity.this, KniffelGame.class);
                startActivity(intent);
            }
            return;
        }
    }

/*Methode zur Animation des Start-Buttons*/

   private class JiggleButton implements Runnable {
        @Override
        public void run() {
            startBtn.startAnimation(animationJiggle);
        }
    }

    /*test lege zwei Spieler an - dieses geschieht nachher über die Oberfläche*/
//    PlayGame game = new PlayGame();
//    int i = game.testPlayer();

    public int getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public void infoTxt(){
        android.support.v7.app.AlertDialog.Builder alertDialogInfo = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialogInfo.setTitle("Info");
        alertDialogInfo.setMessage("INFORMATION ABOUT USED GRAPHICS\n" +
                "\n" +
                "All used graphic resources in these application are \"Designed by Vecteezy / Freepik\" and are free to use:\n" +
                "\n" +
                "For both personal and commercial projects and to modify it.\n" +
                "In a website or presentation template or application or as part of your design.\n" +
                "The full terms of the license are described in section 7 of the Freepik terms of use, available online in the following link:\n" +
                "\n" +
                "http://www.freepik.com/terms_of_use\n" +
                "\n" +
                "The terms described in the above link have precedence over the terms described in the present document. In case of disagreement, the Freepik Terms of Use will prevail.\n" +
                "\n" +
                "INFORMATION ABOUT USED SOUND\n" +
                "\n" +
                "This application uses these sound from freesound:\n" +
                "\n" +
                "Dice Rolling in Cup.wav by Mick Gibbs ( https://freesound.org/people/Mick%20Gibbs/sounds/202986/ ).");
        alertDialogInfo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //create alert dialog
        alertDialogInfo.create();

        //show alert dialog
        alertDialogInfo.show();
    }

    public void rulesTxt(){
        android.support.v7.app.AlertDialog.Builder alertDialogInfo = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialogInfo.setTitle("Rules");
        alertDialogInfo.setMessage("In Yatzy the objective is to obtain the highest score by throwing 5 dice.\n" +
                "\n" +
                "There are 13 rounds in the game, each round every player rolls all 5 dice and the roll is scored in one of 13 categories. You must score once in each category and each category is scored with different sets of die faces. The game ends when all 13 categories have been scored.\n" +
                "\n" +
                "START\n" +
                "\n" +
                "One player rolls all the dice. After rolling, they can score the current roll or re-roll any or all of the dice. The player may only roll the dice a total of 3 times, after which the player must choose a category to score in. The turn then proceeds to the next player.\n" +
                "\n" +
                "SCORING\n" +
                "\n" +
                "To score combinations of 5 dice select one of the 13 categories and write it on the scorecard. Once a box has been scored, it cannot be scored again.\n" +
                "\n" +
                "Upper Section Scoring: If a player chooses to score in the upper section the score is the total of the specified die faces. Example: You roll three 2s, end your turn and score 6 points in the ‘2’ category. Bonus: If the total of the Upper Scores is 63 or over, add a bonus of 50.\n" +
                "\n" +
                "Lower Section Scoring: Pair: 2 dice with the same faces. The score is the total of these two die faces. Two pairs: One pair, and another pair of dice with different faces from each other. The score is the total of these four die faces. Example: 6+6+5+5=22 3 and 4 of a Kind: For 3 of a kind, 3 die faces must be the same; for 4 of a kind, 4 must be the same. The score is the total of all the 3 or 4 dice. Small and Large Straight: A straight is a sequence of consecutive die faces; a small straight is made up of die faces 1-2-3-4-5 and scores 15 points; a large straight is made up of die faces 2-3-4-5-6 and scores 20 points. Full House: A Full House as in poker is a combination of 3 of a kind and 2 of a kind. The score is the total of the die faces. Example: 6+6+6+5+5=28 Yatzy: Yatzy is 5 of a kind and scores 50 points, but you can choose to score the roll in other categories instead. Example: You roll 6-6-6-6-6. You can choose to score this as a Yatzy (50), 4 of a kind (24) or in the Upper Section ‘6’ (30). Chance: Roll anything and put it into the Chance category, the score is the total of the die faces.\n" +
                "\n" +
                "Zero score: If you cannot score a category after your 3 rolls, choose any category and mark 0 points to it.");
        alertDialogInfo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //create alert dialog
        alertDialogInfo.create();

        //show alert dialog
        alertDialogInfo.show();
    }
}


