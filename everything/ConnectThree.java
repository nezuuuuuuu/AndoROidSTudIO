package com.example.everything;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConnectThree extends AppCompatActivity {
    boolean player=true;
    int[] playerColor = {Color.BLACK, Color.WHITE};
    ArrayList<Button> forall;
    int[][] forChecking={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    ConstraintLayout cs2;
    TextView tv;
    int[] forc1={0,0,0,0,0};
    int[] forc2={0,0,0,0,0};
    int[] forc3={0,0,0,0,0};
    int[] forc4={0,0,0,0,0};
    int[] forc5={0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(),"Jan Edward V. Abadiano", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);



        forall=new ArrayList<>();
        setContentView(R.layout.activity_connect_three);
        tv=findViewById(R.id.textView12);
        tv.setTextSize(25);

        ConstraintLayout cs1=findViewById(R.id.constraintLayout6);
        cs2=findViewById(R.id.constraintLayout8);

        ConstraintLayout cs3=findViewById(R.id.constraintLayout7);

        ConstraintLayout cs4=findViewById(R.id.constraintLayout10);

        ConstraintLayout cs5=findViewById(R.id.constraintLayout9);

        ArrayList<Button> css1=new ArrayList<>();

        css1.add((Button) cs1.getViewById(R.id.constraintLayout));


        css1.add((Button) cs1.getViewById(R.id.constraintLayout2));
        css1.add((Button) cs1.getViewById(R.id.constraintLayout3));
        css1.add((Button) cs1.getViewById(R.id.constraintLayout4));
        css1.add((Button) cs1.getViewById(R.id.constraintLayout5));


        ArrayList<Button> css2=new ArrayList<>();

        css2.add((Button) cs2.getViewById(R.id.constraintLayout));
        css2.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=!player;

                doActivity(css2,forc2,1);
            }
        });
        css2.add((Button) cs2.getViewById(R.id.constraintLayout2));
        css2.add((Button) cs2.getViewById(R.id.constraintLayout3));
        css2.add((Button) cs2.getViewById(R.id.constraintLayout4));
        css2.add((Button) cs2.getViewById(R.id.constraintLayout5));



        ArrayList<Button> css3=new ArrayList<>();

        css3.add((Button) cs3.getViewById(R.id.constraintLayout));
        css3.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player=!player;


                doActivity(css3,forc3,2);

            }
        });
        css3.add((Button) cs3.getViewById(R.id.constraintLayout2));

        css3.add((Button) cs3.getViewById(R.id.constraintLayout3));
        css3.add((Button) cs3.getViewById(R.id.constraintLayout4));

        css3.add((Button) cs3.getViewById(R.id.constraintLayout5));
        cs1.setBackgroundColor(Color.rgb(255, 87, 51));
        cs2.setBackgroundColor(Color.rgb(255, 87, 51));
        cs3.setBackgroundColor(Color.rgb(255, 87, 51));
        cs4.setBackgroundColor(Color.rgb(255, 87, 51));
        cs5.setBackgroundColor(Color.rgb(255, 87, 51));



        ArrayList<Button> css4=new ArrayList<>();

        css4.add((Button) cs4.getViewById(R.id.constraintLayout));

        css4.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=!player;

                doActivity(css4,forc4,3);
            }
        });
        css4.add((Button) cs4.getViewById(R.id.constraintLayout2));
        css4.add((Button) cs4.getViewById(R.id.constraintLayout3));
        css4.add((Button) cs4.getViewById(R.id.constraintLayout4));
        css4.add((Button) cs4.getViewById(R.id.constraintLayout5));



        ArrayList<Button> css5=new ArrayList<>();

        css5.add((Button) cs5.getViewById(R.id.constraintLayout));
        cs5.getViewById(R.id.constraintLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=!player;

                doActivity(css5,forc5,4);
            }
        });
        css5.add((Button) cs5.getViewById(R.id.constraintLayout2));
        css5.add((Button) cs5.getViewById(R.id.constraintLayout3));
        css5.add((Button) cs5.getViewById(R.id.constraintLayout4));
        css5.add((Button) cs5.getViewById(R.id.constraintLayout5));
        forall.addAll(css1);
        forall.addAll(css2);
        forall.addAll(css3);
        forall.addAll(css4);
        forall.addAll(css5);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

     initializeColor();

        css1.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                player=!player;
                if(player){
                    tv.setText("White's turn");
                }
                else{
                    tv.setText("Black's turn");
                }
                doActivity(css1,forc1,0);
            }
        });
    }

    void doActivity(ArrayList<Button> css, int[] forc,int col){
        int color;
        int num;
        if(player){
            color=playerColor[0];
            num=1;
        }else{
            color=playerColor[1];
            num=2;
        }

        for(int i=4;i>=0;i--){
            if(forc[i]==0){
                css.get(i).setBackgroundColor(color);
                forc[i]=1;
                forChecking[i][col]=num;
                checker();
                return;
            }
        }
        return;
    }
    void checker(){
        colChecker();
        rowChecker();
        hlDagonalChecker();
        lhDiagonalChecker();
        if(tv.isEnabled()){
            if(player){
                tv.setText("White's turn");
            }
            else{
                tv.setText("Black's turn");
            }
        }






    }
    void hlDagonalChecker(){

        for (int i = 0; i < forChecking.length - 2; i++) {
            for (int j = 2; j < forChecking[i].length; j++) {
                if (forChecking[i][j]!=0&&forChecking[i][j] == forChecking[i + 1][j - 1] && forChecking[i][j] == forChecking[i + 2][j - 2]) {
                    disableAll(forall);
                    if(forChecking[i][j]==1){
                        tv.setText("BLACK WON!!!");
                        return;
                    }
                    tv.setText("WHITE WON!!!");
                    return;
                }
            }
        }
    }
    void lhDiagonalChecker(){
        for (int i = 0; i < 5 - 2; i++) {
            for (int j = 0; j < 5 - 2; j++) {
                if (forChecking[i][j]!=0&&forChecking[i][j] == forChecking[i + 1][j + 1] && forChecking[i][j] == forChecking[i + 2][j + 2]) {

                    disableAll(forall);
                    if(forChecking[i][j]==1){
                        tv.setText("BLACK WON!!!");
                        return;
                    }
                    tv.setText("WHITE WON!!!");
                    return;
                }
            }
        }


    }
    void colChecker(){
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5- 2; i++) {
                if (forChecking[i][j]!=0&&forChecking[i][j] == forChecking[i + 1][j] && forChecking[i][j] == forChecking[i + 2][j]) {
                    disableAll(forall);
                    if(forChecking[i][j]==1){
                        tv.setText("BLACK WON!!!");
                        return;
                    }
                    tv.setText("WHITE WON!!!");
                    return;
                }
                }
            }
        }


    void rowChecker(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 2; j++) {
                if (forChecking[i][j]!=0&&forChecking[i][j] == forChecking[i][j + 1] && forChecking[i][j] == forChecking[i][j + 2]) {

                        disableAll(forall);
                        if(forChecking[i][j]==1){
                            tv.setText("BLACK WON!!!");
                            return;
                        }
                        tv.setText("WHITE WON!!!");
                        return;
                    }
                }
            }
        }







    void disableAll(ArrayList<Button> forall){
        for(Button c:forall){
            c.setEnabled(false);
        }

        tv.setEnabled(false);

    }
    void initializeColor()
    { tv.setText("White's turn");
        for (Button c:forall
        ) {
            c.setBackgroundColor(Color.rgb(8, 143, 143));



        }

    }
    void reset(){
        for(Button c:forall){
            c.setEnabled(true);
        }
        initializeColor();
        tv.setEnabled(true);
        forChecking = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        player=true;
        forc1= new int[]{0, 0, 0, 0, 0};
        forc2= new int[]{0, 0, 0, 0, 0};
        forc3= new int[]{0, 0, 0, 0, 0};
        forc4= new int[]{0, 0, 0, 0, 0};
        forc5= new int[]{0, 0, 0, 0, 0};


    }



}