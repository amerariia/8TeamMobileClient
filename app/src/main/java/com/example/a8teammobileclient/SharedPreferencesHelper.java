package com.example.a8teammobileclient;

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
    private Gson mGson = new Gson();

    public SharedPreferencesHelper(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
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
}
