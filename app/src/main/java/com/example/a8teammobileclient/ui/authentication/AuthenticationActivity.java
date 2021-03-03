package com.example.a8teammobileclient.ui.authentication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.testData;
import com.example.a8teammobileclient.ui.GroupsActivity;

import java.util.List;
import java.util.ResourceBundle;

public class AuthenticationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();
/*        SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(this);
        User user = sharedPreferencesHelper.getUser();
        if(testData.users.stream()
                .anyMatch(us -> us.getLogin().equals(user.getLogin()) && us.getPassword().equals(user.getPassword()))){
            openGroupsActivity();
        }
        else{*/
            setLoginFragment();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void setLoginFragment(){
        LoginFragment loginFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, loginFragment)
                .commit();
    }

    public void setRegistrationFragment(){
        RegistrationFragment registrationFragment = RegistrationFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, registrationFragment)
                .commit();
    }

    public void openGroupsActivity(){

        Intent intent = new Intent(this, GroupsActivity.class);
        startActivity(intent);
    }
}
