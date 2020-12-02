package dn.doannam.listview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView view;
    EditText tview;
    Button btn,btnupdate;
    ArrayList<String> Array;
    int b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        view = (ListView)findViewById(R.id.Listview);
        btn = (Button)findViewById(R.id.button);
        tview = (EditText) findViewById(R.id.textview);
        btnupdate =(Button)findViewById(R.id.update);

        Array = new ArrayList();
        Array.add("Android");
        Array.add("Java");
        Array.add("C++");
        Array.add("PHP");
        Array.add("HTML");
        Array.add("Python");
        final ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                Array
        );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Array.add(tview.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        view.setAdapter(arrayAdapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tview.setText(Array.get(i));
                b = i;
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Array.set(b,tview.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });
        view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You have just deleted " + Array.get(i), Toast.LENGTH_SHORT).show();
                Array.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}