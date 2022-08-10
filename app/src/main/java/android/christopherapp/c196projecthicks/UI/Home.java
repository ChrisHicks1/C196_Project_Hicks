package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toAssessments(View view) {
        Intent intent=new Intent(Home.this, AssessmentList.class );
        startActivity(intent);
    }

    public void toTerms(View view) {
        Intent intent=new Intent(Home.this, TermList.class );
        startActivity(intent);
    }

    public void toCourses(View view) {
        Intent intent=new Intent(Home.this, CourseList.class );
        startActivity(intent);
    }
}