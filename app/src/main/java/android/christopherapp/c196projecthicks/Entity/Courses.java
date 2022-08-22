package android.christopherapp.c196projecthicks.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "courses")
public class Courses {
    @NonNull
    @ColumnInfo(name = "courseID")
    @PrimaryKey(autoGenerate = true)
    private int courseID;

    @NonNull
    @ColumnInfo(name = "courseName")
    private String courseName;

    @NonNull
    @ColumnInfo(name = "startDate")
    private String startDate;

    @NonNull
    @ColumnInfo(name = "endDate")
    private String endDate;

    @NonNull
    @ColumnInfo(name = "courseStatus")
    private String courseStatus;

    @NonNull
    @ColumnInfo(name = "ciName")
    private String ciName;

    @NonNull
    @ColumnInfo(name = "ciPhone")
    private String ciPhone;

    @NonNull
    @ColumnInfo(name = "ciEmail")
    private String ciEmail;



    public Courses(@NonNull int courseID, @NonNull String courseName, @NonNull String startDate, @NonNull String endDate, @NonNull String courseStatus, @NonNull String ciName, @NonNull String ciPhone, @NonNull String ciEmail) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseStatus = courseStatus;
        this.ciName = ciName;
        this.ciPhone = ciPhone;
        this.ciEmail = ciEmail;

    }


    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @NonNull
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @NonNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @NonNull
    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    @NonNull
    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    @NonNull
    public String getCiPhone() {
        return ciPhone;
    }

    public void setCiPhone(String ciPhone) {
        this.ciPhone = ciPhone;
    }

    @NonNull
    public String getCiEmail() {
        return ciEmail;
    }

    public void setCiEmail(String ciEmail) {
        this.ciEmail = ciEmail;
    }



    @NonNull
    @Override
    public String toString() {
        return "Courses{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", courseStatus='" + courseStatus + '\'' +
                ", ciName='" + ciName + '\'' +
                ", ciPhone='" + ciPhone + '\'' +
                ", ciEmail='" + ciEmail + '\'' +
                '}';
    }
}
