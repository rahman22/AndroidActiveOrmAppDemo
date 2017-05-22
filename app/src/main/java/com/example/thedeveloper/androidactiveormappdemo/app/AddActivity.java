package com.example.thedeveloper.androidactiveormappdemo.app;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thedeveloper.androidactiveormappdemo.R;
import com.example.thedeveloper.androidactiveormappdemo.models.SubjectList;

import es.dmoral.toasty.Toasty;

public class AddActivity extends AppCompatActivity {


    TextInputLayout subjectName, subjectDescription;
    EditText subject_name, subject_description;
    SubjectList subjectList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Add Subject");
        setSupportActionBar(toolbar);
        subjectName = (TextInputLayout) findViewById(R.id.inputLayoutSubjectName);
        subjectDescription = (TextInputLayout) findViewById(R.id.inputLayoutSubjectDesc);
        subject_name = (EditText) findViewById(R.id.nameeditText);
        subject_description = (EditText) findViewById(R.id.descriptioneditText);
    }

    public void addProducts(View view) {

        subjectList = new SubjectList();
        String subject = subject_name.getText().toString();
        String description = subject_description.getText().toString();

        if(validateSubjectName() && validateSubjectDescription()){

            subjectList.setNameSubject(subject);
            subjectList.setDescriptionSubject(description);
            subjectList.save();
            startActivity(new Intent(AddActivity.this, MainActivity.class));

        }



    }

    public boolean validateSubjectName(){

        if(subject_name.getText().toString().isEmpty()){
            subjectName.setError("subject name is blank");
            return false;
        }

        else{
            subjectName.setErrorEnabled(false);
            return true;
        }

    }

    public boolean validateSubjectDescription(){

        if(subject_description.getText().toString().isEmpty()){
            subjectDescription.setError("subject description is blank");
            return false;
        }

        else{
            subjectDescription.setErrorEnabled(false);
            return true;
        }
    }


}
