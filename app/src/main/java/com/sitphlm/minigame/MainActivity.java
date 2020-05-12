package com.sitphlm.minigame;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Explode explodeIn = new Explode();
        explodeIn.setDuration(1500);
        getWindow().setEnterTransition(explodeIn);
        Explode explodeOut = new Explode();
        explodeOut.setDuration(1500);
        getWindow().setExitTransition(explodeOut);
        getWindow().setReturnTransition(explodeOut);
        getWindow().setReenterTransition(explodeIn);

        Button btn1 = findViewById(R.id.ZhanHuaMing);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZhanHuaMingActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

        Button btn2 = findViewById(R.id.DengMi);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CaiDengMiActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
    }
}
