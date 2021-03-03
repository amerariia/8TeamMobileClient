package controller.group;

import com.example.a8teammobileclient.entity.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupGet implements Callback<Group> {
    @Override
    public void onResponse(Call<Group> call, Response<Group> response) {

    }

    @Override
    public void onFailure(Call<Group> call, Throwable t) {

    }
}
