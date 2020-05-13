package com.sitphlm.minigame;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.Random;

public class CaiDengMiActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caidengmi);

        Slide slideIn = new Slide();
        slideIn.setDuration(1500);
        slideIn.setSlideEdge(Gravity.BOTTOM);
        getWindow().setEnterTransition(slideIn);
        Slide slideOut = new Slide();
        slideOut.setDuration(1500);
        slideOut.setSlideEdge(Gravity.TOP);
        getWindow().setExitTransition(slideOut);
        getWindow().setReturnTransition(slideOut);
        getWindow().setReenterTransition(slideIn);

        ImageButton rebtn = findViewById(R.id.cdmReturn);
        rebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaiDengMiActivity.this, MainActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(CaiDengMiActivity.this).toBundle());
            }
        });

        //随机放置灯笼
        ImageButton btn1 = findViewById(R.id.lButton1);
        ImageButton btn2 = findViewById(R.id.lButton2);
        ImageButton btn3 = findViewById(R.id.lButton3);
        ImageButton btn4 = findViewById(R.id.lButton4);
        ImageButton btn5 = findViewById(R.id.lButton5);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float dpi = dm.density;
        RelativeLayout.LayoutParams lp1 = (RelativeLayout.LayoutParams) btn1.getLayoutParams();
        lp1.setMargins((int) (generateRandomX() * dpi), (int) (generateRandomY() * dpi), 0, 0);
        RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) btn2.getLayoutParams();
        lp2.setMargins((int) (generateRandomX() * dpi), (int) (generateRandomY() * dpi), 0, 0);
        RelativeLayout.LayoutParams lp3 = (RelativeLayout.LayoutParams) btn3.getLayoutParams();
        lp3.setMargins((int) (generateRandomX() * dpi), (int) (generateRandomY() * dpi), 0, 0);
        RelativeLayout.LayoutParams lp4 = (RelativeLayout.LayoutParams) btn4.getLayoutParams();
        lp4.setMargins((int) (generateRandomX() * dpi), (int) (generateRandomY() * dpi), 0, 0);
        RelativeLayout.LayoutParams lp5 = (RelativeLayout.LayoutParams) btn5.getLayoutParams();
        lp5.setMargins((int) (generateRandomX() * dpi), (int) (generateRandomY() * dpi), 0, 0);
    }

    private int generateRandomX(){
        Random random = new Random(System.currentTimeMillis() + (long) (Math.random() * 100000));
        return random.nextInt(239);
    }

    private int generateRandomY() {
        Random random = new Random(System.currentTimeMillis() + (long) (Math.random() * 100000));
        return random.nextInt(437);
    }

    //进入详细的灯谜页面
    public void toDetail(View view) {
        startActivity(new Intent(CaiDengMiActivity.this, DMDetailsActivity.class),
                ActivityOptions.makeSceneTransitionAnimation(CaiDengMiActivity.this).toBundle());
    }
}
