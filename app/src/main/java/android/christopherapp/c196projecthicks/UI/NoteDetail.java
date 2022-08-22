package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Database.Repository;
import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetail extends AppCompatActivity {

    Notes currentNote;

    EditText editNoteTitle;
    EditText editNoteContent;

    int noteId;
    String title;
    String contents;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editNoteTitle = findViewById(R.id.editNoteTitle);
        editNoteContent = findViewById(R.id.editNoteContent);

        noteId = getIntent().getIntExtra("noteId", -1);


        title = getIntent().getStringExtra("title");
        editNoteTitle.setText(title);

        contents = getIntent().getStringExtra("contents");
        editNoteContent.setText(contents);


        repository = new Repository(getApplication());
    }

    public void saveButton(View view) {
        Notes notes;
        if(noteId == -1){
            int newID = repository.getAllNotes().get(repository.getAllNotes().size() - 1).getNoteId() + 1;
            notes = new Notes(newID, editNoteTitle.getText().toString(), editNoteContent.getText().toString());
            repository.insert(notes);
        }
        else {
            notes = new Notes(noteId, editNoteTitle.getText().toString(), editNoteContent.getText().toString());
            repository.update(notes);
        }

    }


    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present

        getMenuInflater().inflate(R.menu.course_detail, menu);
        return true;
    }
}
