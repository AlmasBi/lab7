package com.example.tt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
public interface APIService {
    @GET("positions.json/")
    Call<List<Job>> getJobs();


    @GET("positions.json/{id}/")
    Call<Job> getJobById(@Path("id") int todoId);


    @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})
    @GET("positions.json/")
    Call<List<Job>> getJobsByUserTitle(@Query("title") String title);


    @FormUrlEncoded
    @POST("positions.json/")
    Call<Job> addJob(@Field("userId") int userId,
                     @Field("title") String title,
                     @Field("completed") boolean completed);



    @GET
    Call<List<Job>> getJobsFromUrl(@Url String url);
}
