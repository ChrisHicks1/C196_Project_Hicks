package android.christopherapp.c196projecthicks.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CourseDetail extends AppCompatActivity {


    Courses currentCourse;

    EditText editCourseName;
    EditText editStartDate;
    EditText editEndDate;
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
        setContentView(R.layout.activity_course_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editCourseName=findViewById(R.id.editCourseName);
        editStartDate=findViewById(R.id.editStartDate);
        editEndDate=findViewById(R.id.editEndDate);
        editCourseStatus=findViewById(R.id.editCourseStatus);
        editCIName=findViewById(R.id.editCIName);
        editCIPhone=findViewById(R.id.editCIPhone);
        editCIEmail=findViewById(R.id.editCIEmail);

        courseID=getIntent().getIntExtra("courseID", -1);


        name=getIntent().getStringExtra("name");
        editCourseName.setText(name);

        startDate=getIntent().getStringExtra("startDate");
        editStartDate.setText(startDate);

        endDate=getIntent().getStringExtra("endDate");
        editEndDate.setText(endDate);

        courseStatus=getIntent().getStringExtra("status");
        editCourseStatus.setText(courseStatus);

        ciName=getIntent().getStringExtra("ciName");
        editCIName.setText(ciName);

        ciPhone=getIntent().getStringExtra("ciPhone");
        editCIPhone.setText(ciPhone);

        ciEmail=getIntent().getStringExtra("ciEmail");
        editCIEmail.setText(ciEmail);

        repository=new Repository(getApplication());


        editStartDate=findViewById(R.id.editStartDate);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editStartDate.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(CourseDetail.this, startDates, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editEndDate=findViewById(R.id.editEndDate);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editEndDate.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(CourseDetail.this, endDates, myCalendarEnd.get(Calendar.YEAR),
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

        RecyclerView recyclerView=findViewById(R.id.recyclerView2);
        Repository repo=new Repository(getApplication());
        List<Assessments> assessments=repo.getAllAssessments();
        final AssessmentAdapter adapter=new AssessmentAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAssessments(assessments);


        RecyclerView recyclerView1=findViewById(R.id.recyclerView4);
        Repository repo1=new Repository(getApplication());
        List<Notes> notes=repo1.getAllNotes();
        final NoteAdapter adapter1=new NoteAdapter(this);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        adapter1.setNotes(notes);

    }

    public void saveButton(View view) {
        Courses courses;
        if(courseID == -1){
            int newID = repository.getAllCourses().get(repository.getAllCourses().size() - 1).getCourseID() + 1;
            courses = new Courses(newID, editCourseName.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(), editCourseStatus.getText().toString(), editCIName.getText().toString(), editCIPhone.getText().toString(), editCIEmail.getText().toString());
            repository.insert(courses);
            Intent refresh=new Intent(CourseDetail.this, CourseList.class);
            startActivity(refresh);
        }
        else {
            courses = new Courses(courseID, editCourseName.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(), editCourseStatus.getText().toString(), editCIName.getText().toString(), editCIPhone.getText().toString(), editCIEmail.getText().toString());
            repository.update(courses);
            Intent refresh=new Intent(CourseDetail.this, CourseList.class);
            startActivity(refresh);
        }

    }


    private void updateLabelStart() {
        editStartDate.setText(sdf.format(myCalendarStart.getTime()));
    }
    private void updateLabelEnd() {

        editEndDate.setText(sdf.format(myCalendarEnd.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.course_detail, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.addNotes:
                Intent note=new Intent(CourseDetail.this, NoteDetail.class);
                startActivity(note);
                return true;

            case R.id.addAssessment:
                Intent assessment=new Intent(CourseDetail.this, AssessmentDetail.class);
                startActivity(assessment);
                return true;


            case R.id.notifyStart:
                String startDateFromScreen = editStartDate.getText().toString();
                Date myStartDate = null;
                try {
                    myStartDate = sdf.parse(startDateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long startTrigger = myStartDate.getTime();
                Intent intent1 = new Intent(CourseDetail.this, MyReceiver.class);
                intent1.putExtra("key", "The start date of Course " + getIntent().getStringExtra("name") + " is " + getIntent().getStringExtra("startDate"));
                PendingIntent startSender = PendingIntent.getBroadcast(CourseDetail.this, MainActivity.numAlert++, intent1, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager1.set(AlarmManager.RTC_WAKEUP, startTrigger, startSender);
                return true;

            case R.id.notifyEnd:
                String endDateFromScreen = editEndDate.getText().toString();
                Date myEndDate = null;
                try {
                    myEndDate = sdf.parse(endDateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger = myEndDate.getTime();
                Intent intent = new Intent(CourseDetail.this, MyReceiver.class);
                intent.putExtra("key", "The end date of Course " + getIntent().getStringExtra("name") + " is " + getIntent().getStringExtra("endDate"));
                PendingIntent sender = PendingIntent.getBroadcast(CourseDetail.this, MainActivity.numAlert++, intent, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);

                return true;

            case R.id.delete:
                for (Courses a : repository.getAllCourses()) {
                    if (a.getCourseID() == courseID) currentCourse = a;
                }
                int numAssessments = 0;
                for(Assessments assessments : repository.getAllAssessments()){
                    if(assessments.getAssessmentID() == courseID) ++numAssessments;
                }

                if(numAssessments == 0){
                    repository.delete(currentCourse);
                    Toast.makeText(CourseDetail.this, currentCourse.getCourseName() + " was deleted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CourseDetail.this, "Can't delete Courses with Assessments", Toast.LENGTH_LONG).show();
                }
        }
                return super.onOptionsItemSelected(item);
        }




}

