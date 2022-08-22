package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=findViewById(R.id.recyclerView1);
        Repository repo=new Repository(getApplication());
        List<Term> terms=repo.getAllTerms();
        final TermAdapter adapter=new TermAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTerm(terms);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.menu_termlist, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem terms) {
        switch (terms.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;


            case R.id.addTerm:
                Intent term=new Intent(TermList.this, TermDetail.class);
                startActivity(term);
                return true;

            case R.id.refresh:
                Intent refresh=new Intent(TermList.this, TermList.class);
                startActivity(refresh);
                return true;
        }
        return super.onOptionsItemSelected(terms);
    }

}