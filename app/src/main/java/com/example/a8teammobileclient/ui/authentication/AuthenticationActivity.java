package com.example.a8teammobileclient.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a8teammobileclient.R;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setLoginFragment();
    }

    public void setLoginFragment(){
        LoginFragment loginFragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, loginFragment)
                .commit();
    }

    void setRegistrationFragment(){
        RegistrationFragment registrationFragment = RegistrationFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, registrationFragment)
                .commit();
    }
}