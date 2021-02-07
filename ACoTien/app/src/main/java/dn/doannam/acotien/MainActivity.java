package dn.doannam.acotien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button Login,Registration,infor,cancel;
    EditText user,passw;
    public static final String USER="a";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AnhXa();
        //DangKy
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://acotien.com/reg?gioithieu=nammmo"));
                startActivity(intent);
            }
        });
        //Thong tin
        infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThongTin.class);
                startActivity(intent);
            }
        });

        //HUY

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setText("");
                passw.setText("");
            }
        });

        // LOGIN
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("") || passw.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập đủ thông tin !!!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Login(user.getText().toString(),passw.getText().toString());
                }
            }
        });
    }

    private void Login(final String user, final String passw) {
        final ProgressDialog loading = new ProgressDialog(MainActivity.this);
        loading.show();
        loading.setContentView(R.layout.process);
        loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://www.acotien.com/system/login";
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getString("status")=="true")
                    {
                        Thread.sleep(3000);
                        Intent intent = new Intent(MainActivity.this,Cookie.class);
                        intent.putExtra(USER,user.substring(0,1).toUpperCase()+user.substring(1));
                        loading.dismiss();
                        Toast.makeText(MainActivity.this,jsonObject.getString("msg"),Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else
                    {
                        loading.dismiss();
                        Toast.makeText(MainActivity.this,jsonObject.getString("msg"),Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e)
                {
                    loading.dismiss();
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    loading.dismiss();
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        loading.dismiss();
                        Toast.makeText(MainActivity.this,"Không được rồi",Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            public Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("user", user);
                params.put("pass", passw);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void AnhXa()
    {
        Login = (Button) findViewById(R.id.dangNhap);
        Registration = (Button) findViewById(R.id.dangKy);
        infor = (Button) findViewById(R.id.thongTin);
        cancel = (Button) findViewById(R.id.huy);
        this.user = (EditText) findViewById(R.id.username);
        this.passw = (EditText) findViewById(R.id.password);
    }
}