package controller.form;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.Form;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FormGetAll implements Callback<List<Form>>{
    private final AppCompatActivity activity;
    public FormGetAll(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<List<Form>> call, Response<List<Form>> response) {
        if(response.isSuccessful()){
            List<Form> forms = response.body();

            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<List<Form>> call, Throwable t) {
        // TODO send to actiity
    }
}