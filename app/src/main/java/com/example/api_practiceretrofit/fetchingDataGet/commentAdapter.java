package com.example.api_practiceretrofit.fetchingDataGet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_practiceretrofit.R;

import java.util.List;

public class commentAdapter extends RecyclerView.Adapter<commentAdapter.commentHolder> {


    Context context;
    List<comment> commentList;

    public commentAdapter(Context context , List<comment> commentList){
        this.context =context;
        this.commentList = commentList;
    }
    @NonNull
    @Override
    public commentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment , parent , false);
        return new commentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull commentHolder holder, int position) {

        comment comment = commentList.get(position);
        holder.postId.setText("Post Id : " + comment.getPostId());
        holder.id.setText("Comment Id : " + comment.getId());
        holder.commentText.setText("Comment : " + comment.getCommentText());
        holder.name.setText("Name : " + comment.getName());
        holder.email.setText("Email : " + comment.getEmail());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class commentHolder extends RecyclerView.ViewHolder{

        TextView postId , id, email , name , commentText;

        public commentHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.post_id);
            id = itemView.findViewById(R.id.comment_id);
            email = itemView.findViewById(R.id.comment_email);
            name = itemView.findViewById(R.id.user_name);
            commentText = itemView.findViewById(R.id.comment_text);

        }
    }
}