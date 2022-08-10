package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AssessmentInfo extends AppCompatActivity {

    EditText editAssessmentName;
    EditText editAssessmentType;


    int assessmentID;
    String assessmentName;
    String assessmentType;


    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editAssessmentName = findViewById(R.id.editAssessmentName);
        editAssessmentType = findViewById(R.id.editAssessmentType);


        assessmentID = getIntent().getIntExtra("assessmentID", -1);


        assessmentName = getIntent().getStringExtra("assessmentName");
        editAssessmentName.setText(assessmentName);

        assessmentType = getIntent().getStringExtra("assessmentType");
        editAssessmentType.setText(assessmentType);


        repository = new Repository(getApplication());
    }


    public void saveButton2(View view) {
        Assessments assessments;
        if(assessmentID == -1){
            int newID = repository.getAllAssessments().get(repository.getAllAssessments().size() - 1).getAssessmentID() + 1;
            assessments = new Assessments(newID, editAssessmentName.getText().toString(), editAssessmentType.getText().toString());
            repository.insert(assessments);
        }
        else {
            assessments = new Assessments(assessmentID, editAssessmentName.getText().toString(), editAssessmentType.getText().toString());
            repository.update(assessments);
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.menu_courselist, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem courses) {
        switch (courses.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(courses);
    }


}
