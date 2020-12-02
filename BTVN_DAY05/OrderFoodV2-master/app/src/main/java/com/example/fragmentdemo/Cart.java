package com.example.fragmentdemo;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentdemo.databinding.CartLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Fragment {
    CartLayoutBinding binding;
    List<Food> listOrder;
    // Tạo Instance với các thuộc tính cần truyền
    public static Cart newInstance(List<Food> list ,String price) {
        Bundle bundle = new Bundle();
        Cart fragment = new Cart();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        bundle.putString("price",price);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"Giỏ hàng của bạn nè!!",Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//      View view = inflater.inflate(R.layout.cart_layout,container,false);

        binding = DataBindingUtil.inflate(inflater,R.layout.cart_layout,container,false);

        //Xi li all
        listOrder = new ArrayList<>();
//        listOrder.add(new Food(R.drawable.pizza,"Pizza Panda",100));
        listOrder = (List<Food>) getArguments().getSerializable("list");
        FoodAdapter foodAdapter = new FoodAdapter(listOrder);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.rcvFoodOrder.setLayoutManager(layoutManager);
        binding.rcvFoodOrder.setAdapter(foodAdapter);

        String price = getArguments().getString("price");
        binding.tvPriceCounterOrder.setText(price);
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MenuFood();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layoutfragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return binding.getRoot();
    }
}
