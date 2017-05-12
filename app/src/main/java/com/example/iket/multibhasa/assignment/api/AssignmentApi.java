package com.example.iket.multibhasa.assignment.api;

import com.example.iket.multibhasa.assignment.model.data.ListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iket on 10/5/17.
 */

public interface AssignmentApi {

    @GET("hoo8n/")
    Call<ListData> getData();
}
