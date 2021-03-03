package controller.user;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a8teammobileclient.entity.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignIn implements Callback<String> {
    private final AppCompatActivity activity;
    public UserSignIn(AppCompatActivity activity){
        this.activity = activity;
    }
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        // TODO save token
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

    }
}
