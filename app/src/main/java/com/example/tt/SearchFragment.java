package com.example.tt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.List;

public class SearchFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        EditText edit = v.findViewById(R.id.edit);
        Button search = v.findViewById(R.id.iskat);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edit.getText().toString();
               List<Job> aa= ((MainActivity)getActivity()).getAllJobsByTitle(title);
                ((MainActivity)getActivity()).SSearchFragment(aa);
            }
        });
        Button nazad = v.findViewById(R.id.nazad);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).jobsFragment(((MainActivity)getActivity()).getAllJobs());
            }
        });

return v;
}}
