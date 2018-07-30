package com.mostafa.root.retrofittesting.Adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mostafa.root.retrofittesting.Model.ReviewObj;
import com.mostafa.root.retrofittesting.R;
import java.util.List;

public class ReviewAdapter  extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private List<ReviewObj> reviewObjList;
    private Context context;
    public ReviewAdapter(List<ReviewObj> reviewObjList , Context context){
        this.reviewObjList = reviewObjList;
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView author_name;
        public TextView review_content;
        public ViewHolder(View itemView) {
            super(itemView);
            author_name =  itemView.findViewById(R.id.author_name);
            review_content = itemView.findViewById(R.id.review_content);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.single_review_design , parent ,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.author_name.setText(reviewObjList.get(position).getAuthor());
        holder.review_content.setText(reviewObjList.get(position).getContent());
    }
    @Override
    public int getItemCount() {
        return reviewObjList.size();
    }
}
