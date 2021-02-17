package com.example.a8teammobileclient.authentication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.a8teammobileclient.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import static com.example.a8teammobileclient.validator.AuthenticationValidator.*;

public class RegistrationFragment extends Fragment {

    private EditText loginET, nameET, passwordET, confirmPasswordET;
    private Button loginB, registerB;
    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginET = view.findViewById(R.id.loginEditText_Register);
        nameET = view.findViewById(R.id.nameEditText_Register);
        passwordET = view.findViewById(R.id.passwordEditText_Register);
        confirmPasswordET = view.findViewById(R.id.passwordConfirmEditText_Register);
        loginB = view.findViewById(R.id.loginButton_Register);
        registerB = view.findViewById(R.id.registerButton_Register);

        loginET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);
//
//        loginET.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                loginET.setTextColor(Color.GREEN);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                try{
//                    validateLoginOrPassword(s.toString());
//                }catch(RuntimeException e){
//                    loginET.setTextColor(Color.RED);
//                }
//            }
//        });
    }
}
