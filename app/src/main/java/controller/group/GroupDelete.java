package controller.group;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupDelete implements Callback<ResponseBody> {
    private final AppCompatActivity activity;
    public GroupDelete(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }
}
