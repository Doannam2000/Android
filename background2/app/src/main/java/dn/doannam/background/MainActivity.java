package dn.doannam.background;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RelativeLayout anh;
    ArrayList<Integer> Array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anh =(RelativeLayout)findViewById(R.id.hinhnen);
        Array.add(R.drawable.bg1);
        Array.add(R.drawable.bg2);
        Array.add(R.drawable.bg3);
        Array.add(R.drawable.bg4);
        Random random = new Random();

        int vt = random.nextInt(Array.size());

        anh.setBackgroundResource(Array.get(vt));
    }
}