package com.example.su.kniffel4fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Su on 25.03.2018.
 */

public class ScoreGame extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_game);

    }

    @Override
    public void onClick(View view) {

        finish();

    }
}
