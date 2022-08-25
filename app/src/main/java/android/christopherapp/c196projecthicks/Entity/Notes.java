package android.christopherapp.c196projecthicks.Entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes {

    @NonNull
    @ColumnInfo(name = "noteId")
    @PrimaryKey(autoGenerate = true)
    private int noteId;

    @NonNull
    @ColumnInfo(name = "Title")
    private String title;

    @NonNull
    @ColumnInfo(name = "contents")
    private String contents;

    @NonNull
    @ColumnInfo(name = "courseName")
    private String courseName;



    public Notes(@NonNull int noteId, @NonNull String title, @NonNull String contents, @NonNull String courseName){
        this.noteId = noteId;
        this.title = title;
        this.contents = contents;
        this.courseName = courseName;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getContents() {
        return contents;
    }

    public void setContents(@NonNull String contents) {
        this.contents = contents;
    }

    @NonNull
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NonNull String courseName) {
        this.courseName = courseName;
    }

    @NonNull
    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", courseName=" + courseName +
                '}';
    }
}
