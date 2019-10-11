package com.example.basketballcounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public static String s1;
    public static  String s2;



    public void setText(View view){

        EditText e1 = findViewById(R.id.editText1);
        EditText e2 = findViewById(R.id.editText2);
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();


        Intent intent = new Intent(this, PlayerName.class);
        startActivity(intent);

    }

}
