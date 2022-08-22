package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Entity.Notes;
import android.christopherapp.c196projecthicks.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder> {
    class NotesViewHolder extends RecyclerView.ViewHolder{
        private final TextView notesItemView;
        private NotesViewHolder(View itemView){
            super(itemView);
            notesItemView=itemView.findViewById(R.id.textView5);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    final Notes current=mNotes.get(position);
                    Intent intent=new Intent(context, NoteDetail.class);
                    intent.putExtra("noteId",current.getNoteId());
                    intent.putExtra("title",current.getTitle());
                    intent.putExtra("contents",current.getContents());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Notes> mNotes;
    private final Context context;
    private final LayoutInflater mInflater;

    public NoteAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public NoteAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.note_list_item,parent, false);
        return new NoteAdapter.NotesViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NotesViewHolder holder, int position) {
        if(mNotes!=null){
            Notes current=mNotes.get(position);
            String title=current.getTitle();
            holder.notesItemView.setText(title);
        }
        else{
            holder.notesItemView.setText("No Note Title");
        }
    }

    public void setNotes(List<Notes> notes){
        mNotes=notes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mNotes != null) {
            return mNotes.size();
        }
        else return 0;
    }
}
