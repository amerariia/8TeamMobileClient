package com.example.a8teammobileclient.ui.authentication;

import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
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
import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.validator.AuthenticationValidator;

import java.util.Optional;

public class RegistrationFragment extends Fragment {

    private EditText loginET, emailET, nameET, passwordET, confirmPasswordET;
    private Button loginBtn, registerBtn;
    private TextView errorTV;
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
        emailET = view.findViewById(R.id.emailEditText_Register);
        nameET = view.findViewById(R.id.nameEditText_Register);
        passwordET = view.findViewById(R.id.passwordEditText_Register);
        confirmPasswordET = view.findViewById(R.id.passwordConfirmEditText_Register);

        errorTV = view.findViewById(R.id.errorTextView_Register);

        loginBtn = view.findViewById(R.id.loginButton_Register);
        registerBtn = view.findViewById(R.id.registerButton_Register);

        loginET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);
        emailET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);
        nameET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);
        passwordET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);
        confirmPasswordET. setInputType(InputType. TYPE_TEXT_FLAG_NO_SUGGESTIONS| InputType.TYPE_CLASS_TEXT);

        loginBtn.setOnClickListener(
                v -> Optional.ofNullable((AuthenticationActivity) getActivity())
                        .ifPresent(AuthenticationActivity::setLoginFragment)
        );

        registerBtn.setOnClickListener(
                v -> {

                    try{
                        AuthenticationValidator.validateLogin(loginET.getText().toString());
                        AuthenticationValidator.validateName(nameET.getText().toString());
                        AuthenticationValidator.validatePassword(passwordET.getText().toString());
                        AuthenticationValidator.validateEmail(emailET.getText().toString());
                        AuthenticationValidator.confirmPasswords(passwordET.getText().toString(), confirmPasswordET.getText().toString());
                    }catch(RuntimeException e){
                        errorTV.setText(e.getMessage());
                    }
                    User user = User.builder()
                            //.login(loginET.getText().toString())
                            .email(emailET.getText().toString())
                            .firstName(nameET.getText().toString())
                            .password(passwordET.getText().toString())
                            .build();
                }
        );

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
