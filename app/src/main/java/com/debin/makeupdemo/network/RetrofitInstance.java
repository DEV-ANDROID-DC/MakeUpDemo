package com.debin.makeupdemo.network;

import com.debin.makeupdemo.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

   public static MakeUpClient getMakeUpClient() {
        return getRetrofit().create(MakeUpClient.class);
   }
}
