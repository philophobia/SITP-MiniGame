package com.sitphlm.minigame;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import androidx.annotation.RequiresApi;

import java.util.Random;

public class ZhanHuaMingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhanhuaming);

        ImageButton btn = findViewById(R.id.zhmReturn);
        btn.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ZhanHuaMingActivity.this, MainActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(ZhanHuaMingActivity.this).toBundle());
                finish();
            }
        });

        Slide slideIn = new Slide();
        slideIn.setDuration(1500);
        slideIn.setSlideEdge(Gravity.TOP);
        getWindow().setEnterTransition(slideIn);
        Slide slideOut = new Slide();
        slideOut.setDuration(1500);
        slideOut.setSlideEdge(Gravity.BOTTOM);
        getWindow().setExitTransition(slideOut);
        getWindow().setReturnTransition(slideOut);
        getWindow().setReenterTransition(slideIn);
        //当页面动画完成后开始文字动画
        textAnimation();
    }

    private String[] selectFlower() {
        Random random = new Random();
        switch (random.nextInt(40)){
            case 0:
                return getResources().getStringArray(R.array.f0);
            case 1:
                return getResources().getStringArray(R.array.f1);
            case 2:
                return getResources().getStringArray(R.array.f2);
            case 3:
                return getResources().getStringArray(R.array.f3);
            case 4:
                return getResources().getStringArray(R.array.f4);
            case 5:
                return getResources().getStringArray(R.array.f5);
            case 6:
                return getResources().getStringArray(R.array.f6);
            case 7:
                return getResources().getStringArray(R.array.f7);
            case 8:
                return getResources().getStringArray(R.array.f8);
            case 9:
                return getResources().getStringArray(R.array.f9);
            case 10:
                return getResources().getStringArray(R.array.f10);
            case 11:
                return getResources().getStringArray(R.array.f11);
            case 12:
                return getResources().getStringArray(R.array.f12);
            case 13:
                return getResources().getStringArray(R.array.f13);
            case 14:
                return getResources().getStringArray(R.array.f14);
            case 15:
                return getResources().getStringArray(R.array.f15);
            case 16:
                return getResources().getStringArray(R.array.f16);
            case 17:
                return getResources().getStringArray(R.array.f17);
            case 18:
                return getResources().getStringArray(R.array.f18);
            case 19:
                return getResources().getStringArray(R.array.f19);
            case 20:
                return getResources().getStringArray(R.array.f20);
            case 21:
                return getResources().getStringArray(R.array.f21);
            case 22:
                return getResources().getStringArray(R.array.f22);
            case 23:
                return getResources().getStringArray(R.array.f23);
            case 24:
                return getResources().getStringArray(R.array.f24);
            case 25:
                return getResources().getStringArray(R.array.f25);
            case 26:
                return getResources().getStringArray(R.array.f26);
            case 27:
                return getResources().getStringArray(R.array.f27);
            case 28:
                return getResources().getStringArray(R.array.f28);
            case 29:
                return getResources().getStringArray(R.array.f29);
            case 30:
                return getResources().getStringArray(R.array.f30);
            case 31:
                return getResources().getStringArray(R.array.f31);
            case 32:
                return getResources().getStringArray(R.array.f32);
            case 33:
                return getResources().getStringArray(R.array.f33);
            case 34:
                return getResources().getStringArray(R.array.f34);
            case 35:
                return getResources().getStringArray(R.array.f35);
            case 36:
                return getResources().getStringArray(R.array.f36);
            case 37:
                return getResources().getStringArray(R.array.f37);
            case 38:
                return getResources().getStringArray(R.array.f38);
            case 39:
                return getResources().getStringArray(R.array.f39);
        }
        return null;
    }

    private void textAnimation() {
        final String[] flower = selectFlower();
        final AnimatedTextView nameView = findViewById(R.id.name);
        final AnimatedTextView poemView = findViewById(R.id.poem);
        assert flower != null;

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                nameView.setText(flower[0], AnimationUtils.loadAnimation(ZhanHuaMingActivity.this, R.anim.zhm_text), 400);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void run() {
                poemView.setText(flower[1], AnimationUtils.loadAnimation(ZhanHuaMingActivity.this, R.anim.zhm_text), 300);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageButton btn = findViewById(R.id.zhmReturn);
                btn.setVisibility(View.VISIBLE);
            }
        }, 5700);
    }
}
