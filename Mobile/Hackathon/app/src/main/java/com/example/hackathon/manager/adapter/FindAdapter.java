package com.example.hackathon.manager.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.manager.holder.FindViewHolder;
import com.example.hackathon.model.Write;

import java.util.List;

public class FindAdapter extends RecyclerView.Adapter<FindViewHolder> {

    List<Write> list;

    public FindAdapter(List<Write> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public FindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FindViewHolder holder, int position) {
        Write write = list.get(position);

        holder.binding.like.setText("추천 " + write.getLike() + "개");
        holder.binding.textView.setText(write.getContents());
        holder.binding.writer.setText(write.getWriter());

//        holder.binding.like.setOnClickListener(v -> );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
