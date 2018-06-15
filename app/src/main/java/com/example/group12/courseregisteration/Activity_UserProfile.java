package com.example.group12.courseregisteration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_UserProfile extends AppCompatActivity {

    private Button buttonSignOut;
    private Button buttonOfferedCourses;
    private Button buttonSchedule;
    private TextView showEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Activity_SignIn.class));
        }


        buttonSignOut =(Button)findViewById(R.id.buttonSignOut);
        buttonOfferedCourses = (Button)findViewById(R.id.buttonOfferedCourse);
        buttonSchedule = (Button)findViewById(R.id.buttonSchedule);

        showEmail = (TextView)findViewById(R.id.textViewEmail);
        showEmail.setText(mAuth.getCurrentUser().getEmail());


        //sign out button
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), Activity_SignIn.class));

            }
        });


        //offeredCourses button
        buttonOfferedCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Activity_OfferedCourses.class));
            }
        });


        //Schedule button
        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Activity_Schedule.class));
            }
        });





    }
}
