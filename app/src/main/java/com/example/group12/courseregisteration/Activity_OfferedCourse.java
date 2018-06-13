package com.example.group12.courseregisteration;

//test test

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_OfferedCourse extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_course);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Courses");




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = (int)dataSnapshot.getChildrenCount();
                Toast.makeText(getApplicationContext(), "TEST",Toast.LENGTH_LONG).show();
                int position = 0;
                String[] courseNames = new String[count];
                for (DataSnapshot child : dataSnapshot.getChildren())
                {
                    courseNames[position] = child.getKey();
                    position++;
                }

                displayCourses(courseNames);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();
            }
        });

//        profile = (Button)findViewById(R.id.button6);
//
//        profile.setOnClickListener(this);


    }

    public void displayCourses(String[] courseNames)
    {
        ListAdapter adpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courseNames);
        ListView listview  = (ListView)findViewById(R.id.viewer);
        listview.setAdapter(adpt);

        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(getBaseContext(), Activity_CourseInformation.class);
                        intent.putExtra("COURSE", food);
                        finish();
                        startActivity(intent);
                    }
                }
        );
    }


//    @Override
//    public void onClick(View v) {
//        if(v==profile)
//        {
//            finish();
//            startActivity(new Intent(this, ProfileActivity.class));
//        }
//    }
}
