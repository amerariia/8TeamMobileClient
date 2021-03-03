package com.example.a8teammobileclient.ui;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.testData;
import com.example.a8teammobileclient.ui.authentication.AuthenticationActivity;
import com.example.a8teammobileclient.ui.authentication.SharedPreferencesHelper;

import java.util.List;

public class GroupsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        addGroupsToActivity(loadGroups());

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.itemProfile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.itemLogout) {
//            SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(this);
//            sharedPreferencesHelper.deleteUser();
            Intent intent = new Intent(this, AuthenticationActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    private List<Group> loadGroups() {
        return testData.groups;
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
