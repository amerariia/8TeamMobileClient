package com.example.a8teammobileclient.ui;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.example.a8teammobileclient.entity.Role;
import com.example.a8teammobileclient.service.RetrofitConfig;
import com.example.a8teammobileclient.ui.authentication.AuthenticationActivity;
import com.example.a8teammobileclient.ui.authentication.SharedPreferencesHelper;
import com.example.a8teammobileclient.ui.teachers.EditGroupActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsActivity extends AppCompatActivity {
    private static final int MENU_PROFILE = 1;
    private static final int MENU_CREATE = 2;
    private static final int MENU_LOGOUT = 3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        SharedPreferencesHelper.getInstance(this).getUser().ifPresent(user -> {
            RetrofitConfig.get().getGroupService().getAll(user.getId()).enqueue(new Callback<List<Group>>() {
                @Override
                public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                    if(response.isSuccessful()){
                        addGroupsToActivity(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<Group>> call, Throwable t) {
                    Toast.makeText(GroupsActivity.this, "Cannot load groups", Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_groups, menu);
        SharedPreferencesHelper.getInstance(getApplicationContext()).getCurrentUser().ifPresent(user -> {
            if(user.getRole() == Role.student){
                menu.findItem(R.id.itemCreate).setVisible(false);
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
            case R.id.itemCreate:{
                // open create group activity
                Group group = Group.builder().participants(new ArrayList<>()).build();
                Intent intent = new Intent(this, EditGroupActivity.class);
                intent.putExtra(EditGroupActivity.GROUP, new Gson().toJson(group));
                startActivity(intent);
                break;
            }
            case R.id.itemFindGroup:{
                Intent intent = new Intent(this, FindGroupActivity.class);
                startActivity(intent);
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

    @Override
    protected void onResume() {
        super.onResume();
    }


    private static class A implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            v.getId();

            // open new activity with group id
            Intent intent = new Intent(v.getContext(), GroupActivity.class);
            intent.putExtra(GroupActivity.KEY_GROUP_ID, v.getId());
            v.getContext().startActivity(intent);
        }
    }
    public void addGroupsToActivity(List<Group> groups){
        A openGroupByIdListener = new A();
        LinearLayout dialogL = (LinearLayout)findViewById(R.id.groups_layout);
        for(Group g : groups){
            createButtonForGroup(openGroupByIdListener, dialogL, g);
        }
    }

//34A029B5
    private void createButtonForGroup(A openGroupByIdListener, LinearLayout dialogL, Group g) {
        Button button = new Button(GroupsActivity.this);
        button.setId(g.getId());
        button.setOnClickListener(openGroupByIdListener);
        button.setText(g.getName());
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

}
