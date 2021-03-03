package controller.group;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GroupGetAll implements Callback<List<Group>> {
    private final AppCompatActivity activity;
    public GroupGetAll(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {

    }

    @Override
    public void onFailure(Call<List<Group>> call, Throwable t) {

    }
}
