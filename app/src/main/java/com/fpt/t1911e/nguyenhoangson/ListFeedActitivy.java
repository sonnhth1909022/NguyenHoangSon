package com.fpt.t1911e.nguyenhoangson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fpt.t1911e.nguyenhoangson.database.AppDatabase;
import com.fpt.t1911e.nguyenhoangson.database.FeedbackEntity;

import java.util.List;

public class ListFeedActitivy extends AppCompatActivity {
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_feed_actitivy);

        db = AppDatabase.getAppDatabase(this);
        getAllFeedback();
    }

    private void getAllFeedback(){
        RecyclerView recyclerView;
        List<FeedbackEntity> listFeedback = db.feedbackDao().getAllFeedback();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        FeedbackAdapter feedAdapter = new FeedbackAdapter(this, listFeedback);

        recyclerView = findViewById(R.id.rvList);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}