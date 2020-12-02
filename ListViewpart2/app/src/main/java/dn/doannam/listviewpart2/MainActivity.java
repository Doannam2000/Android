package dn.doannam.listviewpart2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    AdapterDongHo adapterDongHo;
    ArrayList<DongHo> arrayList;

    void AnhXa()
    {
        listview = (ListView)findViewById(R.id.ListView1);
        arrayList = new ArrayList<>();
        arrayList.add(new DongHo("Đồng hồ 1","Nhìn chán thế",R.drawable.dongho1));
        arrayList.add(new DongHo("Đồng hồ 2","Nhìn chán thế",R.drawable.dongho2));
        arrayList.add(new DongHo("Đồng hồ 3","Nhìn chán thế",R.drawable.dongho3));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        AnhXa();

        adapterDongHo = new AdapterDongHo(this, R.layout.layoutlistview,arrayList);
        listview.setAdapter(adapterDongHo);

    }
}