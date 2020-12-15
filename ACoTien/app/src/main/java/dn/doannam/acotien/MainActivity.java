package dn.doannam.acotien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
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
    public static final String USER="";
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
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://acotien.com/system/login";
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getString("status")=="true")
                    {
                        Toast.makeText(MainActivity.this,jsonObject.getString("msg"),Toast.LENGTH_LONG).show();
                        Thread.sleep(3000);
                        Intent intent = new Intent(MainActivity.this,Cookie.class);
                        intent.putExtra(USER,user);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,jsonObject.getString("msg"),Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
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