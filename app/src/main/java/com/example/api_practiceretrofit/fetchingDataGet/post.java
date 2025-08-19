package com.example.api_practiceretrofit.fetchingDataGet;

public class post {
    private String userId , id , title , body;

    public post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
