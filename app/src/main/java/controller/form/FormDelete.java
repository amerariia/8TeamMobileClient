package controller.form;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDelete implements Callback<ResponseBody> {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if(response.isSuccessful()){
            // TODO send to actiity
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        // TODO send to actiity

    }
}
