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
            Intent intent = new Intent(MainActivity.this, KniffelGame.class);
            startActivity(intent);

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
}


