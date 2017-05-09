package com.example.iket.multibhasa.assignment.model;

import android.util.Log;

import com.example.iket.multibhasa.assignment.api.AssignmentApi;
import com.example.iket.multibhasa.assignment.model.data.ListData;
import com.example.iket.multibhasa.assignment.view.Callback;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by iket on 9/5/17.
 */

public class RetrofitProvider implements ProviderInterface {


    @Override
    public void requestData(final Callback callback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        AssignmentApi assignmentApi=retrofit.create(AssignmentApi.class);
        Call<ListData>listDataCall=assignmentApi.getData();
        listDataCall.enqueue(new retrofit2.Callback<ListData>() {
            @Override
            public void onResponse(Call<ListData> call, Response<ListData> response) {
                 callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ListData> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
