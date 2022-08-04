package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

        public boolean onCreateOptionsMenu(Menu menu) {

            // Inflate the menu; this adds items to the action bar if it is present

            getMenuInflater().inflate(R.menu.menu_termlist, menu);
            return true;

        }

        public boolean onOptionsTermSelected(MenuItem term) {
            switch (term.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
            }
                return super.onOptionsItemSelected(term);
            }

    public void goToCourseList(View view) {
        Intent intent=new Intent(TermList.this, CourseList.class);
        startActivity(intent);
    }
}

