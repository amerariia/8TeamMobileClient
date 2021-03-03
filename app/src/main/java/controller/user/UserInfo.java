package controller.user;

import com.example.a8teammobileclient.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfo implements Callback<User> {
    @Override
    public void onResponse(Call<User> call, Response<User> response) {

    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {

    }
}
