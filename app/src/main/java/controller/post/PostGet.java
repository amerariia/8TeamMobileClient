package controller.post;

import com.example.a8teammobileclient.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostGet implements Callback<Post> {
    @Override
    public void onResponse(Call<Post> call, Response<Post> response) {

    }

    @Override
    public void onFailure(Call<Post> call, Throwable t) {

    }
}
