package com.example.basketballcounterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        Button button = findViewById(R.id.register);
        button.setOnClickListener(clickListener);
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView emailcr = findViewById(R.id.emailIdcr);
            TextView passcr = findViewById(R.id.passWdcr);
            TextView name = findViewById(R.id.name);

            final String email= emailcr.getText().toString();
            String pass = passcr.getText().toString();
            final String user_name = name.getText().toString();

            if(pass.isEmpty() || email.isEmpty() || user_name.isEmpty()){
                Toast.makeText(getApplicationContext(),"Fields are Empty", Toast.LENGTH_SHORT).show();
            }else
                {

                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(register_screen.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(),"Created user  > "+email +" successfully !", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(register_screen.this, login_screen.class);
                                    FirebaseAuth.getInstance().signOut();

                                    startActivity(intent);

                                } else {
                                    Toast.makeText(getApplicationContext(),"Unsuccessfully !", Toast.LENGTH_SHORT).show();
                                }
                                // ...
                            }
                        });
            }
        }
    };
}
