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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.graphics.Color;

public class Activity_UserProfile extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private Button cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        cv = findViewById(R.id.courseView);

        cv.setOnClickListener(this);


    }

    public void onClick(View v) {
        if(v==cv)
        {
            finish();
            startActivity(new Intent(this, Activity_OfferedCourse.class));
        }

    }
}
