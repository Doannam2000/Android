package com.example.webapi_list;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;

import com.example.webapi_list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static  String TAG = "MainActivity";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getFragment(WebAPI_List.newInstance());
    }


    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fra_layout, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }
}
