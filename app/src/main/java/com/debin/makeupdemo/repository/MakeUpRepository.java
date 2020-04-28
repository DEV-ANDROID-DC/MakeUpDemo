package com.debin.makeupdemo.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.debin.makeupdemo.model.MakeUp;
import com.debin.makeupdemo.network.MakeUpClient;
import com.debin.makeupdemo.network.RetrofitInstance;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MakeUpRepository {
    Application application;
    MutableLiveData<List<MakeUp>> mutableLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MakeUpRepository() {

    }

    public MutableLiveData<List<MakeUp>> getMutableLiveData() {
        MakeUpClient makeUpClient = RetrofitInstance.getMakeUpClient();
        makeUpClient.getMakeUpItems("powder")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MakeUp>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                      compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<MakeUp> value) {
                        mutableLiveData.setValue(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return mutableLiveData;
    }

    public void ClearDisposible() {
        compositeDisposable.clear();
    }

}
