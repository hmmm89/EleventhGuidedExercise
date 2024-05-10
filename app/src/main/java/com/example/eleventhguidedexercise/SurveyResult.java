package com.example.eleventhguidedexercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SurveyResult extends AppCompatActivity {

    TextView name, age, gender, subjects, job, thesis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_survey_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        showResults();

        Button confirmButton = findViewById(R.id.btnSubmit);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurveyResult.this, SurveyConfirm.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        name = findViewById(R.id.txtNameR);
        age = findViewById(R.id.txtAgeR);
        gender = findViewById(R.id.txtGenderR);
        subjects = findViewById(R.id.txtSubR);
        job = findViewById(R.id.txtJobR);
        thesis = findViewById(R.id.txtThesisR);
    }

    public void showResults(){
        //getStringExtra(Home. EXTRA_MESSAGE). equals(getString(R. string. ...
        // Note: If you have set values using putExtra(key, String) then you can simply get values using intent.
        name.setText("Name: " + getIntent().getStringExtra("id_name"));
        age.setText("Age: " +getIntent().getStringExtra("id_age"));
        gender.setText("Gender: " +getIntent().getStringExtra("id_gender"));
        subjects.setText("Subjects: \n" +getIntent().getStringExtra("id_subjects"));
        job.setText("Job: " +getIntent().getStringExtra("id_job"));
        thesis.setText("Thesis Topic: " +getIntent().getStringExtra("id_thesis"));
    }
}
