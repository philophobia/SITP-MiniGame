package com.sitphlm.minigame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.cooltechworks.views.ScratchTextView;

import java.util.Random;

public class DMDetailsActivity extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm_details);

        Fade fadeIn = new Fade();
        fadeIn.setDuration(1500);
        getWindow().setEnterTransition(fadeIn);
        Fade fadeOut = new Fade();
        fadeOut.setDuration(1500);
        getWindow().setExitTransition(fadeOut);
        getWindow().setReturnTransition(fadeOut);
        getWindow().setReenterTransition(fadeIn);

        ImageButton rebtn = findViewById(R.id.dmReturn);
        rebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DMDetailsActivity.this, CaiDengMiActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(DMDetailsActivity.this).toBundle());
                finish();
            }
        });
        final LinearLayout layout = findViewById(R.id.correctLinear);
        layout.setVisibility(View.GONE);

        //设置灯谜详情，有谜面、回答、谜底、解释四部分
        final String[] riddle = selectRiddle();
        TextView miMian = findViewById(R.id.MiMian);
        assert riddle != null;
        miMian.setText("谜面：\n\n" + riddle[0]);

        final EditText editText = findViewById(R.id.editText);
        final ImageButton okbtn = findViewById(R.id.OKButton);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
                editText.setKeyListener(null);
                editText.setText(str);

                okbtn.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);
                layout.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(DMDetailsActivity.this, R.anim.fade_in)));
            }
        });

        ScratchTextView miDi = findViewById(R.id.concealed);
        miDi.setText(riddle[1]);

        ImageButton btn = findViewById(R.id.explanation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出对话框显示
                AlertDialog.Builder builder = new AlertDialog.Builder(DMDetailsActivity.this, R.style.ExplanationStyle);
                builder.setTitle("解释");
                builder.setMessage(riddle[2]);
                builder.setPositiveButton("我明白了！", null);

                Dialog dialog = builder.create();
                Window window = dialog.getWindow();
                assert window != null;
                window.setGravity(Gravity.CENTER);
                window.setWindowAnimations(R.style.ExplanationAnimation);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        });
    }

    private String[] selectRiddle() {
        Random random = new Random();
        switch (random.nextInt(30)) {
            case 0:
                return getResources().getStringArray(R.array.r0);
            case 1:
                return getResources().getStringArray(R.array.r1);
            case 2:
                return getResources().getStringArray(R.array.r2);
            case 3:
                return getResources().getStringArray(R.array.r3);
            case 4:
                return getResources().getStringArray(R.array.r4);
            case 5:
                return getResources().getStringArray(R.array.r5);
            case 6:
                return getResources().getStringArray(R.array.r6);
            case 7:
                return getResources().getStringArray(R.array.r7);
            case 8:
                return getResources().getStringArray(R.array.r8);
            case 9:
                return getResources().getStringArray(R.array.r9);
            case 10:
                return getResources().getStringArray(R.array.r10);
            case 11:
                return getResources().getStringArray(R.array.r11);
            case 12:
                return getResources().getStringArray(R.array.r12);
            case 13:
                return getResources().getStringArray(R.array.r13);
            case 14:
                return getResources().getStringArray(R.array.r14);
            case 15:
                return getResources().getStringArray(R.array.r15);
            case 16:
                return getResources().getStringArray(R.array.r16);
            case 17:
                return getResources().getStringArray(R.array.r17);
            case 18:
                return getResources().getStringArray(R.array.r18);
            case 19:
                return getResources().getStringArray(R.array.r19);
            case 20:
                return getResources().getStringArray(R.array.r20);
            case 21:
                return getResources().getStringArray(R.array.r21);
            case 22:
                return getResources().getStringArray(R.array.r22);
            case 23:
                return getResources().getStringArray(R.array.r23);
            case 24:
                return getResources().getStringArray(R.array.r24);
            case 25:
                return getResources().getStringArray(R.array.r25);
            case 26:
                return getResources().getStringArray(R.array.r26);
            case 27:
                return getResources().getStringArray(R.array.r27);
            case 28:
                return getResources().getStringArray(R.array.r28);
            case 29:
                return getResources().getStringArray(R.array.r29);
        }
        return null;
    }
}
