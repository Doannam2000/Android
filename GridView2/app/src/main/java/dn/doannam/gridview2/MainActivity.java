package dn.doannam.gridview2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    AdapterHinhAnh adapterHinhAnh;
    ArrayList<HinhAnh> listHinhAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridView = (GridView)findViewById(R.id.gridView1);
        listHinhAnh = new ArrayList<>();

        listHinhAnh.add(new HinhAnh("hi1",R.drawable.hi1));
        listHinhAnh.add(new HinhAnh("hi2",R.drawable.hi2));
        listHinhAnh.add(new HinhAnh("hi3",R.drawable.hi3));
        listHinhAnh.add(new HinhAnh("hi4",R.drawable.hi14));
        listHinhAnh.add(new HinhAnh("hi5",R.drawable.hi5));
        listHinhAnh.add(new HinhAnh("hi6",R.drawable.hi16));
        listHinhAnh.add(new HinhAnh("hi7",R.drawable.hi7));
        listHinhAnh.add(new HinhAnh("hi8",R.drawable.hi8));
        listHinhAnh.add(new HinhAnh("hi19",R.drawable.hi9));

        adapterHinhAnh = new AdapterHinhAnh(this, R.layout.hinhanhgrid,listHinhAnh);
        gridView.setAdapter(adapterHinhAnh);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this , listHinhAnh.get(i).getTen(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}