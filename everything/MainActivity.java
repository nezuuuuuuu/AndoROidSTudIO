package com.example.everything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.everything.ButtonExercise;
import com.example.everything.Calculator;
import com.example.everything.ConnectThree;
import com.example.everything.LayoutExercise;
import com.example.everything.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> buttons=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons.add(((Button)findViewById(R.id.page2Btn)));
        buttons.add(((Button)findViewById(R.id.Button_Exercise)));
        buttons.add(((Button)findViewById(R.id.calculator)));
//        buttons.add(((Button)findViewById(R.id.page5Btn)));
        buttons.add(((Button)findViewById(R.id.connectact)));
        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(intent);

            }
        });
        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ButtonExercise.class);
                startActivity(intent);
            }
        });
        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
        buttons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ConnectThree.class);
                startActivity(intent);
            }
        });











    }


}
