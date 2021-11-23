package org.jeonfeel.room_viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import org.jeonfeel.room_viewmodel.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private UserProfileViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(UserProfileViewModel.class);

        model.userProfileList.observe(this, new Observer<List<UserProfile>>() {
            @Override
            public void onChanged(List<UserProfile> userProfiles) {
                updateUserProfileList(userProfiles);
            }
        });

        binding.btnAdd.setOnClickListener(this);
    }

    private void updateUserProfileList(List<UserProfile> userProfiles){

        String userListText = "사용자 목록";
        for ( UserProfile userProfile : userProfiles){
            userListText += "\n" + userProfile.id + ", " + userProfile.name + ", "+ userProfile.phone + ", "+ userProfile.address;
        }
        binding.tvUserText.setText(userListText);
    }

    @Override
    public void onClick(View view) {

        UserProfile userProfile = new UserProfile();

        userProfile.name = binding.etName.getText().toString();
        userProfile.phone = binding.etPhone.getText().toString();
        userProfile.address = binding.etAddress.getText().toString();

        model.userProfileDao.insert(userProfile);

    }
}