package com.example.a8teammobileclient.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.a8teammobileclient.R;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
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