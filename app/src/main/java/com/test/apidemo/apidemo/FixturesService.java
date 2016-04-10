package com.test.apidemo.apidemo;

import com.test.apidemo.apidemo.gsonhelper.FixturesDetail;

import retrofit.Call;
import retrofit.http.GET;


public interface FixturesService {

    @GET("alpha/soccerseasons/398/fixtures")
    public Call<FixturesDetail> getFixturesDetail();
}
