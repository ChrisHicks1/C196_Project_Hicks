package android.christopherapp.c196projecthicks.Database;


import android.christopherapp.c196projecthicks.DAO.NotesDAO;
import android.christopherapp.c196projecthicks.DAO.TermDAO;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.DAO.CoursesDAO;
import android.christopherapp.c196projecthicks.DAO.AssessmentsDAO;
import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Term.class, Courses.class, Assessments.class, Notes.class}, version = 16, exportSchema = false)
public abstract class SchedulerDatabase extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CoursesDAO coursesDAO();
    public abstract AssessmentsDAO assessmentsDAO();
    public abstract NotesDAO notesDAO();

    private static volatile SchedulerDatabase INSTANCE;

    static SchedulerDatabase getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized (SchedulerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SchedulerDatabase.class, "myTermCoursesDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
