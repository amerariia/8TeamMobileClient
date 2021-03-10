package com.example.a8teammobileclient.ui.authentication;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Role;
import com.example.a8teammobileclient.entity.Token;
import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.service.RetrofitConfig;

import java.util.Optional;

import controller.user.UserInfo;
import controller.user.UserSignIn;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    private Button registerBtn, loginBtn;
    private EditText loginET, passwordET;
    private TextView errorTV;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerBtn = view.findViewById(R.id.registerButton_Login);
        loginBtn = view.findViewById(R.id.loginButton_Login);
        loginET = view.findViewById(R.id.loginEditText_Login);
        passwordET = view.findViewById(R.id.passwordEditText_Login);
        errorTV = view.findViewById(R.id.errorTextView_Login);

        registerBtn.setOnClickListener(
                v -> Optional.ofNullable((AuthenticationActivity) getActivity())
                .ifPresent(AuthenticationActivity::setRegistrationFragment)
        );

        loginBtn.setOnClickListener(
                v -> {
                    String login = loginET.getText().toString();
                    String password = passwordET.getText().toString();

                    RetrofitConfig.get()
                            .getUserService().signIn(
                                    User.builder().id("").firstName("").lastName("").role(Role.STUDENT).email(login).password(password).build()
                            ).enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            // TODO save token
                            if(response.isSuccessful()){
                                RetrofitConfig.trySetToken(response.body());
                                loginSuccess();
                            }else{
                                String message = response.message();
                            }
                        }

                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
//                    if(testData.users.stream()
//                            .anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password))){
//                        ((AuthenticationActivity) getActivity()).openGroupsActivity();
//
//                    }
//                    else{
//                        errorTV.setText("Невірний логін або пароль. \nЯкщо ви не зареєстровані - зареєструйтесь :)");
//                    }
                }
        );

        // buttons, views initialization
    }

    public void loginSuccess(){
        RetrofitConfig.get().getUserService().info().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user = response.body();
                    SharedPreferencesHelper.getInstance(getContext()).addUser(user);
                    ((AuthenticationActivity) getActivity()).openGroupsActivity();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), "Can`t get user info", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void userInfo(User user){
        Toast.makeText(getContext(), user.getFirstName(), Toast.LENGTH_SHORT).show();
    }

}
