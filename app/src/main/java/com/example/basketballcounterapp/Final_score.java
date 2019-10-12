package com.example.basketballcounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Final_score extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Button button = findViewById(R.id.logout);
         button.setOnClickListener(click1);




        TextView textView =  (TextView) findViewById(R.id.scoreShow);
        textView.setText("");
        String summary="";



        TextView textViewF =  (TextView) findViewById(R.id.finals);
        String statementFinal="";

        if((EnterTeamName.scoreCount - EnterTeamName.opponentCount)> 0 ){
            statementFinal="Team " + MainActivity.s1 + " Won by " + (EnterTeamName.scoreCount - EnterTeamName.opponentCount) + " points";
        }else if ((EnterTeamName.scoreCount - EnterTeamName.opponentCount) < 0 ){
            statementFinal="Team " + MainActivity.s2 + " Won by " + Math.abs(EnterTeamName.scoreCount - EnterTeamName.opponentCount)+ " points";
        }else {
            statementFinal=" *** TIE *** ";
        }

        textViewF.setText(""+statementFinal);




        for (int i=0; (i < 12)   ; i++) {

            if(Player_info.player_info[i].name.isEmpty()){
                continue;
            }

                summary += "Points Score by : " + Player_info.player_info[i].name + "\n\n";
                summary += "  Three's     : " + Player_info.player_info[i].Three_pointer + "\n";
                summary += "  Two Points  : " + Player_info.player_info[i].Two_points + "\n";
                summary += "  Free Throws : " + Player_info.player_info[i].Free_throws + "\n\n";
                summary += "  Fouls : " + Player_info.player_info[i].foul + "\n\n";
                summary += "  Total Points: " + (Player_info.player_info[i].Three_pointer*3 + Player_info.player_info[i].Two_points*2+Player_info.player_info[i].Free_throws*1 )+"\n";
                summary += "_________________________\n\n\n";
        }



        textView.setText(summary);

        TextView textView1 =  (TextView) findViewById(R.id.scoreShow1);
        textView1.setText("");
        String summary1="";

        for (int i=0;(i < 12) && Player_info.player_info1[i].name !="" ; i++) {

            if(Player_info.player_info1[i].name.isEmpty()){
                continue;
            }

            summary1 += "Points Score by : " + Player_info.player_info1[i].name + "\n\n";
            summary1 += "  Three's     : " + Player_info.player_info1[i].Three_pointer + "\n";
            summary1 += "  Two Points  : " + Player_info.player_info1[i].Two_points + "\n";
            summary1 += "  Free Throws : " + Player_info.player_info1[i].Free_throws + "\n\n";
            summary1 += "  Fouls : " + Player_info.player_info1[i].foul + "\n\n";
            summary1 += "  Total Points: " + (Player_info.player_info1[i].Three_pointer*3 + Player_info.player_info1[i].Two_points*2+Player_info.player_info1[i].Free_throws*1 )+"\n";
            summary1 += "_________________________\n\n\n";
        }

        textView1.setText(summary1);


        TextView textViewscores1 =  (TextView) findViewById(R.id.scoreShowT1);

        String resultT1=" Team  "+ MainActivity.s1 + " scored >>> " + EnterTeamName.scoreCount ;

        textViewscores1.setText("" + resultT1);

        TextView textViewscores2 =  (TextView) findViewById(R.id.scoreShowT2);

        String resultT2=" Team  "+ MainActivity.s2 + " scored >>> " + EnterTeamName.opponentCount ;

        textViewscores2.setText("" + resultT2);

    }
    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:tupesanket1999@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "suggestions regarding android app");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void callmeph(){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+917507381366"));//change the number
        startActivity(callIntent);
    }


    public void suggestion(View view){
        composeEmail();
    }
    public void callme(View view){
        callmeph();
    }


    View.OnClickListener click1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Final_score.this, login_screen.class);
            startActivity(intent);
        }
    };

}
