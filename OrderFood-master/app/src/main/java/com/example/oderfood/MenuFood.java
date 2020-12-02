package com.example.oderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuFood extends AppCompatActivity {
    TextView tvUserName,tvCartCounter,tvPriceCounter;
    ImageView imgCart;
    Button btnOrder;
    RecyclerView lvFoodOrder;
    List<Food> listMenu,listCart;
    int mPossition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_food);
        tvUserName = findViewById(R.id.tvUserName);
        tvCartCounter = findViewById(R.id.tvcartCounter);
        tvPriceCounter = findViewById(R.id.tvPriceCounter);
        imgCart = findViewById(R.id.imgCart);
        lvFoodOrder = findViewById(R.id.lvMenuFoodOrder);
        btnOrder = findViewById(R.id.btnOrder);
        //nhận intent
        final Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        tvUserName.setText(userName);

        //Xử lí RecycleView
        listMenu = new ArrayList<>();
        listCart = new ArrayList<>();
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"Pizza",100));
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"KFC",110));
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"CoCa Cola",120));
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"Chicken",120));
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"Cup Cake",32));
        listMenu.add(new Food(R.drawable.ic_local_grocery_store_black_24dp,"Bread Eggs",35));

        FoodAdapter adapter = new FoodAdapter(listMenu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),RecyclerView.VERTICAL,false);
        lvFoodOrder.setAdapter(adapter);
        lvFoodOrder.setLayoutManager(layoutManager);
        adapter.setIonClickFood(new IonClickFood() {
            @Override
            public void onClickName(Food food) {
                int counter = Integer.parseInt(tvCartCounter.getText().toString());
                counter++;
                tvCartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                tvPriceCounter.setText(String.valueOf(priceCounter));
                mPossition = listMenu.indexOf(food);
                listCart.add(food);
            }

            @Override
            public void onClickImg(Food food) {
                int counter = Integer.parseInt(tvCartCounter.getText().toString());
                counter++;
                tvCartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                tvPriceCounter.setText(String.valueOf(priceCounter));
                mPossition = listMenu.indexOf(food);
                listCart.add(food);
            }

            @Override
            public void onClickLayout(Food food) {
                int counter = Integer.parseInt(tvCartCounter.getText().toString());
                counter++;
                tvCartCounter.setText(String.valueOf(counter));
                int priceCounter = Integer.parseInt(tvPriceCounter.getText().toString());
                priceCounter+=food.getPriceFood();
                tvPriceCounter.setText(String.valueOf(priceCounter));
                mPossition = listMenu.indexOf(food);
                listCart.add(food);
            }
        });
        //Button Order
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Đơn hàng của bạn đã được gửi lên nhà hàng",Toast.LENGTH_SHORT).show();
                tvCartCounter.setText("0");
                tvPriceCounter.setText("0");
            }
        });
        //OnclickCart
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(),Cart.class);
                intent1.putExtra("totalPrice",tvPriceCounter.getText().toString());
//                intent1.putExtra("object",listMenu.get(mPossition));
                intent1.putParcelableArrayListExtra("list", (ArrayList<Food>) listCart);
                startActivity(intent1);
            }
        });
    }
}
