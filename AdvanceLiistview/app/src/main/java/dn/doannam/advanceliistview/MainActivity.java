package dn.doannam.advanceliistview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<TraiCay> ListTC;
    TraiCayAdapter traiCayAdapter;
    void AnhXa()
    {
        listview = (ListView) findViewById(R.id.listview1);
        ListTC = new ArrayList<>();

        ListTC.add(new TraiCay("Đồng hồ 1","Nhìn khá ổn mà đắt vcl",R.drawable.dongho1));
        ListTC.add(new TraiCay("Đồng hồ 2","Có người yêu không mà đòi mua",R.drawable.dongho2));
        ListTC.add(new TraiCay("Đồng hồ 3","Thôi m không có tiền mua đâu",R.drawable.dongho3));
        ListTC.add(new TraiCay("Đồng hồ 1","Nhìn khá ổn mà đắt vcl",R.drawable.dongho1));
        ListTC.add(new TraiCay("Đồng hồ 2","Có người yêu không mà đòi mua",R.drawable.dongho2));
        ListTC.add(new TraiCay("Đồng hồ 3","Thôi m không có tiền mua đâu",R.drawable.dongho3));
        ListTC.add(new TraiCay("Đồng hồ 1","Nhìn khá ổn mà đắt vcl",R.drawable.dongho1));
        ListTC.add(new TraiCay("Đồng hồ 2","Có người yêu không mà đòi mua",R.drawable.dongho2));
        ListTC.add(new TraiCay("Đồng hồ 3","Thôi m không có tiền mua đâu",R.drawable.dongho3));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AnhXa();

        traiCayAdapter = new TraiCayAdapter(this,R.layout.layout_trai_cay,ListTC);
        listview.setAdapter(traiCayAdapter);

    }
}