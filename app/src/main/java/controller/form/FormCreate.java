package controller.form;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Form;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormCreate implements Callback<Form> {
    private final AppCompatActivity activity;
    public FormCreate(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<Form> call, Response<Form> response) {
        if(response.isSuccessful()){
            Form form = response.body();
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<Form> call, Throwable t) {
        // TODO send to actiity
    }
}
