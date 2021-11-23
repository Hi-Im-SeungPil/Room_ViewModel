package org.jeonfeel.room_viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {

    public LiveData<List<UserProfile>> userProfileList;
    public UserProfileDao userProfileDao;
//    private UserProfileDao userProfileDao;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);

        UserProfileDatabase db = Room.databaseBuilder(application,UserProfileDatabase.class,"userProfile").allowMainThreadQueries().build();
        userProfileDao = db.getUserProfileDao();
        userProfileList = db.getUserProfileDao().getAll();

    }

    public void insert(UserProfile user){
        userProfileDao.insert(user);
    }

}
