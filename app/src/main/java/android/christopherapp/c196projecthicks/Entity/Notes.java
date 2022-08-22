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




    public Notes(@NonNull int noteId, @NonNull String title, @NonNull String contents){
        this.noteId = noteId;
        this.title = title;
        this.contents = contents;
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
    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", contents='" + contents +
                '}';
    }
}
