package com.example.api_practiceretrofit.fetchingDataGet;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface jsonPlaceHolder {
    @GET("posts")
    Call<List<post>> getPost();


    // get Comment without id
    @GET("posts/1/comments")
    Call<List<comment>> getComment();


    // get Comment with id
//    @GET("posts/{id}/comments")
//    Call<List<comment>> getComment(@Path("id") int id);

    // get comment using Query
//    @GET("comments")
//    Call<List<comment>> getComment(@Query("id") int id);


    @POST("posts")
    Call<post> createPost(@Body post post);

    @FormUrlEncoded
    @POST("posts")
    Call<post> createPost(
            @Field("userId") String userId,
            @Field("title") String title,
            @Field("body") String text
    );


    @PUT("posts/{id}")
    Call<post> putPost(@Path("id") int id , @Body post post);

    @PATCH("posts/{id}")
    Call<post> patchPost(@Path("id") int id , @Body post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
