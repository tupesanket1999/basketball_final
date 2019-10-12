package com.example.basketballcounterapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.basketballcounterapp.MainActivity.s1;
import static com.example.basketballcounterapp.MainActivity.s2;


public class EnterTeamName extends AppCompatActivity {


    ListView listView ;

    TextView textView ;

    Button start, pause, reset, lap ;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

    String[] ListElements = new String[] {  };

    List<String> ListElementsArrayList ;

    ArrayAdapter<String> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_team_name);


        displayTeams(teamA,teamB);


        textView = (TextView)findViewById(R.id.textView);
        start = (Button)findViewById(R.id.button);
        pause = (Button)findViewById(R.id.button2);
        reset = (Button)findViewById(R.id.button3);
        lap = (Button)findViewById(R.id.button4) ;
        listView = (ListView)findViewById(R.id.listview1);

        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(EnterTeamName.this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );

        listView.setAdapter(adapter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                textView.setText("00:00:00");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
                opponentCount = 0;
                scoreCount=0;

                displayScore1(opponentCount);
                displayScore(scoreCount);

                for(int i =0; i < 12; i++) {
                    Player_info.player_info[i].Three_pointer = 0;
                    Player_info.player_info1[i].Three_pointer = 0;
                    Player_info.player_info[i].Two_points = 0;
                    Player_info.player_info1[i].Two_points= 0;
                    Player_info.player_info[i].Free_throws = 0;
                    Player_info.player_info1[i].Free_throws = 0;
                }

            }
        });

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListElementsArrayList.add(textView.getText().toString());

                adapter.notifyDataSetChanged();

            }
        });






    }




    String teamA = s1;
    String teamB = s2;

    static int scoreCount = 0;
    static int opponentCount = 0;





    public void IncrementByThree(View view) {
        scoreCount = scoreCount + 3;
        displayScore(scoreCount);


        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Three Pointer by ? ");


// add a list
        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t1));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // player1
                        Player_info.player_info[0].Three_pointer++;
                        break;
                    case 1: // player2
                        Player_info.player_info[1].Three_pointer++;
                        break;
                    case 2: // player3
                        Player_info.player_info[2].Three_pointer++;
                        break;
                    case 3: // player4
                        Player_info.player_info[3].Three_pointer++;
                        break;
                    case 4: // player5
                        Player_info.player_info[4].Three_pointer++;
                        break;
                    case 5: // player6
                        Player_info.player_info[5].Three_pointer++;
                        break;
                    case 6: // player7
                        Player_info.player_info[6].Three_pointer++;
                        break;
                    case 7: // player8
                        Player_info.player_info[7].Three_pointer++;
                        break;
                    case 8: // player9
                        Player_info.player_info[8].Three_pointer++;
                        break;
                    case 9: // player10
                        Player_info.player_info[9].Three_pointer++;
                        break;
                    case 10: // player11
                        Player_info.player_info[10].Three_pointer++;
                        break;
                    case 11: // player12
                        Player_info.player_info[11].Three_pointer++;
                        break;

                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();


    }
    public void IncrementByTwo(View view) {
        scoreCount = scoreCount + 2;
        displayScore(scoreCount);

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Two Pointer by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t1));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // player1
                        Player_info.player_info[0].Two_points++;
                        break;
                    case 1: // player2
                        Player_info.player_info[1].Two_points++;
                        break;
                    case 2: // player3
                        Player_info.player_info[2].Two_points++;
                        break;
                    case 3: // player4
                        Player_info.player_info[3].Two_points++;
                        break;
                    case 4: // player5
                        Player_info.player_info[4].Two_points++;
                        break;
                    case 5: // player6
                        Player_info.player_info[5].Two_points++;
                        break;
                    case 6: // player7
                        Player_info.player_info[6].Two_points++;
                        break;
                    case 7: // player8
                        Player_info.player_info[7].Two_points++;
                        break;
                    case 8: // player9
                        Player_info.player_info[8].Two_points++;
                        break;
                    case 9: // player10
                        Player_info.player_info[9].Two_points++;
                        break;
                    case 10: // player11
                        Player_info.player_info[10].Two_points++;
                        break;
                    case 11: // player12
                        Player_info.player_info[11].Two_points++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void IncrementByOne(View view) {
        scoreCount++;
        displayScore(scoreCount);

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("free throw by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t1));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {


                    case 0: // player1
                        Player_info.player_info[0].Free_throws++;
                        break;
                    case 1: // player2
                        Player_info.player_info[1].Free_throws++;
                        break;
                    case 2: // player3
                        Player_info.player_info[2].Free_throws++;
                        break;
                    case 3: // player4
                        Player_info.player_info[3].Free_throws++;
                        break;
                    case 4: // player5
                        Player_info.player_info[4].Free_throws++;
                        break;
                    case 5: // player6
                        Player_info.player_info[5].Free_throws++;
                        break;
                    case 6: // player7
                        Player_info.player_info[6].Free_throws++;
                        break;
                    case 7: // player8
                        Player_info.player_info[7].Free_throws++;
                        break;
                    case 8: // player9
                        Player_info.player_info[8].Free_throws++;
                        break;
                    case 9: // player10
                        Player_info.player_info[9].Free_throws++;
                        break;
                    case 10: // player11
                        Player_info.player_info[10].Free_throws++;
                        break;
                    case 11: // player12
                        Player_info.player_info[11].Free_throws++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void Foul(View view) {


        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("foul by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t1));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {


                    case 0: // player1
                        Player_info.player_info[0].foul++;
                        break;
                    case 1: // player2
                        Player_info.player_info[1].foul++;
                        break;
                    case 2: // player3
                        Player_info.player_info[2].foul++;
                        break;
                    case 3: // player4
                        Player_info.player_info[3].foul++;
                        break;
                    case 4: // player5
                        Player_info.player_info[4].foul++;
                        break;
                    case 5: // player6
                        Player_info.player_info[5].foul++;
                        break;
                    case 6: // player7
                        Player_info.player_info[6].foul++;
                        break;
                    case 7: // player8
                        Player_info.player_info[7].foul++;
                        break;
                    case 8: // player9
                        Player_info.player_info[8].foul++;
                        break;
                    case 9: // player10
                        Player_info.player_info[9].foul++;
                        break;
                    case 10: // player11
                        Player_info.player_info[10].foul++;
                        break;
                    case 11: // player12
                        Player_info.player_info[11].foul++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void IncrementByThree1(View view) {
        opponentCount = opponentCount + 3;
        displayScore1(opponentCount);

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Three Pointer by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t2));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // player1
                        Player_info.player_info1[0].Three_pointer++;
                        break;
                    case 1: // player2
                        Player_info.player_info1[1].Three_pointer++;
                        break;
                    case 2: // player3
                        Player_info.player_info1[2].Three_pointer++;
                        break;
                    case 3: // player4
                        Player_info.player_info1[3].Three_pointer++;
                        break;
                    case 4: // player5
                        Player_info.player_info1[4].Three_pointer++;
                        break;
                    case 5: // player6
                        Player_info.player_info1[5].Three_pointer++;
                        break;
                    case 6: // player7
                        Player_info.player_info1[6].Three_pointer++;
                        break;
                    case 7: // player8
                        Player_info.player_info1[7].Three_pointer++;
                        break;
                    case 8: // player9
                        Player_info.player_info1[8].Three_pointer++;
                        break;
                    case 9: // player10
                        Player_info.player_info1[9].Three_pointer++;
                        break;
                    case 10: // player11
                        Player_info.player_info1[10].Three_pointer++;
                        break;
                    case 11: // player12
                        Player_info.player_info1[11].Three_pointer++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void IncrementByTwo1(View view) {
        opponentCount = opponentCount + 2;
        displayScore1(opponentCount);

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Two Pointer by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t2));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // player1
                        Player_info.player_info1[0].Two_points++;
                        break;
                    case 1: // player2
                        Player_info.player_info1[1].Two_points++;
                        break;
                    case 2: // player3
                        Player_info.player_info1[2].Two_points++;
                        break;
                    case 3: // player4
                        Player_info.player_info1[3].Two_points++;
                        break;
                    case 4: // player5
                        Player_info.player_info1[4].Two_points++;
                        break;
                    case 5: // player6
                        Player_info.player_info1[5].Two_points++;
                        break;
                    case 6: // player7
                        Player_info.player_info1[6].Two_points++;
                        break;
                    case 7: // player8
                        Player_info.player_info1[7].Two_points++;
                        break;
                    case 8: // player9
                        Player_info.player_info1[8].Two_points++;
                        break;
                    case 9: // player10
                        Player_info.player_info1[9].Two_points++;
                        break;
                    case 10: // player11
                        Player_info.player_info1[10].Two_points++;
                        break;
                    case 11: // player12
                        Player_info.player_info1[11].Two_points++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void IncrementByOne1(View view) {
        opponentCount++;
        displayScore1(opponentCount);

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Free throw by ? ");


// add a list

       // String[] animals = PlayerName.t2;

        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t2));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);



        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0: // player1
                        Player_info.player_info1[0].Free_throws++;
                        break;
                    case 1: // player2
                        Player_info.player_info1[1].Free_throws++;
                        break;
                    case 2: // player3
                        Player_info.player_info1[2].Free_throws++;
                        break;
                    case 3: // player4
                        Player_info.player_info1[3].Free_throws++;
                        break;
                    case 4: // player5
                        Player_info.player_info1[4].Free_throws++;
                        break;
                    case 5: // player6
                        Player_info.player_info1[5].Free_throws++;
                        break;
                    case 6: // player7
                        Player_info.player_info1[6].Free_throws++;
                        break;
                    case 7: // player8
                        Player_info.player_info1[7].Free_throws++;
                        break;
                    case 8: // player9
                        Player_info.player_info1[8].Free_throws++;
                        break;
                    case 9: // player10
                        Player_info.player_info1[9].Free_throws++;
                        break;
                    case 10: // player11
                        Player_info.player_info1[10].Free_throws++;
                        break;
                    case 11: // player12
                        Player_info.player_info1[11].Free_throws++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void Foul1(View view) {

        // setup the alert builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("foul by ? ");


// add a list


        List<String> animals1 = new ArrayList<String>(Arrays.asList(PlayerName.t2));
        animals1.removeAll(Arrays.asList("", null));
        String animals [] = animals1.toArray(new String[0]);

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {

                switch (which) {


                    case 0: // player1
                        Player_info.player_info1[0].foul++;


                        break;
                    case 1: // player2
                        Player_info.player_info1[1].foul++;
                        break;
                    case 2: // player3
                        Player_info.player_info1[2].foul++;
                        break;
                    case 3: // player4
                        Player_info.player_info1[3].foul++;
                        break;
                    case 4: // player5
                        Player_info.player_info1[4].foul++;
                        break;
                    case 5: // player6
                        Player_info.player_info1[5].foul++;
                        break;
                    case 6: // player7
                        Player_info.player_info1[6].foul++;
                        break;
                    case 7: // player8
                        Player_info.player_info1[7].foul++;
                        break;
                    case 8: // player9
                        Player_info.player_info1[8].foul++;
                        break;
                    case 9: // player10
                        Player_info.player_info1[9].foul++;
                        break;
                    case 10: // player11
                        Player_info.player_info1[10].foul++;
                        break;
                    case 11: // player12
                        Player_info.player_info1[11].foul++;
                        break;
                }
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    private void displayScore(int scoreOfTeam) {
        TextView team1 = findViewById(R.id.team1);
        team1.setText("" + scoreOfTeam);
    }
    private void displayScore1(int opponentCount) {
        TextView team2 = findViewById(R.id.team2);
        team2.setText("" + opponentCount);
    }
    private void displayTeams(String A, String B) {
        TextView team1a = findViewById(R.id.nameOfTeamA);
        team1a.setText("" + A);
        TextView team2b =  findViewById(R.id.nameOfTeamB);
        team2b.setText("" + B);
    }

    public  void  genData(){

    }
    public void finish(View view){
        /*
       Data_match data_match = new Data_match(0);

// Write a message to the database
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("email");

        myRef.setValue(currentUser.getEmail());

        DatabaseReference myRef1 = database.getReference("email").child("data > ");

        myRef1.setValue(data_match);


         */

        Intent intent = new Intent(this, Final_score.class);
        startActivity(intent);



    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };

}