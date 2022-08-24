package android.christopherapp.c196projecthicks.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessments")
public class Assessments {

    @NonNull
    @ColumnInfo(name = "assessmentID")
    @PrimaryKey(autoGenerate = true)
    private int assessmentID;

    @NonNull
    @ColumnInfo(name = "assessmentName")
    private String assessmentName;

    @NonNull
    @ColumnInfo(name = "assessmentType")
    private String assessmentType;

    @NonNull
    @ColumnInfo(name = "startDate")
    private String startDate;

    @NonNull
    @ColumnInfo(name = "endDate")
    private String endDate;

    @NonNull
    @ColumnInfo(name = "courseID")
    private int courseID;

    public Assessments(@NonNull int assessmentID, @NonNull String assessmentName, @NonNull String assessmentType, @NonNull String startDate, @NonNull String endDate, @NonNull int courseID) {
        this.assessmentID = assessmentID;
        this.assessmentName = assessmentName;
        this.assessmentType = assessmentType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseID = courseID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    @NonNull
    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(@NonNull String assessmentName) {
        this.assessmentName = assessmentName;
    }

    @NonNull
    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(@NonNull String assessmentType) {
        this.assessmentType = assessmentType;
    }

    @NonNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull String startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NonNull String endDate) {
        this.endDate = endDate;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @NonNull
    @Override
    public String toString() {
        return "Assessments{" +
                "assessmentID=" + assessmentID +
                ", assessmentName='" + assessmentName + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", courseID=" + courseID +
                '}';
    }
}
