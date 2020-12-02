package com.example.oderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    ImageView imgback;
    TextView tvPrice;
    RecyclerView rcvListOrder;
    List<Food> listOrder;
    Food food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        imgback = findViewById(R.id.imgBack);
        tvPrice = findViewById(R.id.tvPriceCounterOrder);
        rcvListOrder = findViewById(R.id.lvFoodOrder);
        Intent intent = getIntent();
        String price = intent.getStringExtra("totalPrice");
        tvPrice.setText(price);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listOrder = new ArrayList<>();
//        food = (Food) intent.getSerializableExtra("object");
        listOrder = (List<Food>) intent.getSerializableExtra("list");
        FoodAdapter foodAdapter = new FoodAdapter(listOrder);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);
        rcvListOrder.setLayoutManager(layoutManager);
        rcvListOrder.setAdapter(foodAdapter);
    }
}
