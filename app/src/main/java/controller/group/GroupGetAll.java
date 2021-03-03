package controller.group;

import com.example.a8teammobileclient.entity.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GroupGetAll implements Callback<List<Group>> {
    @Override
    public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {

    }

    @Override
    public void onFailure(Call<List<Group>> call, Throwable t) {

    }
}
