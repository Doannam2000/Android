package com.example.btvn_listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> contactList;
    Contact contact1, contact2, contact3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        contactList = new ArrayList<>();
        contact1 = new Contact("Nguyễn Anh Linh","HaUI","123","Abcxyz","333","Like","555","Studen code",R.drawable.avt01, R.drawable.radius_one);
        contact2 = new Contact("Vũ Văn Doan","HaUI","123","Abcxyz","333","Like","555","Studen code",R.drawable.avt02,R.drawable.radius_two);
        contact3 = new Contact("Nguyễn Đức Điệp","HaUI","123","Abcxyz","333","Like","555","Studen code",R.drawable.avt03, R.drawable.radius_three);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
         ListView listView = findViewById(R.id.lvcontact);
        AdapterContact adapterContact = new AdapterContact(contactList);

        listView.setAdapter(adapterContact);


    }
}