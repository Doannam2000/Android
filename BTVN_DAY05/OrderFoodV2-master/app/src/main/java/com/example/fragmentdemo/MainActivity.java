package com.example.fragmentdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFragmentManager{
    private static final String TAG = "MainActivity";//logt

//        Button btn1,btn2;
        String pricetemp;
        List<Food> listtemp = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ac = getSupportActionBar();
        ac.hide();


//        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
        getFragment(MenuFood.newInstance());
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(Cart.newInstance(listtemp,pricetemp));
//            }
//        });
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragment(MenuFood.newInstance());
//            }
//        });
    }
    public void getFragment(Fragment fragment){
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.layoutfragment,fragment).commit();
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"getFragment"+e.getMessage());
        }
    }

    @Override
    public void onItemSelected(List<Food> list) {
          listtemp = list;
    }

    @Override
    public void onPriceToTal(String price) {
        pricetemp =price;
    }
}
