package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssessmentList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=findViewById(R.id.recyclerView8);
        Repository repo=new Repository(getApplication());
        List<Assessments> assessments=repo.getAllAssessments();
        final AssessmentAdapter adapter=new AssessmentAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAssessments(assessments);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.menu_assessmentlist, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem assessments) {
        switch (assessments.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(assessments);
    }
    public void goToAssessmentInfo(View view) {
        Intent intent=new Intent(AssessmentList.this, AssessmentInfo.class);
        startActivity(intent);
    }

}
