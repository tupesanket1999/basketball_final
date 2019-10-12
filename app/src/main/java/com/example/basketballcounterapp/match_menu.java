package com.example.basketballcounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class match_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_menu);

        LinearLayout layout = findViewById(R.id.layout_match);

        int number_matches = 5;
        Button btnTag[] = new Button[number_matches];


        for (int i = 0; i < number_matches; i++) {
            //set the properties for button
            btnTag[i] = new Button(this);
            btnTag[i].setText("match number > " + i );
            layout.addView(btnTag[i]);
        }
    }
}
