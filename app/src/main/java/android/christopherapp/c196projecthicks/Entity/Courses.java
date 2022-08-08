package android.christopherapp.c196projecthicks.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Courses {
    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private String courseName;
    private String startDate;
    private String endDate;
    private String courseStatus;
    private String ciName;
    private String ciPhone;
    private String ciEmail;

    public Courses(int courseID, String courseName, String startDate, String endDate, String courseStatus, String ciName, String ciPhone, String ciEmail) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public String getCiPhone() {
        return ciPhone;
    }

    public void setCiPhone(String ciPhone) {
        this.ciPhone = ciPhone;
    }

    public String getCiEmail() {
        return ciEmail;
    }

    public void setCiEmail(String ciEmail) {
        this.ciEmail = ciEmail;
    }


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
