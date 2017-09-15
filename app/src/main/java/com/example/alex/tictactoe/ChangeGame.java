package com.example.alex.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by alex on 15.09.17.
 */

public class ChangeGame extends Activity implements View.OnClickListener{
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.change_game);
        findViewById(R.id.bt_change_X).setOnClickListener(this);
        findViewById(R.id.bt_change_O).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(ChangeGame.this, GameActivity.class);
        switch (view.getId()){
            case R.id.bt_change_O:
                intent.putExtra("strokeNumber", 1);
                startActivity(intent);
                break;
            case R.id.bt_change_X:
                intent.putExtra("strokeNumber", 2);
                startActivity(intent);
                break;
        }
    }
}
