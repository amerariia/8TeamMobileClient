package controller.group;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupGet implements Callback<Group> {
    private final AppCompatActivity activity;
    public GroupGet(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<Group> call, Response<Group> response) {

    }

    @Override
    public void onFailure(Call<Group> call, Throwable t) {

    }
}
