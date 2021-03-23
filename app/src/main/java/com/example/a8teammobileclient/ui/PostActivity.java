package com.example.a8teammobileclient.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.Post;
import com.example.a8teammobileclient.service.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    public static final String KEY_POST_ID = "KEY_POST_ID";
    private TextView postNameTV, postDescriptionTV, publishedCommentsTV;
    private EditText addNewCommentET;
    private Button addNewCommentBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Bundle extras = getIntent().getExtras();
        int postId = extras.getInt(KEY_POST_ID);
        postNameTV = findViewById(R.id.textViewPostName);
        postDescriptionTV = findViewById(R.id.textViewPostDescription);
        publishedCommentsTV = findViewById(R.id.textViewPublishedComments);
        addNewCommentET = findViewById(R.id.editTextPostComment);
        addNewCommentBtn = findViewById(R.id.buttonSendComment);

        RetrofitConfig.get().getPostService().get(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Post body = response.body();
                    postNameTV.setText(body.getCaption());
                    postDescriptionTV.setText(body.getDescription());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNewCommentBtn.setOnClickListener(v -> {
            String comment = addNewCommentET.getText().toString();
            if(comment.isEmpty()){ }
            else{
                String publishedComments = publishedCommentsTV.getText().toString();
                publishedComments += "\n" + comment;
                publishedCommentsTV.setText(publishedComments);
            }
        });
    }
}
