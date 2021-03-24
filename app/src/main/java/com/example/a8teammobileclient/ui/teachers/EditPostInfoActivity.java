package com.example.a8teammobileclient.ui.teachers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Comment;
import com.example.a8teammobileclient.entity.Post;
import com.example.a8teammobileclient.entity.ResponseModel;
import com.example.a8teammobileclient.service.RetrofitConfig;
import com.example.a8teammobileclient.ui.GroupActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPostInfoActivity extends AppCompatActivity {
    public static String POST = "POST";

    private EditText captionET, descriptionET;
    private Button save;
    private Post post;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        post = new Gson().fromJson(getIntent().getStringExtra(POST), Post.class);

        captionET = findViewById(R.id.captionET);
        descriptionET = findViewById(R.id.descriptionET);
        save = findViewById(R.id.savePost);

        captionET.setText(post.getCaption() == null ? "": post.getCaption());
        descriptionET.setText(post.getDescription() == null ? "" : post.getDescription());
        save.setOnClickListener(v -> {
            editPost();
            if(post.getId() == null) {
                RetrofitConfig.get().getPostService().create(post).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()){
                            openGroupActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }else{
                RetrofitConfig.get().getPostService().modify(post).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()){
                            openGroupActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

    }

    private void editPost() {
        post.setCaption(captionET.getText().toString());
        post.setDescription(descriptionET.getText().toString());
    }

    private void openGroupActivity() {
        Intent intent = new Intent(getApplicationContext(), GroupActivity.class);
        intent.putExtra(GroupActivity.KEY_GROUP_ID, post.getGroupId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
