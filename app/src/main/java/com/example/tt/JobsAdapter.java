package com.example.tt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {
    OnTouchItem onTouchItem;
    List<Job> jobs;

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(v, onTouchItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.textView.setText(job.getTitle());
        Picasso.get()
                .load(job.getCompanyLogo())
//               .placeholder(R.drawable.place)
//                .centerCrop()
//                .resize(150, 150)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public JobsAdapter(List<Job> jobs, OnTouchItem onTouchItem){
        this.jobs = jobs;
        this.onTouchItem = onTouchItem;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        OnTouchItem onTouchItem;
        public MyViewHolder(@NonNull View itemView, OnTouchItem onTouchItem) {
            super(itemView);
            this.onTouchItem = onTouchItem;
            imageView = itemView.findViewById(R.id.image_view_logoR);
            textView = itemView.findViewById(R.id.text_titleR);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTouchItem.onTouch(getAdapterPosition());
        }
    }

    public interface OnTouchItem{
        void onTouch(int position);
    }

}

