package com.example.a8teammobileclient.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.R;
import com.example.a8teammobileclient.entity.Group;
import com.example.a8teammobileclient.service.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindGroupActivity extends AppCompatActivity {
    private EditText identificatorET;
    private Button findGroupBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);

        identificatorET = findViewById(R.id.groupIdentificatorET);
        findGroupBtn = findViewById(R.id.findGroupBtn);

        findGroupBtn.setOnClickListener(v ->  {
            RetrofitConfig.get().getGroupService().findGroup(identificatorET.getText().toString()).enqueue(new Callback<Group>() {
                @Override
                public void onResponse(Call<Group> call, Response<Group> response) {
                    if(response.isSuccessful()){
                        openGroupsActivity();
                    }
                    Toast.makeText(FindGroupActivity.this, "Wrong identifier", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Group> call, Throwable t) {
                    Toast.makeText(FindGroupActivity.this, "Wrong identifier", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void openGroupsActivity() {
        Intent intent = new Intent(getApplicationContext(), GroupsActivity.class);
        startActivity(intent);
    }
}
