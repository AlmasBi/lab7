package com.example.tt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LikedFragment extends Fragment implements ExapleAdapter.onBtnClick{
    private ArrayList<ExampleItem> exampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    AppDatabase db;

List<Job> job;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.liked_jobs, container, false);
        exampleList = new ArrayList<>();
        List<Jobs> jobs=db.JobsDao().getContact();
        String id;
        String type;
        String url;
        String createdAt;
        String company;
        String comppanyUrl;
        String location;
        String title;
        String description;
        String image;
        for(Jobs contact:jobs){


           title= contact.title;

            image=contact.companyLogo;
            exampleList.add(new ExampleItem(title,image));
        }

        mRecyclerView = v.findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExapleAdapter(exampleList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return v;}

    @Override
    public void onClick(int position) {
        Log.e("onTouch", "so its touched");
        ((MainActivity)getActivity()).detailFragment(job.get(position));
    }
}
