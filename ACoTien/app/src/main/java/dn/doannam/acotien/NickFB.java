package dn.doannam.acotien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.security.PublicKey;
import java.sql.NClob;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static dn.doannam.acotien.R.drawable.*;

public class NickFB extends AppCompatActivity {

    List<String> datnick = new ArrayList<>();
    List<String> id = new ArrayList<>();
    List<String> Name = new ArrayList<>();
    List<InforNick> Nick = new ArrayList<>();
    String re;
    final ArrayList<TypeJob> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FBAdapter fbAdapter;
    TextView tvnickAuto,tvAllJob,tvsoDu,tvtienDuyet;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_f_b);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ProgressDialog loading = new ProgressDialog(NickFB.this);
        loading.show();
        loading.setContentView(R.layout.process);
        loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        final Intent intent = getIntent();
        final String Cookie = intent.getStringExtra(dn.doannam.acotien.Cookie.COOKIE);
        final String User = intent.getStringExtra(dn.doannam.acotien.Cookie.User1);

        tvtienDuyet = (TextView)findViewById(R.id.choDuyet) ;
        tvsoDu = (TextView)findViewById(R.id.sodu);
        tvAllJob = (TextView)findViewById(R.id.tongJob);
        tvnickAuto = (TextView)findViewById(R.id.tenNickAuto);
        start = (Button)findViewById(R.id.btnstart);
        tvnickAuto.setText("Auto \n"+User);

        String Url = "http://acotien.com/home";
        StringRequest request = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Pattern pattern =Pattern.compile("font-semi-bold current_coin.*?.<");
                Matcher matcher =  pattern.matcher(response);
                while (matcher.find())
                {
                    tvsoDu.setText("Số Dư : "+response.substring(matcher.start()+54,matcher.end()-1));
                    break;
                }
                pattern = Pattern.compile("font-semi-bold pending_coin.*?.<");
                matcher = pattern.matcher(response);
                while (matcher.find())
                {
                    tvtienDuyet.setText("Chờ Duyệt : "+response.substring(matcher.start()+54,matcher.end()-1));
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
            params.put("Cookie", Cookie);
            return params;
        }
        };

        RequestQueue requestQueue1 = Volley.newRequestQueue(NickFB.this);
        requestQueue1.add(request);

        Url = "http://acotien.com/them-nick";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String hi = "datnick\\([0-9]{5,}";
                String nick =  "[0-9]{5,}";
                Pattern pattern = Pattern.compile(hi);
                Matcher matcher;
                matcher = pattern.matcher(response);
                while (matcher.find())
                {
                    datnick.add(response.substring(matcher.start(),matcher.end()));
                }
                pattern = Pattern.compile(nick);
                for(int i =0;i<datnick.size();i++)
                {
                    matcher = pattern.matcher(datnick.get(i));
                    if (matcher.find())
                        id.add(datnick.get(i).substring(matcher.start(),matcher.end()));
                }
                // Image
                String Nam = "b200 font-bold mb-1 font-16\">.*?.<";
                pattern = Pattern.compile(Nam);
                matcher = pattern.matcher(response);
                while (matcher.find())
                {
                    Name.add(response.substring(matcher.start()+29,matcher.end()-2));
                }
                final int Joball=0;
                for (int i = 0;i<Name.size();i++)
                {
                    String x = "https://graph.facebook.com/"+id.get(i)+"/picture?width=100&height=100&access_token=EAAFjSJnETiYBAPtDl3banQFzam9xNl9Fb1eyKQqVBuWgn1kMuLaWDePSf4qschUXBrAADwCLUWg7OJVmk96ibN8oDT3Lurt4y0ZBq1QR9YdopXI4GBcvfAYi55t4LMiYl6lrJWM6eagKlQjTCIZCSQiDKHil0TZBKWBQ3tHv4epJIvPrGuO";
                    Nick.add(new InforNick(id.get(i),Name.get(i),x,0,"Cookie",false,100));
                }
                loading.dismiss();
                recyclerView = (RecyclerView)findViewById(R.id.rvListFB);
                recyclerView.setHasFixedSize(true);
                fbAdapter = new FBAdapter(Nick);
                LinearLayoutManager linearLayout = new LinearLayoutManager(NickFB.this);
                recyclerView.setLayoutManager(linearLayout);
                recyclerView.setAdapter(fbAdapter);

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

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(start.getText().toString().equals("START"))
                {
                    int c = 0;
                    for (int i =0;i<Nick.size();i++)
                    {
                        if(Nick.get(i).isCheck()==true)
                        {
                            c = 1;
                            break;
                        }
                    }
                    if(c == 0)
                    {
                        for (int i =0;i<Nick.size();i++)
                        {
                            Nick.get(i).setCheck(true);
                        }
                        ArrayList<TypeJob> arrayList1 = new ArrayList<>();
                        arrayList1  = ReturnIDJob("http://acotien.com/like-cheo",Cookie);
                        for (int j = 0;j<arrayList1.size();j++)
                        {
                            System.out.println(arrayList1.get(j).getIdJob()+" "+arrayList1.get(j).getTypeJob());
                        }
                    }
                    else
                    {
                        //START AUTO
                        ArrayList<TypeJob> arrayList1 = new ArrayList<>();
                        arrayList1  = ReturnIDJob("http://acotien.com/like-cheo",Cookie);
                        for (int j = 0;j<arrayList1.size();j++)
                        {
                            System.out.println(arrayList1.get(j).getIdJob()+" "+arrayList1.get(j).getTypeJob());
                        }
                    }
                    start.setText("STOP");
                    start.setBackgroundResource(drawstop);
                }
                else
                {
                    for (int i =0;i<Nick.size();i++)
                    {
                        Nick.get(i).setCheck(false);
                        Nick.get(i).setJob(0);
                    }
                    start.setText("START");
                    start.setBackgroundResource(drawsodu);
                }
                fbAdapter = new FBAdapter(Nick);
                recyclerView.setAdapter(fbAdapter);
            }
        });
    }

    public ArrayList<TypeJob> ReturnIDJob(String url,final String Cookie)
    {
        final ArrayList<String> idJob = new ArrayList<>();
        final ArrayList<String> typejob = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String reg = "like\\('[0-9]{5,}";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(response);
                while (matcher.find())
                {
                    idJob.add(response.substring(matcher.start()+6,matcher.end()));
                }
                reg = "font-14 block-text-2.*?.<";
                pattern = Pattern.compile(reg);
                matcher = pattern.matcher(response);
                while (matcher.find())
                {
                    typejob.add(response.substring(matcher.start()+22,matcher.end()-1));
                }
                for (int i = 0;i<idJob.size();i++)
                {
                    arrayList.add(new TypeJob(idJob.get(i),typejob.get(i)));
                }
                for (int i = 0;i<arrayList.size();i++)
                {
                    System.out.println(arrayList.get(i).getIdJob()+" hi  "+arrayList.get(i).getTypeJob());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NickFB.this,"Không thể load job xem lại cookie",Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("Cookie",Cookie);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(NickFB.this);
        requestQueue.add(stringRequest);
        Toast.makeText(NickFB.this,re,Toast.LENGTH_SHORT).show();
        return arrayList;
    }

    public class TypeJob
    {
        private String idJob;
        private String typeJob;

        public TypeJob(String idJob, String typeJob) {
            this.idJob = idJob;
            this.typeJob = typeJob;
        }

        public String getIdJob() {
            return idJob;
        }

        public void setIdJob(String idJob) {
            this.idJob = idJob;
        }

        public String getTypeJob() {
            return typeJob;
        }

        public void setTypeJob(String typeJob) {
            this.typeJob = typeJob;
        }
    }
}