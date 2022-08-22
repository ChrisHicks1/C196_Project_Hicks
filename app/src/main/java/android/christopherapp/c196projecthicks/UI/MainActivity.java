package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public static int numAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onLogin(View view) {
        Intent intent=new Intent(MainActivity.this, Home.class );
        startActivity(intent);


        Repository repo = new Repository(getApplication());
        Courses courses=new Courses(1, "Mobile App Development", "07/19/2022", "08/22/2022","In Progress", "CI Person", "222-222-2222", "anEmail@email.com");
        repo.insert(courses);

        Term term=new Term(1, "First Term", "06/01/2022", "11/30/2022");
        repo.insert(term);

        Assessments assessments=new Assessments(1, "Application Development", "@", "08/18/22", "08/24/22");
        repo.insert(assessments);


        Notes notes=new Notes(1,"Note 1", "This is a note about notes");
        repo.insert(notes);
    }
}