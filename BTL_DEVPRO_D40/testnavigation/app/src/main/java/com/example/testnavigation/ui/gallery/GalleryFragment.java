package com.example.testnavigation.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testnavigation.R;
import com.example.testnavigation.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

 FragmentGalleryBinding binding;
    public static GalleryFragment newInstance() {

        Bundle args = new Bundle();

        GalleryFragment fragment = new GalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater,R.layout.fragment_gallery,container,false);

    binding.textGallery.setText("Nguyễn Anh Linh");

        return binding.getRoot();
    }
}
