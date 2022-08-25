package android.christopherapp.c196projecthicks.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class AssessmentDetail extends AppCompatActivity {

    Assessments currentAssessment;

    EditText editAssessmentName;
    EditText editStartDate1;
    EditText editEndDate1;
    RadioGroup editAssessmentGroup;
    RadioButton performance;
    RadioButton objective;
    EditText editCourseName;

    int assessmentID;
    String assessmentName;
    String assessmentType;
    String startDate;
    String endDate;
    String courseName;

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
        setContentView(R.layout.activity_assessment_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editAssessmentName = findViewById(R.id.editAssessmentName);
        editStartDate1 = findViewById(R.id.editStartDate1);
        editEndDate1 = findViewById(R.id.editEndDate1);
        performance = findViewById(R.id.performance);
        objective = findViewById(R.id.objective);
        editCourseName = findViewById(R.id.editCourseName);

        editAssessmentGroup = findViewById(R.id.editAssessmentGroup);

        assessmentID = getIntent().getIntExtra("assessmentID", -1);

        assessmentName = getIntent().getStringExtra("assessmentName");
        editAssessmentName.setText(assessmentName);

        assessmentType = getIntent().getStringExtra("assessmentType");

        if (Objects.equals(assessmentType, "Performance")) {
            try {
                performance.setChecked(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (Objects.equals(assessmentType, "Objective")) {
            try {
                objective.setChecked(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
                editAssessmentGroup.clearCheck();
        }

        startDate=getIntent().getStringExtra("startDate");
        editStartDate1.setText(startDate);

        endDate=getIntent().getStringExtra("endDate");
        editEndDate1.setText(endDate);

        courseName = getIntent().getStringExtra("courseName");
        editCourseName.setText(courseName);

        repository = new Repository(getApplication());

        editStartDate1=findViewById(R.id.editStartDate1);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editStartDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editStartDate1.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetail.this, startDates, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editEndDate1=findViewById(R.id.editEndDate1);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editEndDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editEndDate1.getText().toString();
                if(info.equals(""))info="08/18/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetail.this, endDates, myCalendarEnd.get(Calendar.YEAR),
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
    }

    public void onRadioButtonClicked(View view){

        Assessments assessments;

        String assessmentType="";
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.performance:
                if(checked)
                    assessmentType="Performance";
                break;
            case R.id.objective:
                if(checked)
                    assessmentType="Objective";
                break;
        }
        assessments = new Assessments(assessmentID, assessmentName, assessmentType, startDate, endDate, courseName);
        repository.update(assessments);
    }


    public void saveButton2(View view) {

        if(assessmentID == -1) {
            int newID = repository.getAllAssessments().get(repository.getAllAssessments().size() - 1).getAssessmentID() + 1;


                if (performance.isChecked()) {
                    Assessments assessments = new Assessments(newID, editAssessmentName.getText().toString(), "Performance", editStartDate1.getText().toString(), editEndDate1.getText().toString(), editCourseName.getText().toString());
                    repository.insert(assessments);
                } else {
                    Assessments assessments = new Assessments(newID, editAssessmentName.getText().toString(), "Objective", editStartDate1.getText().toString(), editEndDate1.getText().toString(), editCourseName.getText().toString());
                    repository.insert(assessments);
                }
        }

        else{
            if (performance.isChecked()) {
                Assessments assessments = new Assessments(assessmentID, editAssessmentName.getText().toString(), "Performance", editStartDate1.getText().toString(), editEndDate1.getText().toString(), editCourseName.getText().toString());
                repository.update(assessments);
            } else {
                Assessments assessments = new Assessments(assessmentID, editAssessmentName.getText().toString(), "Objective", editStartDate1.getText().toString(), editEndDate1.getText().toString(), editCourseName.getText().toString());
                repository.update(assessments);
            }
        }
    }


    private void updateLabelStart() {
        editStartDate1.setText(sdf.format(myCalendarStart.getTime()));
    }
    private void updateLabelEnd() {

        editEndDate1.setText(sdf.format(myCalendarEnd.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.assessment_detail, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem courses) {
        switch (courses.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.notifyStart:
                String startDateFromScreen=editStartDate1.getText().toString();
                Date myStartDate=null;
                try{
                    myStartDate=sdf.parse(startDateFromScreen);
                } catch (
                        ParseException e) {
                    e.printStackTrace();
                }
                Long startTrigger=myStartDate.getTime();
                Intent intent1=new Intent(AssessmentDetail.this,MyReceiver.class);
                intent1.putExtra("key","The start date of Assessment " + getIntent().getStringExtra("assessmentName") + " is " + getIntent().getStringExtra("startDate"));
                PendingIntent startSender=PendingIntent.getBroadcast(AssessmentDetail.this,MainActivity.numAlert++,intent1,PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager1=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager1.set(AlarmManager.RTC_WAKEUP,startTrigger,startSender);
                return true;

            case R.id.notifyEnd:
                String endDateFromScreen=editEndDate1.getText().toString();
                Date myEndDate=null;
                try{
                    myEndDate=sdf.parse(endDateFromScreen);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger=myEndDate.getTime();
                Intent intent=new Intent(AssessmentDetail.this,MyReceiver.class);
                intent.putExtra("key","The end date of Assessment " + getIntent().getStringExtra("assessmentName") + " is " + getIntent().getStringExtra("endDate"));
                PendingIntent sender=PendingIntent.getBroadcast(AssessmentDetail.this,MainActivity.numAlert++,intent,PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger,sender);

                return true;

            case R.id.delete:
                for (Assessments n : repository.getAllAssessments()) {
                    if (n.getAssessmentID() == assessmentID) currentAssessment = n;
                }
                repository.delete(currentAssessment);
                Toast.makeText(AssessmentDetail.this, currentAssessment.getAssessmentName() + " was deleted", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(courses);
    }




}
