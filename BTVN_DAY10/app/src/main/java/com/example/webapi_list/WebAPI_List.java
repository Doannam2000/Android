package com.example.webapi_list;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webapi_list.databinding.WebapiListBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WebAPI_List extends Fragment {
    List<Contact> contacts22;
    WebapiListBinding binding;
    ContactAdapter contactAdapter;
    Contact contact1;
    RecyclerView recyclerView;
    String urlAPI = "http://demo1913415.mockable.io/GetCategory";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.webapi_list, container, false);
//         contacts22 = new ArrayList<>();
//        contact1 = new Contact(1,1,1,1,"1","1",1,1,1,1,"1","1",1,1);
//        contacts22.add(contact1);
//
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false);
//
//        contactAdapter = new ContactAdapter(contacts22);
//
//        binding.Rclist.setLayoutManager(layoutManager);
//        binding.Rclist.setAdapter(contactAdapter);


        new DoGetData().execute();


        return binding.getRoot();


    }

    public static WebAPI_List newInstance() {

        Bundle args = new Bundle();

        WebAPI_List fragment = new WebAPI_List();
        fragment.setArguments(args);
        return fragment;
    }

    class DoGetData extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Contact> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    int publisher_id = jsonObject.getInt("publisher_id");
                    int content_type = jsonObject.getInt("content_type");
                    int tab = jsonObject.getInt("tab");
                    String title = jsonObject.getString("title");
                    String avatar = jsonObject.getString("avatar");
                    int status = jsonObject.getInt("status");
                    int deleted = jsonObject.getInt("deleted");
                    int user_created = jsonObject.getInt("user_created");
                    int user_modified = jsonObject.getInt("user_modified");
                    String date_created = jsonObject.getString("date_created");
                    String date_modified = jsonObject.getString("date_modified");
                    int parent_id = jsonObject.getInt("parent_id");
                    int lft = jsonObject.getInt("lft");
                    String thumb = jsonObject.getString("thumb");

                    contacts.add(new Contact(id, publisher_id, content_type, tab, title, avatar,
                            status, deleted, user_created, user_modified, date_created, date_modified, parent_id, lft, thumb));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);

                contactAdapter = new ContactAdapter(getContext(), contacts);
                binding.Rclist.setLayoutManager(layoutManager);
                binding.Rclist.setAdapter(contactAdapter);

            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute(aVoid);
        }
    }
}
