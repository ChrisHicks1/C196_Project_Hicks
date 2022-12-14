package android.christopherapp.c196projecthicks.UI;

import android.christopherapp.c196projecthicks.Entity.Assessments;
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

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {
    class AssessmentViewHolder extends RecyclerView.ViewHolder{
        private final TextView assessmentItemView;
        private AssessmentViewHolder(View itemView){
            super(itemView);
            assessmentItemView=itemView.findViewById(R.id.textView7);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    final Assessments current=mAssessments.get(position);
                    Intent intent=new Intent(context, AssessmentDetail.class);
                    intent.putExtra("assessmentID",current.getAssessmentID());
                    intent.putExtra("assessmentName",current.getAssessmentName());
                    intent.putExtra("assessmentType",current.getAssessmentType());
                    intent.putExtra("startDate",current.getStartDate());
                    intent.putExtra("endDate",current.getEndDate());
                    intent.putExtra("courseName", current.getCourseName());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Assessments> mAssessments;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssessmentAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }


    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.assessment_list_item,parent, false);
        return new AssessmentAdapter.AssessmentViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
        if(mAssessments!=null){
            Assessments current=mAssessments.get(position);
            String assessmentName=current.getAssessmentName();
            holder.assessmentItemView.setText(assessmentName);
        }
        else{
            holder.assessmentItemView.setText("No Assessment Name");
        }
    }

    public void setAssessments(List<Assessments> assessments){
        mAssessments=assessments;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mAssessments != null) {
            return mAssessments.size();
        }
        else return 0;
    }
}

