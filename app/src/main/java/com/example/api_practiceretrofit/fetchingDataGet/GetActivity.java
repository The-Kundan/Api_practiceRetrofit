package com.example.api_practiceretrofit.fetchingDataGet;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_practiceretrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    jsonPlaceHolder jsonplaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        recyclerView = findViewById(R.id.recycerlview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonplaceholder = retrofit.create(jsonPlaceHolder.class);

//        getPost();

//       getComment();

//        createPost();

//        updatePost();

        deletePost();


    }

    private void deletePost() {
        Call<Void> call = jsonplaceholder.deletePost(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(GetActivity.this, "Post Deleted: " + response.code(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updatePost() {

        post post = new post("155" , "new title" , null);
//        Call<post> call = jsonplaceholder.putPost(2 , post);

        // patch post
        Call<post> call = jsonplaceholder.patchPost(2 , post);
        call.enqueue(new Callback<post>() {
            @Override
            public void onResponse(Call<post> call, Response<post> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<post> postList = new ArrayList<>();
                postList.add(response.body());
                postAdapter postAdapter = new postAdapter(GetActivity.this , postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<post> call, Throwable t) {
                Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void createPost() {

//        post post = new post("1" , "title" , "body");
//        Call<post> call = jsonplaceholder.createPost(post);

        // using form url encoded
        Call<post> call = jsonplaceholder.createPost("2" , "title2" , "body2");
        call.enqueue(new Callback<post>() {
            @Override
            public void onResponse(Call<post> call, Response<post> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<post> postList = new ArrayList<>();
                postList.add(response.body());
                postAdapter postAdapter = new postAdapter(GetActivity.this , postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<post> call, Throwable t) {
                Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    // get comment without id
    private void getComment() {
        Call<List<comment>> call = jsonplaceholder.getComment();
        call.enqueue(new Callback<List<comment>>() {

            @Override
            public void onResponse(Call<List<comment>> call, Response<List<comment>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<comment> commentList = response.body();
                commentAdapter commentAdapter = new commentAdapter(GetActivity.this , commentList);
                recyclerView.setAdapter(commentAdapter);

            }

            @Override
            public void onFailure(Call<List<comment>> call, Throwable t) {
                 Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // get comment with id
//    private void getComment() {
//        Call<List<comment>> call = jsonplaceholder.getComment(3);
//        call.enqueue(new Callback<List<comment>>() {
//
//            @Override
//            public void onResponse(Call<List<comment>> call, Response<List<comment>> response) {
//
//                if (!response.isSuccessful()){
//                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                List<comment> commentList = response.body();
//                commentAdapter commentAdapter = new commentAdapter(GetActivity.this , commentList);
//                recyclerView.setAdapter(commentAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<comment>> call, Throwable t) {
//                Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    private void getPost() {
        Call<List<post>> call = jsonplaceholder.getPost();
        call.enqueue(new Callback<List<post>>() {
            @Override
            public void onResponse(Call<List<post>> call, Response<List<post>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(GetActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<post> postList = response.body();
                postAdapter postadapter = new postAdapter(GetActivity.this , postList);
                recyclerView.setAdapter(postadapter);

            }

            @Override
            public void onFailure(Call<List<post>> call, Throwable t) {
                Toast.makeText(GetActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}