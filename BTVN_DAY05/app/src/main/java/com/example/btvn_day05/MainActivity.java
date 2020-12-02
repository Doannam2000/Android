package com.example.btvn_day05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts;
    Contact contact1, contact2, contact3, contact4, contact5;
    RecyclerView recyclerView;
    Adapter contactAdapterDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvlist);

        contacts = new ArrayList<>();

        contact1 = new Contact("Mr A", "0912333333");
        contact2 = new Contact("Mr B", "0912334444");
        contact3 = new Contact("Mr C", "0912355555");
        contact4 = new Contact("Mr D", "0912336666");
        contact5 = new Contact("Mr E", "0912339999");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL, false);

//        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getBaseContext(),2,RecyclerView.VERTICAL,false);

        contactAdapterDemo = new Adapter(contacts);

        contactAdapterDemo.setOnclick(new Onclick() {
            @Override
            public void onClickName(String name) {
                Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG).show();
            }


        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapterDemo);

        loginApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(passWord.getText().length() < 8)
//                {
//                    Toast.makeText(getApplicationContext(),"MK phải có ít nhất 8 ký tự",Toast.LENGTH_LONG).show();
//                    //Toast.makeText(getBaseContext(),"MK phải có ít nhất 8 ký tự",Toast.LENGTH_LONG).show();
//                }
                Intent intent = new Intent(getBaseContext(), Food_Order.class);
                startActivityForResult(intent,1);
            }
        });

    }



}
