package android.christopherapp.c196projecthicks.Database;


import android.app.Application;
import android.christopherapp.c196projecthicks.DAO.AssessmentsDAO;
import android.christopherapp.c196projecthicks.DAO.CoursesDAO;
import android.christopherapp.c196projecthicks.DAO.NotesDAO;
import android.christopherapp.c196projecthicks.DAO.TermDAO;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.Entity.Term;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private CoursesDAO mCoursesDAO;
    private AssessmentsDAO mAssessmentsDAO;
    private TermDAO mTermDAO;
    private NotesDAO mNotesDAO;

    private List<Term> mAllTerms;
    private List<Assessments> mAllAssessments;
    private List<Courses> mAllCourses;
    private List<Notes> mAllNotes;


    private static int NUMBER_OF_THREADS=5;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public Repository(Application application){
        TermCourses db= TermCourses.getDatabase(application);
        mTermDAO=db.termDAO();
        mAssessmentsDAO = db.assessmentsDAO();
        mCoursesDAO = db.coursesDAO();
        mNotesDAO = db.notesDAO();
    }


    public List<Notes> getAllNotes(){
        databaseExecutor.execute(()->{
            mAllNotes=mNotesDAO.getAllNotes();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllNotes;
    }
    public void insert(Notes notes){
        databaseExecutor.execute(()->{
            mNotesDAO.insert(notes);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void update(Notes notes){
        databaseExecutor.execute(()->{
            mNotesDAO.update(notes);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Notes notes){
        databaseExecutor.execute(()->{
            mNotesDAO.delete(notes);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    public List<Courses> getAllCourses(){
        databaseExecutor.execute(()->{
            mAllCourses=mCoursesDAO.getAllCourses();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }
    public void insert(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesDAO.insert(courses);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void update(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesDAO.update(courses);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Courses courses){
        databaseExecutor.execute(()->{
            mCoursesDAO.delete(courses);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    public List<Term> getAllTerms(){
        databaseExecutor.execute(()->{
            mAllTerms=mTermDAO.getAllTerms();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllTerms;
    }
    public void insert(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.insert(term);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void update(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.update(term);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.delete(term);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    public List<Assessments> getAllAssessments(){
        databaseExecutor.execute(()->{
            mAllAssessments=mAssessmentsDAO.getAllAssessments();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public void insert(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsDAO.insert(assessments);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void update(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsDAO.update(assessments);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Assessments assessments){
        databaseExecutor.execute(()->{
            mAssessmentsDAO.delete(assessments);

        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
