package com.example.a8teammobileclient.ui.authentication;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.a8teammobileclient.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class SharedPreferencesHelper {

    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String LOGGED_USER = "LOGGED_USER";
    public static final Type USER_TYPE = new TypeToken<User>(){}.getType();

    private SharedPreferences sharedPreferences;
    private static SharedPreferencesHelper sharedPreferencesHelper;
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

    public User getUser(){
        return mGson.fromJson(sharedPreferences.getString(LOGGED_USER, LOGGED_USER), USER_TYPE);
    }

    public void addUser(User newUser){
        User user = getUser();
        if(!(user.getLogin().equals(newUser.getLogin()))){
            sharedPreferences.edit().putString(LOGGED_USER, mGson.toJson(newUser, USER_TYPE)).apply();
        }
    }

    public void deleteUser(){
        sharedPreferences.edit().remove(LOGGED_USER);
    }
}
