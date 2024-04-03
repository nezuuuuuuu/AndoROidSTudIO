package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
//    int height;
    Boolean fail=false;
    ArrayList<Animator> objs=new ArrayList<>();
    ArrayList<Button> btns=new ArrayList<>();
    int score=0;
    int[] mediaPlayers=new int[]{
            R.raw.a5,R.raw.b5,R.raw.a5,R.raw.g4,R.raw.g4,R.raw.a5
            ,R.raw.g4,R.raw.gb4,R.raw.gb4,R.raw.a5,R.raw.a5,R.raw.a5
            ,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5
            ,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5,R.raw.a5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        ConstraintLayout cs1=findViewById(R.id.constraintLayout);
        ConstraintLayout cs2=findViewById(R.id.constraintLayout2);
        ConstraintLayout cs3=findViewById(R.id.constraintLayout3);
        ConstraintLayout cs4=findViewById(R.id.constraintLayout4);
        ArrayList<ConstraintLayout> constraintLayouts=new ArrayList<>();
        constraintLayouts.add(cs1);
        constraintLayouts.add(cs2);
        constraintLayouts.add(cs3);
        constraintLayouts.add(cs4);

        Random random=new Random();





            long max=100000;
        int ctr=-1;
        for(int i=0;i<max/500;i++) {
            ctr++;
            if(ctr==12){
                ctr=0;
            }

            int n=random.nextInt(4);
            Button btn = new Button(this);
            btn.setBackgroundColor(Color.BLACK);
            btn.setHeight(500);
            btn.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
            btn.setY(1000-i*520);
            ObjectAnimator animation = ObjectAnimator.ofFloat(btn, "translationY",1500);
            animation.setInterpolator(null);
//            animation.setStartDelay(100);



                animation.setDuration(1000 * i + 520 - i);

//
            objs.add(animation);
            btns.add(btn);


            if(i==0){
                int finalCtr1 = ctr;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,mediaPlayers[finalCtr1]);
                        mediaPlayer.start();
                        AnimatorSet as=new AnimatorSet();
                        as.playTogether(objs);
                        as.start();


                        btn.setBackgroundColor(Color.GRAY);
                        btn.setEnabled(false);

                        score++;
                    }
                });
            }
            else {
                int finalCtr = ctr;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        mediaPlayers.get(ctr).stop();
                        btn.setBackgroundColor(Color.GRAY);
                        btn.setEnabled(false);
                        MediaPlayer mediaPlayer=MediaPlayer.create(MainActivity.this,mediaPlayers[finalCtr]);
                        mediaPlayer.start();

                        score++;
                    }
                });
            }


            constraintLayouts.get(n).addView(btn);

        }











    }

}