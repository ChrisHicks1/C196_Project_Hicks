package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onLogin(View view) {
        Intent intent=new Intent(MainActivity.this, Home.class );
        startActivity(intent);


        Repository repo = new Repository(getApplication());
        Courses courses=new Courses(1, "C196", "In Progress", "CI Person", "222-222-2222", "anEmail@email.com");
        repo.insert(courses);

        Term term=new Term(1, "First Term");
        repo.insert(term);

        Assessments assessments=new Assessments(1, "Application Development", "Performance");
        repo.insert(assessments);

    }
}