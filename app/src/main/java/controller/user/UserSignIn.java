package controller.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.a8teammobileclient.entity.Token;
import com.example.a8teammobileclient.entity.User;
import com.example.a8teammobileclient.ui.authentication.LoginFragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignIn implements Callback<Token> {
    private final Fragment fragment;
    public static Token token = Token.builder().token("").build();
    public UserSignIn(Fragment fragment){
        this.fragment = fragment;
    }
    @Override
    public void onResponse(Call<Token> call, Response<Token> response) {
        // TODO save token
        if(response.isSuccessful()){
            token = response.body();
            ((LoginFragment)fragment).loginSuccess();
        }else{
            String message = response.message();
        }
    }

    @Override
    public void onFailure(Call<Token> call, Throwable t) {
        t.printStackTrace();
    }
}
