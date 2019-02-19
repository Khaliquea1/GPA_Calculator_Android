package com.example.gpa_khaliquea1_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    TextView gpaText;
    Button gpaButton;
    EditText course1, course2, course3, course4, course5;
    int addCourses;
    double gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpaText = (TextView)findViewById(R.id.gpa);
        gpaButton =(Button)findViewById(R.id.gpaButton);
        course1 = (EditText)findViewById(R.id.course1);
        course2 = (EditText)findViewById(R.id.course2);
        course3 = (EditText)findViewById(R.id.course3);
        course4 = (EditText)findViewById(R.id.course4);
        course5 = (EditText)findViewById(R.id.course5);



        gpaButton.setOnClickListener(this::computeGPA);
        Log.i(TAG, "onCreate is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume is called");
    }

    public void computeGPA(View view) {

        String course_1 = course1.getText().toString();
        String course_2 = course2.getText().toString();
        String course_3 = course3.getText().toString();
        String course_4 = course4.getText().toString();
        String course_5 = course5.getText().toString();

        if (("".equals(course1.getText().toString().trim())
                || "".equals(course2.getText().toString().trim())
                || "".equals(course3.getText().toString().trim())
                || "".equals(course4.getText().toString().trim())
                || "".equals(course5.getText().toString().trim()))){
            Toast.makeText(this, "A value is missing!", Toast.LENGTH_LONG).show();

        }
        else {

            addCourses = Integer.parseInt(course_1)
                    + Integer.parseInt(course_2)
                    + Integer.parseInt(course_3)
                    + Integer.parseInt(course_4)
                    + Integer.parseInt(course_5);
            Log.i(TAG, "addCourses value = " + addCourses);
            gpa = addCourses/5;

            Log.i(TAG, "gpa value = " + gpa);

            gpaText.setText(Double.toString(gpa));

            gpaButton.setText("Clear Form");

            if(gpa < 61){
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.red);
            } else if (gpa >60 && gpa < 80){
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.yellow);
            } else if (gpa >79 && gpa < 101) {
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.color.green);
            }

        }

    }
}
