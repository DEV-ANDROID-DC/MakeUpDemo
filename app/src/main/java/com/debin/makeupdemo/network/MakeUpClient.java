package com.debin.makeupdemo.network;

import com.debin.makeupdemo.BuildConfig;
import com.debin.makeupdemo.model.MakeUp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeUpClient {

    @GET(BuildConfig.END_POINT)
    Observable<List<MakeUp>> getMakeUpItems(@Query("product_category") String productCategory);
}
