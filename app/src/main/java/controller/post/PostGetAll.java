package controller.post;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class PostGetAll implements Callback<List<Post>> {
    private final AppCompatActivity activity;
    public PostGetAll(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {

    }
}
