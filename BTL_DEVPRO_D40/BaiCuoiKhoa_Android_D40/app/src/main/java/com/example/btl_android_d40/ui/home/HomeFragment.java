package com.example.btl_android_d40.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.btl_android_d40.R;
import com.example.btl_android_d40.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);

        CustomPagerAdapter viewPagerAdapter = new CustomPagerAdapter(getContext());

        binding.viewPager.setAdapter(viewPagerAdapter);
        return binding.getRoot();
    }
}
