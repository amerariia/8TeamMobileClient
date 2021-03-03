package controller.post;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDelete implements Callback<RequestBody> {
    @Override
    public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {

    }

    @Override
    public void onFailure(Call<RequestBody> call, Throwable t) {

    }
}
