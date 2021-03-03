package controller.form;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Form;
import com.example.a8teammobileclient.entity.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormCreate implements Callback<ResponseModel> {
    private final AppCompatActivity activity;
    public FormCreate(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        if(response.isSuccessful()){
            ResponseModel form = response.body();
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {
        // TODO send to actiity
    }
}
