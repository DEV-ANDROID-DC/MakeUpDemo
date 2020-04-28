package com.debin.makeupdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.debin.makeupdemo.model.MakeUp;
import com.debin.makeupdemo.repository.MakeUpRepository;

import java.util.List;


public class MakeUpViewModel extends ViewModel {

    private MakeUpRepository makeUpRepository;
    public MakeUpViewModel() {
        makeUpRepository = new MakeUpRepository();
    }

    public LiveData<List<MakeUp>> getMakeUpData() {
        return makeUpRepository.getMutableLiveData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        makeUpRepository.ClearDisposible();
    }
}
