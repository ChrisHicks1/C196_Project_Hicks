package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TermInfo extends AppCompatActivity {

    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;


    int termID;
    String termName;
    String termStart;
    String termEnd;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editTermName = findViewById(R.id.editTermName);
        editTermStart = findViewById(R.id.editTermStart);
        editTermEnd = findViewById(R.id.editTermEnd);


        termID = getIntent().getIntExtra("termID", -1);


        termName = getIntent().getStringExtra("termName");
        editTermName.setText(termName);

        termStart = getIntent().getStringExtra("termStart");
        editTermStart.setText(termStart);

        termEnd = getIntent().getStringExtra("termEnd");
        editTermEnd.setText(termEnd);

        repository = new Repository(getApplication());
    }


    public void saveButton1(View view) {
        Term terms;
        if(termID == -1){
            int newID = repository.getAllTerms().get(repository.getAllTerms().size() - 1).getTermID() + 1;
            terms = new Term(newID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
            repository.insert(terms);
        }
        else {
            terms = new Term(termID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
            repository.update(terms);
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



    public void goToCourseList(View view) {
        Intent intent=new Intent(TermInfo.this, CourseList.class);
        startActivity(intent);
    }
}

