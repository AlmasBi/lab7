package com.example.tt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    APIService apiService;
    List<Job> jobs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = MyApplication.getInstance().getRetrofit();
        apiService = MyApplication.getInstance().getService();
        jobs = new ArrayList<>();
        jobsFragment(getAllJobs());
        Button jobFragment = findViewById(R.id.job_fragment_button);
        jobFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               jobsFragment(getAllJobs());
            }
        });
        Button likedFragment = findViewById(R.id.liked_fragment_button);
        likedFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LikedFragment();
            }
        });
        Button searchFragment = findViewById(R.id.search);
        searchFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFragment();
            }
        });
    }



    public void jobsFragment(List<Job> jobs1) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new JobsFragment(jobs1)).commitAllowingStateLoss();
    }

    public void detailFragment(Job jobSS) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new DetailsFragment(jobSS)).commitAllowingStateLoss();
    }
    public void LikedFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new LikedFragment()).commitAllowingStateLoss();
    }
    public void SearchFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new SearchFragment()).commitAllowingStateLoss();
    }
    public void SSearchFragment(List<Job> ll) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new SSearchFragment(ll)).commitAllowingStateLoss();
    }
    public void setJobs(List<Job> jobs){
        this.jobs = jobs;
    }


    public List<Job> getAllJobs() {
        apiService.getJobs().enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                setJobs(response.body());
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
            }
        });



        return this.jobs;
    }

    public List<Job> getAllJobsByTitle(String title){
        apiService.getJobsByUserTitle(title).enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                setJobs(response.body());
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        return this.jobs;
    }
}
