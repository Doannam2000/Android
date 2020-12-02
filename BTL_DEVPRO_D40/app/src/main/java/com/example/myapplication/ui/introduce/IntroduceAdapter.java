package com.example.myapplication.ui.introduce;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IntroduceAdapter extends ViewModel {

    private MutableLiveData<String> mText;

    public IntroduceAdapter() {
        mText = new MutableLiveData<>();
        mText.setValue("This is introduce fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}