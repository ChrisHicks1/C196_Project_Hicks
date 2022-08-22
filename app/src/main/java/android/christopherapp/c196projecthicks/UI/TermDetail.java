package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.christopherapp.c196projecthicks.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TermDetail extends AppCompatActivity {

    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;


    int termID;
    String termName;
    String termStart;
    String termEnd;


    DatePickerDialog.OnDateSetListener startDates;
    DatePickerDialog.OnDateSetListener endDates;
    final Calendar myCalendarStart = Calendar.getInstance();
    final Calendar myCalendarEnd = Calendar.getInstance();
    String myFormat;
    SimpleDateFormat sdf;


    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
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


        editTermStart=findViewById(R.id.editTermStart);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTermStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editTermStart.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(TermDetail.this, startDates, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editTermEnd=findViewById(R.id.editTermEnd);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTermEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editTermEnd.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(TermDetail.this, endDates, myCalendarEnd.get(Calendar.YEAR),
                        myCalendarEnd.get(Calendar.MONTH),
                        myCalendarEnd.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        startDates=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendarStart.set(Calendar.YEAR,year);
                myCalendarStart.set(Calendar.MONTH,monthOfYear);
                myCalendarStart.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabelStart();
            }
        };

        endDates=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendarEnd.set(Calendar.YEAR,year);
                myCalendarEnd.set(Calendar.MONTH,monthOfYear);
                myCalendarEnd.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabelEnd();
            }
        };



        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        Repository repo = new Repository(getApplication());
        List<Courses> courses = repo.getAllCourses();
        final CoursesAdapter adapter = new CoursesAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCourses(courses);
    }

    private void updateLabelStart() {
        editTermStart.setText(sdf.format(myCalendarStart.getTime()));
    }
    private void updateLabelEnd() {

        editTermEnd.setText(sdf.format(myCalendarEnd.getTime()));
    }


    public void saveButton1(View view) {
        Term terms;
        if(termID == -1){
            int newID = repository.getAllTerms().get(repository.getAllTerms().size() - 1).getTermID() + 1;
            terms = new Term(newID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
            repository.insert(terms);
            Intent refresh=new Intent(TermDetail.this, TermList.class);
            startActivity(refresh);
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

        public boolean onOptionsItemSelected(MenuItem terms) {
            switch (terms.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;

                case R.id.addCourse:
                    Intent term=new Intent(TermDetail.this, CourseDetail.class);
                    startActivity(term);
                    return true;
            }
                return super.onOptionsItemSelected(terms);
            }

}

