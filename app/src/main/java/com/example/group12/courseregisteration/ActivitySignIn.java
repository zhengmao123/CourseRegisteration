package com.example.group12.courseregisteration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.graphics.Color;

public class ActivitySignIn extends AppCompatActivity {

    Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView message;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null)
        {
            startActivity(new Intent(getApplicationContext(),ActivityUserProfile.class));
        }


        buttonSignIn = (Button)findViewById(R.id.buttonSignin);
        editTextEmail = (EditText)findViewById(R.id.inputEmail);
        editTextPassword = (EditText)findViewById(R.id.inputPassword);
        message = (TextView) findViewById(R.id.Message);


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSignIn();

            }
        });


    }


    public void userSignIn(){

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //finish();
                            message.setText("Verification success!");
                            message.setTextColor(Color.GREEN);
                            finish();
                            startActivity(new Intent(getApplicationContext(), ActivityUserProfile.class));
                        }
                        else{
                            message.setText("Invaild email or password!");
                            message.setTextColor(Color.RED);
                        }

                    }
                });

    }


}
