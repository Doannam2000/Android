package com.example.fragmentdemo;

import android.content.Context;
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

import com.example.fragmentdemo.databinding.MenufoodLayoutBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuFood extends Fragment {
    MenufoodLayoutBinding binding;
    List<Food> listMenu,listCart;
    OnFragmentManager listener;
    public static MenuFood newInstance() {

        Bundle args = new Bundle();

        MenuFood fragment = new MenuFood();
        fragment.setArguments(args);
        return fragment;
    }
    //test
    //Lưu lại trạng thái và trả về

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("usernameclone",binding.tvUserName.getText().toString());
//        outState.putParcelableArrayList("listclone", (ArrayList<? extends Parcelable>) listMenu);
//        outState.putString("priceclone",binding.tvPriceCounter.getText().toString());
//        outState.putString("amoutclone",binding.tvcartCounter.getText().toString());
//
//    }
//
//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        String username = savedInstanceState.getString("usernameclone");
//        if(username!=null){
//            binding.tvUserName.setText(username);
//        }
//        super.onViewStateRestored(savedInstanceState);
//    }

    //Kiểm tra xem context là Fragment này hay không
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentManager){
            listener = (OnFragmentManager) context;
        }
        else{
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }

    }

    //
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.menufood_layout,container,false);

        binding = DataBindingUtil.inflate(inflater,R.layout.menufood_layout,container,false);
        //Xi li all
        listMenu = new ArrayList<>();
        listCart = new ArrayList<>();
        listMenu.add(new Food(R.drawable.pizza,"Pizza Panda",100));
        listMenu.add(new Food(R.drawable.kfc,"KFC Super",110));
        listMenu.add(new Food(R.drawable.bread_egg,"Bread Eggs",15));
        listMenu.add(new Food(R.drawable.cup_cake,"Cup cake",12));
        listMenu.add(new Food(R.drawable.hamburger,"Hamburger",32));
        listMenu.add(new Food(R.drawable.hotdog,"Hotdog",35));
        listMenu.add(new Food(R.drawable.potato,"Potato",40));

        FoodAdapter adapter = new FoodAdapter(listMenu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.lvMenuFoodOrder.setAdapter(adapter);
        binding.lvMenuFoodOrder.setLayoutManager(layoutManager);
        adapter.setIonClickFood(new IonClickFood() {
            @Override
            public void onClickName(Food food) {
                int counter = Integer.parseInt(binding.tvcartCounter.getText().toString());
                counter++;
                binding.tvcartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(binding.tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                binding.tvPriceCounter.setText(String.valueOf(priceCounter));
//                mPossition = listMenu.indexOf(food);
                if(listCart.contains(food)){
                    food.setAmount(food.getAmount()+1);
                }
                else{
                    food.setAmount(food.getAmount()+1);
                    listCart.add(food);
                }
                listener.onItemSelected(listCart);
                listener.onPriceToTal(binding.tvPriceCounter.getText().toString());

            }

            @Override
            public void onClickImg(Food food) {
                int counter = Integer.parseInt(binding.tvcartCounter.getText().toString());
                counter++;
                binding.tvcartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(binding.tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                binding.tvPriceCounter.setText(String.valueOf(priceCounter));
//                mPossition = listMenu.indexOf(food);
                if(listCart.contains(food)){
                    food.setAmount(food.getAmount()+1);
                }
                else{
                    food.setAmount(food.getAmount()+1);
                    listCart.add(food);
                }
                listener.onItemSelected(listCart);
                listener.onPriceToTal(binding.tvPriceCounter.getText().toString());
            }

            @Override
            public void onClickLayout(Food food) {
                int counter = Integer.parseInt(binding.tvcartCounter.getText().toString());
                counter++;
                binding.tvcartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(binding.tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                binding.tvPriceCounter.setText(String.valueOf(priceCounter));
//              mPossition = listMenu.indexOf(food);
                if(listCart.contains(food)){
                    food.setAmount(food.getAmount()+1);
                }
                else{
                    food.setAmount(food.getAmount()+1);
                    listCart.add(food);
                }
                listener.onItemSelected(listCart);
                listener.onPriceToTal(binding.tvPriceCounter.getText().toString());
            }
        });

        //onClick giỏ hàng
        binding.imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //chuyển qua lại giữa 2 Fragment
                Fragment fragment = Cart.newInstance(listCart,binding.tvPriceCounter.getText().toString());
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layoutfragment, fragment);
                fragmentTransaction.commit();

//                bundle.putSerializable("ListOrder", (Serializable) listCart);
//                cart.setArguments(bundle);
            }
        });

        //onClick Order
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Đơn hàng của bạn đã được gửi lên nhà hàng",Toast.LENGTH_SHORT).show();
                binding.tvcartCounter.setText("0");
                binding.tvPriceCounter.setText("0");
                listCart.clear();
                listener.onItemSelected(listCart);
                listener.onPriceToTal(binding.tvPriceCounter.getText().toString());
            }
        });

        return binding.getRoot();
    }
}
