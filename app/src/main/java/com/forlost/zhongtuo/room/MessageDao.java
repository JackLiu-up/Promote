package com.forlost.zhongtuo.room;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MessageDao {
    @Query("SELECT * FROM message WHERE id = :id LIMIT 1")
    Message findById(long id);

    @Query("SELECT * from message WHERE dialog_type=:dialog_type AND dialog_id=:dialog_id ORDER BY id DESC")
    DataSource.Factory<Integer, Message> getOneDialogMessages(int dialog_type, long dialog_id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Message message);
}
