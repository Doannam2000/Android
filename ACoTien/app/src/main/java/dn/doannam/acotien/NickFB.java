package dn.doannam.acotien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
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

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class NickFB extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_f_b);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ProgressDialog loading = new ProgressDialog(NickFB.this);
        loading.show();
        loading.setContentView(R.layout.process);
        loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        final Intent intent = getIntent();
        final String Cookie = intent.getStringExtra(dn.doannam.acotien.Cookie.COOKIE);
        System.out.println(Cookie);
        String Url = "http://acotien.com/them-nick";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    System.out.println(response);
                    Toast.makeText(NickFB.this,response,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NickFB.this,"Bạn có lấy đúng cookie acotien chứ ?",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
                params.put("Accept-Language","vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5");
                params.put("Cache-Control","max-age=0");
                params.put("Connection","keep-alive");
                params.put("Cookie", Cookie);
                params.put("Host","acotien.com");
                params.put("Upgrade-Insecure-Requests","1");
                params.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/91.0.146 Chrome/85.0.4183.146 Safari/537.36");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(NickFB.this);
        requestQueue.add(stringRequest);
    }
}