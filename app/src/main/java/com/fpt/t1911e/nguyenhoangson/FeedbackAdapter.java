package com.fpt.t1911e.nguyenhoangson;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fpt.t1911e.nguyenhoangson.database.FeedbackEntity;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<FeedbackEntity> listFeedback;

    public FeedbackAdapter(Activity activity, List<FeedbackEntity> listFeedback) {
        this.activity = activity;
        this.listFeedback = listFeedback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_feedback,parent,false);
        FeedHolder holder = new FeedHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FeedHolder fh = (FeedHolder) holder;
        FeedbackEntity model = listFeedback.get(position);
        fh.tvId.setText(Integer.toString(model.getId()));
        fh.tvName.setText(model.getName());
        fh.tvEmail.setText(model.getEmail());
        fh.tvSelect.setText(model.getSelection());
    }

    @Override
    public int getItemCount() {
        return listFeedback.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvEmail;
        TextView tvSelect;

        public FeedHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvSelect = itemView.findViewById(R.id.tvSelect);
        }
    }
}
