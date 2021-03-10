package controller.form;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a8teammobileclient.entity.ResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDelete implements Callback<ResponseModel> {
    private final AppCompatActivity activity;
    public FormDelete(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        if(response.isSuccessful()){
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {
        // TODO send to actiity

    }
}
