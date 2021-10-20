package com.fpt.t1911e.nguyenhoangson.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeedbackDao {
    @Insert(onConflict = REPLACE)
    void insertFeedback(FeedbackEntity feedback);

    @Query("SELECT * FROM feedback")
    List<FeedbackEntity> getAllFeedback();
}
