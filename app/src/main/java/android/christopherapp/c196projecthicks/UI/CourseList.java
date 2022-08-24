package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class CourseList extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Repository repo = new Repository(getApplication());
        List<Courses> courses = repo.getAllCourses();
        final CoursesAdapter adapter = new CoursesAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCourses(courses);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.menu_courselist, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem course) {
        switch (course.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.addCourse:
                Intent courses=new Intent(CourseList.this, CourseDetail.class);
                startActivity(courses);
                return true;

            case R.id.refresh:
                Intent refresh=new Intent(CourseList.this, CourseList.class);
                startActivity(refresh);
                return true;
        }
        return super.onOptionsItemSelected(course);
    }

}