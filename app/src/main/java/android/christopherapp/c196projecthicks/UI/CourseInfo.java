package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CourseInfo extends AppCompatActivity {


    EditText editCourseName;
    EditText editCourseStart;
    EditText editCourseEnd;
    EditText editCourseStatus;
    EditText editCIName;
    EditText editCIPhone;
    EditText editCIEmail;

    int courseID;
    String name;
    String startDate;
    String endDate;
    String courseStatus;
    String ciName;
    String ciPhone;
    String ciEmail;


    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editCourseName=findViewById(R.id.editCourseName);
        editCourseStart=findViewById(R.id.editCourseStart);
        editCourseEnd=findViewById(R.id.editCourseEnd);
        editCourseStatus=findViewById(R.id.editCourseStatus);
        editCIName=findViewById(R.id.editCIName);
        editCIPhone=findViewById(R.id.editCIPhone);
        editCIEmail=findViewById(R.id.editCIEmail);

        courseID=getIntent().getIntExtra("courseID", -1);


        name=getIntent().getStringExtra("name");
        editCourseName.setText(name);

        startDate=getIntent().getStringExtra("startDate");
        editCourseStart.setText(startDate);

        endDate=getIntent().getStringExtra("endDate");
        editCourseEnd.setText(endDate);

        courseStatus=getIntent().getStringExtra("status");
        editCourseStatus.setText(courseStatus);

        ciName=getIntent().getStringExtra("ciName");
        editCIName.setText(ciName);

        ciPhone=getIntent().getStringExtra("ciPhone");
        editCIPhone.setText(ciPhone);

        ciEmail=getIntent().getStringExtra("ciEmail");
        editCIEmail.setText(ciEmail);

        repository=new Repository(getApplication());

    }

    public void saveButton(View view) {
        Courses courses;
        if(courseID == -1){
            int newID = repository.getAllCourses().get(repository.getAllCourses().size() - 1).getCourseID() + 1;
            courses = new Courses(newID, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString(), editCourseStatus.getText().toString(), editCIName.getText().toString(), editCIPhone.getText().toString(), editCIEmail.getText().toString());
            repository.insert(courses);
        }
        else {
            courses = new Courses(courseID, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString(), editCourseStatus.getText().toString(), editCIName.getText().toString(), editCIPhone.getText().toString(), editCIEmail.getText().toString());
            repository.update(courses);
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.menu_assessmentlist, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem assessment) {
        switch (assessment.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(assessment);
    }


    public void goToAssessmentList(View view) {
        Intent intent=new Intent(CourseInfo.this, AssessmentList.class);
        startActivity(intent);
    }
}