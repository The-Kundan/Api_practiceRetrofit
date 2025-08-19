package com.example.api_practiceretrofit.fetchingDataGet;

import com.google.gson.annotations.SerializedName;

public class comment {
    private String postId , id, name , email;
    @SerializedName("body")
    private String commentText;

    public String getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCommentText() {
        return commentText;
    }
}
