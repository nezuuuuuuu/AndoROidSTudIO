package com.example.everything;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_button_exercise);
        Button close= (Button) findViewById(R.id.close);
        Button toast= (Button) findViewById(R.id.taost);
        Button changeBackgound= (Button) findViewById(R.id.changebg);
        Button changeButtonBackground= (Button) findViewById(R.id.changebtnbg);
        Button disappear= (Button) findViewById(R.id.disappear);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ButtonExercise.this,Empty.class);
                startActivity(intent);
            }
        });
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Asdadsdsad",Toast.LENGTH_SHORT).show();

            }
        });
        changeBackgound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((View)findViewById(R.id.background)).setBackgroundColor(RED);
            }
        });
        changeButtonBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackground.setBackgroundColor(RED);
            }
        });
        disappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disappear.setVisibility(View.INVISIBLE);
            }
        });

    }

}