package com.example.tt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
   public Job job;
    AppDatabase db;
    public DetailsFragment(Job job) {
        this.job=job;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ditail_job, container, false);
         TextView id;
         TextView type;
         TextView url;
         TextView createdAt;
         TextView company;
         TextView comppanyUrl;
         TextView location;
         TextView title;
         TextView description;
         ImageView image;
        id = v.findViewById(R.id.id);
        type = v.findViewById(R.id.type);
        url = v.findViewById(R.id.url);
        createdAt = v.findViewById(R.id.createdAt);
        company = v.findViewById(R.id.company);
        comppanyUrl = v.findViewById(R.id.companyUrl);
        location = v.findViewById(R.id.location);
        title = v.findViewById(R.id.title);
        description = v.findViewById(R.id.description);
        image = v.findViewById(R.id.image);


        id.setText(job.getId());
        type.setText(job.getType());
        url.setText(job.getUrl());
        createdAt.setText(job.getCreatedAt());
        company.setText(job.getCompany());
        comppanyUrl.setText(job.getCompanyUrl());
        location.setText(job.getLocation());
        title.setText(job.getTitle());
        description.setText(job.getDescription());
        Picasso.get()
                .load(job.getCompanyLogo())
                .into(image);
        Button btn = v.findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).jobsFragment(((MainActivity)getActivity()).getAllJobs());
            }
        });
        Button liked = v.findViewById(R.id.liked);
        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jobs jobs  = new Jobs();

                jobs.title=job.getTitle();

                jobs.companyLogo=job.getCompanyLogo();
                db.JobsDao().Insert(jobs);
                Toast.makeText(((MainActivity)getContext()), "New job added", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
}}
