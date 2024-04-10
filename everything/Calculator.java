package com.example.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.everything.R;

import java.util.ArrayList;
import java.util.Stack;


public class Calculator extends AppCompatActivity {

    ArrayList<Button> btns;
    EditText input;
    TextView display;
    boolean dotctr;
    boolean opctr;
    boolean numctr;
    Double answer2= Double.valueOf(0);
    Double answer3= Double.valueOf(0);
    String temp="";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        MyCalcuClass mcc=new MyCalcuClass(this);
        btns=new ArrayList<>();
        dotctr=false;
        opctr=true;
        numctr=false;



        input= (EditText) findViewById(R.id.input);
        Button answer= (Button) findViewById(R.id.answer);
        display=findViewById(R.id.display);
        Button clear= (Button) findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                display.setText("");
            }
        });
        ((Button) findViewById(R.id.delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(input.getText()).isEmpty()) {
                    return;
                }
                if (input.length() > 0) {
                    if (String.valueOf(input.getText().charAt((input.getText().length() - 1))).equals(".")) {

                        dotctr = true;


                        opctr = false;
                        display.setText("");
                    }
                    input.setText(String.valueOf(input.getText()).substring(0, input.getText().length() - 1));


                }

            }
        });


        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opctr==true){
                    Toast.makeText(getApplicationContext(),"Unable operation at index n-1",Toast.LENGTH_SHORT).show();
                }
                else {
                    mcc.solve();
                }
            }
        });

        for (View b:findViewById(R.id.buttons).getTouchables()
        ) {
            if(b.equals(findViewById(R.id.clear))||b.equals(findViewById(R.id.delete))){
                continue;
            }


            if(b instanceof Button && b!=findViewById(R.id.answer)) {


                btns.add((Button) b);

                if (String.valueOf(((Button) b).getText()).equals("-") || String.valueOf(((Button) b).getText()).equals("+") || String.valueOf(((Button) b).getText()).equals("\\") || String.valueOf(((Button) b).getText()).equals("*")) {

                    if(String.valueOf(((Button) b).getText()).equals("-") ){

                        dotctr=false;
                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                if(Character.isDigit(String.valueOf(input.getText()).charAt(input.getText().length()-1))){
                                    mcc.seq();
                                }

                                if(opctr==false||String.valueOf(input.getText()).isEmpty()) {
                                    input.append(((Button) b).getText());
                                    temp+=String.valueOf(((Button) b).getText());
                                    opctr=true;

                                }
                                else if(!String.valueOf(input.getText()).isEmpty()) {
                                    input.setText(input.getText().subSequence(0,input.getText().length()-1));
                                    temp.substring(0,temp.length()-1);
                                    temp+=String.valueOf(((Button) b).getText());
                                    input.append(((Button) b).getText());

                                }
                            }
                        });
                        continue;
                    }
                    b.setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {
                            if(Character.isDigit(String.valueOf(input.getText()).charAt(input.getText().length()-1))){
                                mcc.seq();
                            }
                            mcc.seq();

                            dotctr=false;
                            if(opctr==false) {

                                input.append(((Button) b).getText());
                                opctr=true;
                            }
                            else if(!String.valueOf(input.getText()).isEmpty()) {

                                input.setText(input.getText().subSequence(0,input.getText().length()-1));
                                input.append(((Button) b).getText());

                            }
                        }
                    });

                } else if (String.valueOf(((Button) b).getText()).equals(".")) {
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!dotctr){
                                input.append(((Button) b).getText());

                                dotctr=true;

                            }
                            else if(String.valueOf(String.valueOf(((Button) b).getText()).charAt(( (Button) b).getText().length()-1)).equals(".")&&numctr==false){
                                input.setText(input.getText().subSequence(0,input.getText().length()-1) );

                                dotctr=false;
                            }
                        }
                    });

                } else {

                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            opctr=false;
                            numctr=true;
                            temp+=String.valueOf(((Button) b).getText());

                            input.append(((Button) b).getText());





                        }
                    });
                }
            }

        }

    }

}