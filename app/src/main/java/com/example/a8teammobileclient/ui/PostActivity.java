package com.example.a8teammobileclient.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Comment;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.Post;
import com.example.a8teammobileclient.entity.ResponseModel;
import com.example.a8teammobileclient.service.RetrofitConfig;

import com.example.a8teammobileclient.ui.authentication.SharedPreferencesHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    public static final String KEY_POST_ID = "KEY_POST_ID";
    private TextView postNameTV, postDescriptionTV, publishedCommentsTV;
    private EditText addNewCommentET;
    private Button addNewCommentBtn;
    private LinearLayout layout;


    private Post post;

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
        layout = findViewById(R.id.commentsLayout);

        RetrofitConfig.get().getPostService().get(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    post = response.body();
                    fillInfo();
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
            Comment comment = Comment.builder()
                    .text(addNewCommentET.getText().toString())
                    .postId(post.getId())
                    .sender(SharedPreferencesHelper.getInstance(getApplicationContext()).getCurrentUser().get())
                    .build();
            RetrofitConfig.get().getPostService().addComment(comment).enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    if(response.isSuccessful()){
                        loadComment(comment);
                    }else{
                        Toast.makeText(PostActivity.this, "Не вдалося додати коментар", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                }
            });

            comment.setText("");
        });
    }

    private void fillInfo(){
        postNameTV.setText(post.getCaption());
        postDescriptionTV.setText(post.getDescription());
        loadComments();
    }

    private void loadComments(){
        for(Comment comment : post.getComments()){
            loadComment(comment);
        }
    }

    private void loadComment(Comment comment){
        TextView textView = new TextView(this);
        textView.setText(comment.getSender().getLastName() + ": " + comment.getText());
        layout.addView(textView);
    }
}
