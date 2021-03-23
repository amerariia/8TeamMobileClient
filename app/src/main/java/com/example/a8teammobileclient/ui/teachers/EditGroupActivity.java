package com.example.a8teammobileclient.ui.teachers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.entity.ResponseModel;
import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.service.RetrofitConfig;
import com.example.a8teammobileclient.ui.GroupActivity;
import com.example.a8teammobileclient.ui.GroupsActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditGroupActivity extends AppCompatActivity {
    public static final String GROUP = "GROUP";
    private EditText nameET, descriptionET, contentET;
    private Button saveButton;

    private Group group;
    private List<CheckBox> checkBoxes;
//    private List<User> students;
//    private List<User> teachers;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);

        group = new Gson().fromJson( getIntent().getStringExtra(GROUP), Group.class);
        nameET = findViewById(R.id.editTextGroupName);
        descriptionET = findViewById(R.id.editTextGroupDescription);
        contentET = findViewById(R.id.editTextGroupContent);
        saveButton = findViewById(R.id.saveGroup);

        nameET.setText(group.getName() == null ? "" : group.getName());
        descriptionET.setText(group.getDescription());
        contentET.setText(group.getUsefulContent());
        loadUsers();

        saveButton.setOnClickListener(v -> {
            editGroup();
            if (group.getId() == null) {
                RetrofitConfig.get().getGroupService().create(group).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()){
                            loadGroupActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(EditGroupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                RetrofitConfig.get().getGroupService().modify(group).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(response.isSuccessful()){
                            loadGroupActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(EditGroupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void editGroup() {
        group.setName(nameET.getText().toString());
        group.setDescription(descriptionET.getText().toString());
        group.setUsefulContent(contentET.getText().toString());

        List<User> temp = new ArrayList<>();

        for(int i = 0; i < checkBoxes.size(); ++i){
            if(checkBoxes.get(i).isChecked()){
                temp.add(group.getParticipants().get(i));
            }
        }

        //temp.addAll(teachers);

        group.setParticipants(temp);
    }

    private void loadUsers() {
        LinearLayout view = findViewById(R.id.usersView);
        view.removeAllViews();

//        students = new ArrayList<>();
//        teachers = new ArrayList<>();

//        for (User user :
//                group.getParticipants()) {
//            if(user.getRole().equals(Role.student.name())){
//                students.add(user);
//            }else if(user.getRole().equals(Role.teacher.name())){
//                students.add(user);
//            }
//        }

        checkBoxes = new ArrayList<>();
        for(User u : group.getParticipants()){
            CheckBox checkBox = new CheckBox(view.getContext());
            checkBox.setText(u.getFirstName() + " " + u.getLastName());
            checkBox.setChecked(true);
            checkBoxes.add(checkBox);
            view.addView(checkBox);
        }
    }

    private void loadGroupActivity(){
        Intent intent = new Intent(this, GroupsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
