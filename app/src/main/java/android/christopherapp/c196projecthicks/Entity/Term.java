package android.christopherapp.c196projecthicks.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "terms")
public class Term {

    @NonNull
    @ColumnInfo(name = "termID")
    @PrimaryKey(autoGenerate = true)
    private int termID;

    @NonNull
    @ColumnInfo(name = "termName")
    private String termName;

    @NonNull
    @ColumnInfo(name = "termStart")
    private String termStart;

    @NonNull
    @ColumnInfo(name = "termEnd")
    private String termEnd;



    public Term(@NonNull int termID, @NonNull String termName, @NonNull String termStart, @NonNull String termEnd) {
        this.termID = termID;
        this.termName = termName;
        this.termStart = termStart;
        this.termEnd = termEnd;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    @NonNull
    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @NonNull
    public String getTermStart() {
        return termStart;
    }

    public void setTermStart(String termStart) {
        this.termStart = termStart;
    }

    @NonNull
    public String getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(String termEnd) {
        this.termEnd = termEnd;
    }

    @NonNull
    @Override
    public String toString() {
        return "Term{" +
                "termID=" + termID +
                ", termName='" + termName + '\'' +
                ", termStart='" + termStart + '\'' +
                ", termEnd='" + termEnd + '\'' +
                '}';
    }
}
