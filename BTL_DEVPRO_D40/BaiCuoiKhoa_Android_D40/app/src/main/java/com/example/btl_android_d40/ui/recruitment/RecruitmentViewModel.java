package com.example.btl_android_d40.ui.recruitment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecruitmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecruitmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
