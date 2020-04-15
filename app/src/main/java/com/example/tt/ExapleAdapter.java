package com.example.tt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExapleAdapter extends RecyclerView.Adapter <ExapleAdapter.ExampleViewHolder>{
    private ArrayList<ExampleItem> mExampleList;
    private onBtnClick onbc;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public ImageView url;


        public onBtnClick onbc;
        public ExampleViewHolder(View itemView, onBtnClick onbc) {
            super(itemView);
            title = itemView.findViewById(R.id.title2);
            url = itemView.findViewById(R.id.image2);
            this.onbc = onbc;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onbc.onClick(getAdapterPosition());
        }
    }
    public ExapleAdapter(ArrayList<ExampleItem> exampleList, onBtnClick onbc) {
        mExampleList = exampleList;
        this.onbc = onbc;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, onbc);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.title.setText(currentItem.getTitle());
        Picasso.get()
                .load(currentItem.getUrl())
                .into(holder.url);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    interface onBtnClick{
        void onClick(int position);
    }
}
