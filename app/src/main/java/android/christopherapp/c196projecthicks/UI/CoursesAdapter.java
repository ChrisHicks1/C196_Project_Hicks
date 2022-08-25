package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Entity.Courses;
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

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder> {
    class CoursesViewHolder extends RecyclerView.ViewHolder{
        private final TextView coursesItemView;
        private CoursesViewHolder(View itemView){
            super(itemView);
            coursesItemView=itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    final Courses current=mCourses.get(position);
                    Intent intent=new Intent(context, CourseDetail.class);
                    intent.putExtra("courseID",current.getCourseID());
                    intent.putExtra("courseName",current.getCourseName());
                    intent.putExtra("startDate",current.getStartDate());
                    intent.putExtra("endDate",current.getEndDate());
                    intent.putExtra("status",current.getCourseStatus());
                    intent.putExtra("ciName",current.getCiName());
                    intent.putExtra("ciEmail",current.getCiEmail());
                    intent.putExtra("ciPhone",current.getCiPhone());
                    intent.putExtra("termName", current.getTermName());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Courses> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;

    public CoursesAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }

    @NonNull
    @Override
    public CoursesAdapter.CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.courses_list_item,parent, false);
        return new CoursesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.CoursesViewHolder holder, int position) {
        if(mCourses!=null){
            Courses current=mCourses.get(position);
            String courseName=current.getCourseName();
            holder.coursesItemView.setText(courseName);
        }
        else{
            holder.coursesItemView.setText("No Course Name");
        }
    }

    public void setCourses(List<Courses> courses){
        mCourses=courses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCourses != null) {
            return mCourses.size();
        }
        else return 0;
    }
}
