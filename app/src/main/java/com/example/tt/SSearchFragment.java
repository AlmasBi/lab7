package com.example.tt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SSearchFragment extends Fragment implements JobsAdapter.OnTouchItem{
    RecyclerView recyclerView;
    JobsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Job> jobs;

    public SSearchFragment(List<Job> ll) {
        this.jobs = ll;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ss, container, false);
        recyclerView = v.findViewById(R.id.recyclerView2);
        adapter = new JobsAdapter(jobs, this);
        layoutManager = new LinearLayoutManager((MainActivity)getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    @Override
    public void onTouch(int position) {
        Log.e("onTouch", "so its touched");
        ((MainActivity)getActivity()).detailFragment(jobs.get(position));
    }
}