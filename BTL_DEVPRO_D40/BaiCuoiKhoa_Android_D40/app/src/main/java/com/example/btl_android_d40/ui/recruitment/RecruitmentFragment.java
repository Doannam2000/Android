package com.example.btl_android_d40.ui.recruitment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.btl_android_d40.R;
import com.example.btl_android_d40.ui.promotion.PromotionViewModel;

public class RecruitmentFragment extends Fragment {


    private RecruitmentViewModel recruitmentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recruitmentViewModel =
                ViewModelProviders.of(this).get(RecruitmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_promotion, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        recruitmentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
