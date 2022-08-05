package android.christopherapp.c196projecthicks.Database;


import android.christopherapp.c196projecthicks.DAO.TermDAO;
import android.christopherapp.c196projecthicks.Entity.Assessments;
import android.christopherapp.c196projecthicks.Entity.Courses;
import android.christopherapp.c196projecthicks.DAO.CoursesDAO;
import android.christopherapp.c196projecthicks.DAO.AssessmentsDAO;
import android.christopherapp.c196projecthicks.Entity.Term;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Term.class, Courses.class, Assessments.class}, version = 5, exportSchema = false)
public abstract class TermCourses extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CoursesDAO coursesDAO();
    public abstract AssessmentsDAO assessmentsDAO();

    private static volatile TermCourses INSTANCE;

    static TermCourses getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized (TermCourses.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TermCourses.class, "myTermCoursesDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
