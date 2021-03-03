package controller.post;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostModify implements Callback<Post> {
    private final AppCompatActivity activity;
    public PostModify(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<Post> call, Response<Post> response) {

    }

    @Override
    public void onFailure(Call<Post> call, Throwable t) {

    }
}
