package dn.doannam.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList array;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.Listview);
        array = new ArrayList();
        AddArrayList();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Xoa(i);
                return false;
            }
        });
    }
    void Xoa(final int a)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setMessage("Bạn có muốn xóa " + array.get(a).toString() + " không ?");
        alertDialog.setPositiveButton("Có ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                array.remove(a);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    void AddArrayList()
    {
        array.add("Hi");
        array.add("Ha");
        array.add("Hu");
        array.add("Hư");
        array.add("Ho");
        array.add("He");
    }
}