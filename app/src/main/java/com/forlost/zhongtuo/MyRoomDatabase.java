package com.forlost.zhongtuo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.forlost.zhongtuo.helper.ApplicationHelper;
import com.forlost.zhongtuo.room.Converter;
import com.forlost.zhongtuo.room.Dialog;
import com.forlost.zhongtuo.room.DialogDao;
import com.forlost.zhongtuo.room.Message;
import com.forlost.zhongtuo.room.MessageDao;
import com.forlost.zhongtuo.room.User;
import com.forlost.zhongtuo.room.UserDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Message.class, Dialog.class}, version = 1)
@TypeConverters(Converter.class)
public abstract class MyRoomDatabase extends RoomDatabase {
    private static volatile MyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static MyRoomDatabase getDatabase() {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(ApplicationHelper.getInstance().getMyApplication().getApplicationContext(),
                            MyRoomDatabase.class, "sunflower")
//                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();
    public abstract MessageDao messageDao();
    public abstract DialogDao dialogDao();
}
