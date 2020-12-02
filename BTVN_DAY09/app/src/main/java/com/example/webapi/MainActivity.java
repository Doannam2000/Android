package com.example.webapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.webapi.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String Json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15},\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600,\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037,\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getJson();
    }

    private void getJson() {
        try {
            JSONObject jsonObject = new JSONObject(Json);

            JSONObject jsonObject1 = jsonObject.getJSONObject("main");

            int temp = jsonObject1.getInt("temp");
            int pressure = jsonObject1.getInt("pressure");
            int humidity = jsonObject1.getInt("humidity");
            double temp_min = jsonObject1.getDouble("temp_min");
            double temp_max = jsonObject1.getDouble("temp_max");

            String tv1 = "temp: " + temp;
            String tv2 = "pressure: " + pressure;
            String tv3 = "humidity: " + humidity;
            String tv4 = "temp_min: " + temp_min;
            String tv5 = "temp_max: " + temp_max;


            binding.tvone.setText(tv1);
            binding.tvtwo.setText(tv2);
            binding.tvthree.setText(tv3);
            binding.tvfour.setText(tv4);
            binding.tvfive.setText(tv5);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
