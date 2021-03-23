package com.example.a8teammobileclient.ui;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.google.gson.Gson;

public class InfoGroupActivity extends AppCompatActivity {
    public static final String GROUP = "GROUP";
    private Group group;
    private LinearLayout info;
    private Button groupName;
    private EditText identifierTV, descriptionTV, linksTV;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_group);
        group = new Gson().fromJson(getIntent().getStringExtra(GROUP), Group.class);

        info = findViewById(R.id.groupInfo);
        groupName = findViewById(R.id.groupName);
        identifierTV = findViewById(R.id.identifierTV);
        descriptionTV = findViewById(R.id.descriptionTV);
        linksTV = findViewById(R.id.linksTV);

        fillInfoLayout();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void fillInfoLayout(){
        groupName.setText(group.getName());
        identifierTV.setText(group.getIdentificator());
        descriptionTV.setText(group.getDescription());
        linksTV.setText(group.getUsefulContent());

        group.getParticipants().forEach(user -> {
            TextView u = new TextView(info.getContext());
            u.setText(user.getFirstName() + " " + user.getLastName());
            info.addView(u);
        });
    }
}
