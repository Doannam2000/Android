package com.example.testnavigation.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.testnavigation.MainActivity;
import com.example.testnavigation.R;
import com.example.testnavigation.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class HomeFragment extends Fragment {
  FragmentHomeBinding binding;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.avt01,R.drawable.avt2,R.drawable.avt03,R.drawable.avt01,R.drawable.avt2,R.drawable.avt03};
    private ArrayList<Integer> ImgArray = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
  init();
        return binding.getRoot();
    }

    private void init (){
        for (int i=0; i<img.length; i++)
            ImgArray.add(img[i]);


        binding.pager.setAdapter(new ViewPagerAdapter(getContext(), ImgArray));
        binding.indicator.setViewPager(mPager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == img.length){
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        //Auto start
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }


}
