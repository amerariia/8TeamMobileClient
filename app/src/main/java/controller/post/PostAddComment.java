package controller.post;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.entity.ResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostAddComment implements Callback<ResponseModel> {
    private final AppCompatActivity activity;
    public PostAddComment(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {

    }
}
