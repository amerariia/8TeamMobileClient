package com.example.a8teammobileclient.ui.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.a8teammobileclient.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Optional;

public class SharedPreferencesHelper {

    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String LOGGED_USER = "LOGGED_USER";
    public static final Type USER_TYPE = new TypeToken<User>(){}.getType();

    private SharedPreferences sharedPreferences;
    private static SharedPreferencesHelper sharedPreferencesHelper;
    private User currentUser;
    private Gson mGson = new Gson();

    private SharedPreferencesHelper(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferencesHelper getInstance(Context context){
        if(sharedPreferencesHelper == null){
            sharedPreferencesHelper = new SharedPreferencesHelper(context);
        }
        return sharedPreferencesHelper;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<User> getCurrentUser(){
        if(currentUser == null){
            return getUser();
        }

        return Optional.of(currentUser);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<User> getUser(){
        String user = sharedPreferences.getString(LOGGED_USER, LOGGED_USER);
        if (user.equals(LOGGED_USER)) {
            return Optional.empty();
        }
        currentUser = mGson.fromJson(sharedPreferences.getString(LOGGED_USER, LOGGED_USER), User.class);
        return Optional.ofNullable(currentUser);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addUser(User newUser){

        sharedPreferences.edit().putString(LOGGED_USER, mGson.toJson(newUser, USER_TYPE)).apply();
        currentUser = newUser;

    }

    public void deleteUser(){
        sharedPreferences.edit().remove(LOGGED_USER).apply();
        currentUser = null;
    }
}
