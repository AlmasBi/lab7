package com.example.tt;

import android.app.Application;

import androidx.room.Room;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    public  static MyApplication instance;
  private   Retrofit retrofit;
     private APIService service;
    private AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
     retrofit = new Retrofit.Builder()
            .baseUrl(" https://jobs.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

     service = retrofit.create(APIService.class);
        database= Room.databaseBuilder(this,AppDatabase.class,"job_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
}
    public static MyApplication getInstance(){
        return instance;
    }
    public  Retrofit getRetrofit(){
        return retrofit;
    }
    public  APIService getService(){
        return service;
    }
    public AppDatabase getDatabase(){
        return database;
    }

}
