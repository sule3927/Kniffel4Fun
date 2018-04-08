package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.DialogInterface;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Su on 18.03.2018.
 */

public class KniffelGame extends Activity implements View.OnClickListener {

    int numberTurns = 0;
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
    private TextView txtCountDiceRoll;

    int rollingDice;
    SoundPool player;
    public List<TextView> textViews;
    public List<View> imageViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kniffelgame_view);

        player = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        rollingDice = player.load(this, R.raw.dice_roll, 1);

        PlayGame game = new PlayGame();

        txtPlayer = (TextView) findViewById(R.id.txtPlayer);
        txtPlayer.setText(PlayGame.getCurrPlayer().getName());

        iviewAvatar = (ImageView) findViewById(R.id.iviewAvatar);
        iviewAvatar.setImageResource(PlayGame.getCurrPlayer().getAvatarID());

        dice1Btn = (ImageButton) findViewById(R.id.btnDice1);
        dice1Btn.setOnClickListener(this);

        txtCountDiceRoll = (TextView) findViewById(R.id.txtCountDiceRoll);

        txtDice1 = (TextView) findViewById(R.id.txtDice1);
        //txtDice1.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(0)));

        txtDice2 = (TextView) findViewById(R.id.txtDice2);
        //txtDice2.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(1)));

        txtDice3 = (TextView) findViewById(R.id.txtDice3);
        //txtDice3.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(2)));

        txtDice4 = (TextView) findViewById(R.id.txtDice4);
        //txtDice4.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(3)));

        txtDice5 = (TextView) findViewById(R.id.txtDice5);
        //txtDice5.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(4)));

        txtDice6 = (TextView) findViewById(R.id.txtDice6);
        //txtDice6.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(5)));

        txt3er = (TextView) findViewById(R.id.txt3er);
        //txt3er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(6)));

        txt4er = (TextView) findViewById(R.id.txt4er);
        //txt4er.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(7)));

        txtHouse = (TextView) findViewById(R.id.txtHouse);
        //txtHouse.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(8)));

        txtSmallStreet = (TextView) findViewById(R.id.txtSmallStreet);
        //txtSmallStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(9)));

        txtLargeStreet = (TextView) findViewById(R.id.txtLargeStreet);
        //txtLargeStreet.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(10)));

        txtChance = (TextView) findViewById(R.id.txtChance);
        //txtChance.setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(11)));

        dice1Btn = (ImageButton) findViewById(R.id.btnDice1);
        dice1Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(0) == false) {
                    if (checkDice.checkNumber(1, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(1, PlayGame.getCurrTurn().getAllDice()), 0);
                        showScores();
                        //dice1Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(1);
                        //if (PlayGame.getCurrTurn().isScored() == true){
                        //return;
                        //}
                        //return;
                    }
                    //return;
                }

            }
        });

        dice2Btn = (ImageButton) findViewById(R.id.btnDice2);
        dice2Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(1) == false) {
                    if (checkDice.checkNumber(2, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(2, PlayGame.getCurrTurn().getAllDice()), 1);
                        showScores();
                        //dice2Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(2);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        dice3Btn = (ImageButton) findViewById(R.id.btnDice3);
        dice3Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(2) == false) {
                    if (checkDice.checkNumber(3, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(3, PlayGame.getCurrTurn().getAllDice()), 2);
                        showScores();
                        //dice3Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(3);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        dice4Btn = (ImageButton) findViewById(R.id.btnDice4);
        dice4Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(3) == false) {
                    if (checkDice.checkNumber(4, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(4, PlayGame.getCurrTurn().getAllDice()), 3);
                        showScores();
                        //dice4Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(4);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        dice5Btn = (ImageButton) findViewById(R.id.btnDice5);
        dice5Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(4) == false) {
                    if (checkDice.checkNumber(5, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(5, PlayGame.getCurrTurn().getAllDice()), 4);
                        showScores();
                        //dice5Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(5);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        dice6Btn = (ImageButton) findViewById(R.id.btnDice6);
        dice6Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(5) == false) {
                    if (checkDice.checkNumber(6, PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.checkNumber(6, PlayGame.getCurrTurn().getAllDice()), 5);
                        showScores();
                        //dice6Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(6);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        tripletsBtn = (Button) findViewById(R.id.btn3er);
        tripletsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(6) == false) {
                    if (checkDice.check3OfAKind(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.check3OfAKind(PlayGame.getCurrTurn().getAllDice()), 6);
                        showScores();
                        //tripletsBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(7);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        allfoursBtn = (Button) findViewById(R.id.btn4er);
        allfoursBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(7) == false) {
                    if (checkDice.check4OfAKind(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(checkDice.check4OfAKind(PlayGame.getCurrTurn().getAllDice()), 7);
                        showScores();
                        //allfoursBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(8);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        houseBtn = (ImageButton) findViewById(R.id.btnHouse);
        houseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(8) == false) {
                    if (checkDice.checkFullhouse(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(25, 8);
                        showScores();
                        //houseBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(9);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        smallStreetBtn = (ImageButton) findViewById(R.id.btnSmallStreet);
        smallStreetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(9) == false) {
                    if (checkDice.checkSmallStraight(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(30, 9);
                        showScores();
                        //smallStreetBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(10);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        largeStreetBtn = (ImageButton) findViewById(R.id.btnLargeStreet);
        largeStreetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(10) == false) {
                    if (checkDice.checkLargeStraight(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(40, 10);
                        showScores();
                        //largeStreetBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(11);
                        showScores();
                        //if (PlayGame.getCurrTurn().isScored() == true){
                        //    return;
                        //}
                        //else{
                        //    return;
                        //}
                    }
                    //return;
                }
            }
        });

        chanceBtn = (ImageButton) findViewById(R.id.btnChance);
        chanceBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(11) == false) {
                    PlayGame.getCurrPlayer().setPoints(checkDice.checkChance(PlayGame.getCurrTurn().getAllDice()), 11);
                    showScores();
                    //chanceBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                    PlayGame.getCurrTurn().setScored(true);
                }

            }
        });

        kniffelBtn = (Button) findViewById(R.id.btnKniffel);
        kniffelBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().isScored() == false && PlayGame.getCurrPlayer().isScoresSet(12) == false) {
                    if (checkDice.checkYatzy(PlayGame.getCurrTurn().getAllDice()) > 0) {
                        PlayGame.getCurrPlayer().setPoints(50, 12);
                        showScores();
                        //kniffelBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                    } else {
                        setScoreNull(12);
                        if (PlayGame.getCurrTurn().isScored() == true) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        });

        textViews = new ArrayList<TextView>();
        textViews.add(txtDice1);
        textViews.add(txtDice2);
        textViews.add(txtDice3);
        textViews.add(txtDice4);
        textViews.add(txtDice5);
        textViews.add(txtDice6);
        textViews.add(txt3er);
        textViews.add(txt4er);
        textViews.add(txtHouse);
        textViews.add(txtSmallStreet);
        textViews.add(txtLargeStreet);
        textViews.add(txtChance);

        imageViews = new ArrayList<View>();
        imageViews.add(dice1Btn);
        imageViews.add(dice2Btn);
        imageViews.add(dice3Btn);
        imageViews.add(dice4Btn);
        imageViews.add(dice5Btn);
        imageViews.add(dice6Btn);
        imageViews.add(tripletsBtn);
        imageViews.add(allfoursBtn);
        imageViews.add(houseBtn);
        imageViews.add(smallStreetBtn);
        imageViews.add(largeStreetBtn);
        imageViews.add(chanceBtn);
        imageViews.add(kniffelBtn);


        showScores();


        iviewDice1 = (ImageView) findViewById(R.id.iviewDice1);
        iviewDice1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PlayGame.getCurrTurn().getDice1().isRollable() && PlayGame.getCurrTurn().getDice1().getPipes() > 0) {
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
                if (PlayGame.getCurrTurn().getDice2().isRollable() && PlayGame.getCurrTurn().getDice2().getPipes() > 0) {
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
                if (PlayGame.getCurrTurn().getDice3().isRollable() && PlayGame.getCurrTurn().getDice3().getPipes() > 0) {
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
                if (PlayGame.getCurrTurn().getDice4().isRollable() && PlayGame.getCurrTurn().getDice4().getPipes() > 0) {
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
                if (PlayGame.getCurrTurn().getDice5().isRollable() && PlayGame.getCurrTurn().getDice5().getPipes() > 0) {
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
                if (PlayGame.getCurrTurn().getCountRolls() <= 2 && PlayGame.getCurrTurn().isScored() == false) {
                    player.play(rollingDice, 1, 1, 1, 0, 1);
                    PlayGame.getCurrTurn().rollAllDice();
                    showAllDices();
                    txtCountDiceRoll.setText(Integer.toString(PlayGame.getCurrTurn().getCountRolls()));
                    return;
                } else {
                    Toast.makeText(KniffelGame.this, getString(R.string.strPlsSelectScore), Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        backBtn = (ImageButton) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(this);

        scoreBtn = (Button) findViewById(R.id.btnScore);
        scoreBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getText(R.string.strBtnScore) == scoreBtn.getText()) {
                    PlayGame.nextResult();
                    Intent intent = new Intent(KniffelGame.this, ScoreGame.class);
                    startActivity(intent);
                    return;
                }
                if (PlayGame.getCountRounds() < 12 && PlayGame.getCurrTurn().isScored()) {
                    nextPlayer();
                } else {
                    if (PlayGame.getCountRounds() == 12) {
                        scoreBtn.setText(getResources().getText(R.string.strBtnScore));
                        nextPlayer();
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {

        finish();

        int clickedElementScore = view.getId();

        if (clickedElementScore == R.id.btnBack) {
            Intent intent = new Intent(KniffelGame.this, MainActivity.class);
            startActivity(intent);

        }
    }

    public void nextPlayer() {
        PlayGame.changePlayer();
        txtPlayer.setText(PlayGame.getCurrPlayer().getName());
        iviewAvatar.setImageResource(PlayGame.getCurrPlayer().getAvatarID());
        txtCountDiceRoll.setText(Integer.toString(0));
        showScores();
        showAllDices();
    }


    public void showScores() {
        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setText(Integer.toString(PlayGame.getCurrPlayer().getPoints(i)));
        }

        for (int i = 0; i < imageViews.size(); i++) {
            if (PlayGame.getCurrPlayer().isScoresSet(i)) {
                imageViews.get(i).setBackgroundColor(getResources().getColor(R.color.colorGrey));
            } else {
                imageViews.get(i).setBackgroundColor(0);
            }
        }
    }


    public static void showDice(ImageView dice, int pipes) {
        switch (pipes) {
            case 0:
                dice.setImageResource(R.drawable.question);
                dice.clearColorFilter();
                break;
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

    public void showAllDices() {
        int[] allDice = PlayGame.getCurrTurn().getAllDice();
        //testzwecke
        Log.d("SENSO", "Würfel sind " + allDice[0] + " , " + allDice[1] + " , " + allDice[2] + " , " + allDice[3] + " , " + allDice[4]);
        KniffelGame.showDice(iviewDice1, allDice[0]);
        KniffelGame.showDice(iviewDice2, allDice[1]);
        KniffelGame.showDice(iviewDice3, allDice[2]);
        KniffelGame.showDice(iviewDice4, allDice[3]);
        KniffelGame.showDice(iviewDice5, allDice[4]);
    }


    public int setScoreNull(final int choice) {
        int returnValue;
        int value;

        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialog.setMessage(getString(R.string.strDialogTitle));
        //Positive Button
        alertDialog.setPositiveButton(getString(R.string.strDialogReturn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                return;
            }
        });

        //Negative Button
        alertDialog.setNegativeButton(getString(R.string.strDialogOK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (choice) {
                    case 1:
                        PlayGame.getCurrPlayer().setPoints(0, 0);
                        //dice1Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 2:
                        PlayGame.getCurrPlayer().setPoints(0, 1);
                        //dice2Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 3:
                        PlayGame.getCurrPlayer().setPoints(0, 2);
                        //dice3Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 4:
                        PlayGame.getCurrPlayer().setPoints(0, 3);
                        //dice4Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 5:
                        PlayGame.getCurrPlayer().setPoints(0, 4);
                        //dice5Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 6:
                        PlayGame.getCurrPlayer().setPoints(0, 5);
                        //dice6Btn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 7:
                        PlayGame.getCurrPlayer().setPoints(0, 6);
                        //tripletsBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 8:
                        PlayGame.getCurrPlayer().setPoints(0, 7);
                        //allfoursBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 9:
                        PlayGame.getCurrPlayer().setPoints(0, 8);
                        //houseBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 10:
                        PlayGame.getCurrPlayer().setPoints(0, 9);
                        //smallStreetBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 11:
                        PlayGame.getCurrPlayer().setPoints(0, 10);
                        //largeStreetBtn.setColorFilter(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;
                    case 12:
                        PlayGame.getCurrPlayer().setPoints(0, 12);
                        //kniffelBtn.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                        PlayGame.getCurrTurn().setScored(true);
                        showScores();
                        break;

                }
            }
        });

        //create alert dialog
        alertDialog.create();

        //show alert dialog
        alertDialog.show();
        return 0;
    }

}