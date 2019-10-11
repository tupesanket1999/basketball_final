package com.example.basketballcounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);


    }

    public static String t1 [] = new String [12];
    public static String t2 [] = new String [12];



    public void setter(){

        for(int i =0; i < 12 ; i++) {
            Player_info.player_info[i].name = t1[i];
        }
    }
    public void setter1(){
        for(int i =0; i < 12 ; i++) {
            Player_info.player_info1[i].name = t2[i];
        }
    }


    public String[] getT1() {


        EditText p1t = findViewById(R.id.p1);
        EditText p2t = findViewById(R.id.p2);
        EditText p3t = findViewById(R.id.p3);
        EditText p4t = findViewById(R.id.p4);
        EditText p5t = findViewById(R.id.p5);
        EditText p6t = findViewById(R.id.p6);
        EditText p7t = findViewById(R.id.p7);
        EditText p8t = findViewById(R.id.p8);
        EditText p9t = findViewById(R.id.p9);
        EditText p10t = findViewById(R.id.p10);
        EditText p11t = findViewById(R.id.p11);
        EditText p12t = findViewById(R.id.p12);


        t1[0] = p1t.getText().toString();
        t1[1] = p2t.getText().toString();
        t1[2] = p3t.getText().toString();
        t1[3] = p4t.getText().toString();
        t1[4] = p5t.getText().toString();
        t1[5] = p6t.getText().toString();
        t1[6] = p7t.getText().toString();
        t1[7] = p8t.getText().toString();
        t1[8] = p9t.getText().toString();
        t1[9] = p10t.getText().toString();
        t1[10] = p11t.getText().toString();
        t1[11] = p12t.getText().toString();
        return t1;
    }

    public String[] getT2() {


        EditText p1to = findViewById(R.id.p1o);
        EditText p2to = findViewById(R.id.p2o);
        EditText p3to = findViewById(R.id.p3o);
        EditText p4to = findViewById(R.id.p4o);
        EditText p5to = findViewById(R.id.p5o);
        EditText p6to = findViewById(R.id.p6o);
        EditText p7to = findViewById(R.id.p7o);
        EditText p8to = findViewById(R.id.p8o);
        EditText p9to = findViewById(R.id.p9o);
        EditText p10to = findViewById(R.id.p10o);
        EditText p11to = findViewById(R.id.p11o);
        EditText p12to = findViewById(R.id.p12o);


        t2[0] = p1to.getText().toString();
        t2[1] = p2to.getText().toString();
        t2[2] = p3to.getText().toString();
        t2[3] = p4to.getText().toString();
        t2[4] = p5to.getText().toString();
        t2[5] = p6to.getText().toString();
        t2[6] = p7to.getText().toString();
        t2[7] = p8to.getText().toString();
        t2[8] = p9to.getText().toString();
        t2[9] = p10to.getText().toString();
        t2[10] = p11to.getText().toString();
        t2[11] = p12to.getText().toString();
        return t2;

    }


    public void setPlayerNameT1(View view){
        Player_info player_info = new Player_info();
        player_info.Player_info_creat();

        getT1();
        getT2();

        setter();
        setter1();


        Intent intent = new Intent(this, EnterTeamName.class);
        startActivity(intent);

    }


}
