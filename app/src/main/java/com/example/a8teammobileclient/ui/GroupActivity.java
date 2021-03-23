package com.example.a8teammobileclient.ui;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.Post;
import com.example.a8teammobileclient.entity.ResponseModel;
import com.example.a8teammobileclient.entity.Role;
import com.example.a8teammobileclient.service.RetrofitConfig;
import com.example.a8teammobileclient.ui.authentication.AuthenticationActivity;
import com.example.a8teammobileclient.ui.authentication.SharedPreferencesHelper;
import com.example.a8teammobileclient.ui.teachers.EditGroupActivity;
import com.example.a8teammobileclient.ui.teachers.EditPostInfoActivity;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupActivity extends AppCompatActivity {
    public static final String KEY_GROUP_ID = "KEY_GROUP_ID";
    private Group group;

    private Button groupNameBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Bundle extras = getIntent().getExtras();
        int groupId = extras.getInt(KEY_GROUP_ID);
        groupNameBtn = findViewById(R.id.groupName);

        RetrofitConfig.get().getGroupService().get(groupId).enqueue(new Callback<Group>() {
            @Override
            public void onResponse(Call<Group> call, Response<Group> response) {
                if(response.isSuccessful()){
                    group = response.body();
                    groupNameBtn.setText(group.getName());
                }
            }

            @Override
            public void onFailure(Call<Group> call, Throwable t) {

            }
        });

        RetrofitConfig.get().getPostService().getAll(groupId).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    addPostsToActivity(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

        groupNameBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InfoGroupActivity.class);
            intent.putExtra(InfoGroupActivity.GROUP, new Gson().toJson(group));
            startActivity(intent);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_group, menu);
        SharedPreferencesHelper.getInstance(getApplicationContext()).getCurrentUser().ifPresent(user -> {
            if(user.getRole() == Role.student){
                menu.findItem(R.id.itemAddPost).setVisible(false);
                menu.findItem(R.id.itemModifyGroup).setVisible(false);
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.itemProfile:{
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.itemAddPost:{
                Intent intent = new Intent(this, EditPostInfoActivity.class);
                intent.putExtra(EditPostInfoActivity.POST, new Gson().toJson(Post.builder().groupId(group.getId()).build()));
                startActivity(intent);
                break;
            }
            case R.id.itemModifyGroup:{
                Intent intent = new Intent(this, EditGroupActivity.class);
                intent.putExtra(EditGroupActivity.GROUP, new Gson().toJson(group));
                startActivity(intent);
                break;
            }
            case R.id.itemDeleteGroup:{
                deleteThisGroup();
                break;
            }
            case R.id.itemLogout:{
                SharedPreferencesHelper.getInstance(getApplicationContext()).deleteUser();
                Intent intent = new Intent(this, AuthenticationActivity.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class A implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            v.getId();
            Intent intent = new Intent(v.getContext(), PostActivity.class);
            intent.putExtra(PostActivity.KEY_POST_ID, v.getId());
            v.getContext().startActivity(intent);
        }
    }
    public void addPostsToActivity(List<Post> posts){
        if(posts == null){
            return;
        }
        A openPostByIdListener = new A();
        LinearLayout dialogL = (LinearLayout)findViewById(R.id.postsLayout);
        for(Post p : posts){
            createButtonForPost(openPostByIdListener, dialogL, p);
        }
    }

    //34A029B5
    private void createButtonForPost(A listener, LinearLayout dialogL, Post p) {
        Button button = new Button(GroupActivity.this);
        button.setOnClickListener(listener);
        button.setId(p.getId());
        button.setText(p.getCaption());
        button.setHeight(200);
        //button.setBackgroundColor(0x00FFFFFF);
        GradientDrawable gd = new GradientDrawable();
//            gd.setColor(0x00FFFFFF);
        gd.setStroke(1, 0xFF7CD1F8);
//            button.setBackground(gd);
        LinearLayout.LayoutParams buttonLayoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(buttonLayoutParams);
        dialogL.addView(button);
    }

    private void deleteThisGroup(){
        RetrofitConfig.get().getGroupService().delete(group.getId()).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.isSuccessful()){
                    openGroupsActivity();
                }else{
                    Toast.makeText(GroupActivity.this, "Не можемо видалити групу, спробуйте пізніше", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(GroupActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGroupsActivity() {
        Intent intent = new Intent(getApplicationContext(), GroupsActivity.class);
        startActivity(intent);
    }
}
