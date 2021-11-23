package org.jeonfeel.room_viewmodel;

import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = UserProfile.class,version = 1)
public abstract class UserProfileDatabase extends RoomDatabase {

    public abstract UserProfileDao getUserProfileDao();

}
