package com.example.su.kniffel4fun;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Su on 25.03.2018.
 */

public class EndGame extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

    }

    @Override
    public void onClick(View view) {

        finish();
    }
}
