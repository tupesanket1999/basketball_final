package com.example.basketballcounterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_screen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if(currentUser != null ){

            //updateUI(currentUser);

            Intent intent = new Intent(login_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        Button login = findViewById(R.id.login);
        TextView resister = findViewById(R.id.register);
        login.setOnClickListener(clickListener);
        resister.setOnClickListener(clickListener1);
    }

    /*private void updateUI(FirebaseUser currentUser) {


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("email");

            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Log.d(">>>>>>>>>>>>>>>>>>>>>>>","read successful ");

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value

                }
            });

        }

     */

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String pass;
            final String user;
            TextView emailId = findViewById(R.id.emailId);
            TextView passWd = findViewById(R.id.passWd);

            user = emailId.getText().toString();
            pass = passWd.getText().toString();

            if(pass.isEmpty() || user.isEmpty()){
                Toast.makeText(getApplicationContext(),"Fields are Empty", Toast.LENGTH_SHORT).show();
            }else{

                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                firebaseAuth.signInWithEmailAndPassword(user, pass)
                        .addOnCompleteListener(login_screen.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(getApplicationContext(),"Logged In  > "+ user +" successfully !", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(login_screen.this,MainActivity.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(),"UN successfully !", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        }
    };




    public View.OnClickListener clickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(),register_screen.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Resgister", Toast.LENGTH_SHORT).show();
        }
    };

    public void sendData(){

    }
}