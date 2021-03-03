package controller.post;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDelete implements Callback<RequestBody> {
    private final AppCompatActivity activity;
    public PostDelete(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {

    }

    @Override
    public void onFailure(Call<RequestBody> call, Throwable t) {

    }
}
