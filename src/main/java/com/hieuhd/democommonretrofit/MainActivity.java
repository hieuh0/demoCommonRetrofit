package com.hieuhd.democommonretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitService service = RetrofitClient.getClient();
        Call<User> call = service.testConnection("/demojson/demo.json");

        handleResponse(call, new ResponseHandler<User>() {
            @Override
            public void onResponse(User response) {
                Log.d("TAG",response.getFirstName());
            }
        });
    }

    protected <T> void handleResponse(Call<T> call, final ResponseHandler<T> responseHandler) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(final Call<T> call, final Response<T> response) {
                if (response.isSuccessful()) {
                    if (responseHandler != null ) {
                        responseHandler.onResponse(response.body());
                    }
                } else {
                    Log.d("TAG",response.errorBody().toString());
//                    final ModelEvent errorResponse = parseError(response);
//                    if (responseHandler != null) {
//                        responseHandler.onError(errorResponse);
//                    }
                }
            }

            @Override
            public void onFailure(final Call<T> call, final Throwable throwable) {
                if (responseHandler != null) {
                    responseHandler.onFailure(throwable);
                }
            }
        });
    }
}
