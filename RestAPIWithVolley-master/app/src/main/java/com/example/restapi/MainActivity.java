package com.example.restapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    static TextView textView;
    //static ArrayList<Phone> list = new ArrayList<Phone>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnget = findViewById(R.id.btnget);
        textView = findViewById(R.id.txtView);
        //list.add(new Phone("1","1","1","1","1"));
//        String url = "https://bookshopb.herokuapp.com/api/books";
//        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//                try {
//                    textView.setText(response.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("Loi r");
//            }
//        });
//        requestQueue.add(request);
//        btnget.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText(list.get(0).getId());
//            }
//        });

        //textView.setText(list.get(0).getId().toString()+list.get(0).getName().toString());
//        for(int i=0; i<data.length(); i++){
//            try {
//                JSONObject jsonObject = (JSONObject) data.get(i);
//                Phone phone = new Phone(jsonObject.get("_id").toString(),jsonObject.get("name").toString(),jsonObject.get("description").toString(),jsonObject.get("price").toString(),jsonObject.get("total").toString());
//                list.add(phone);
//            } catch (JSONException e) {
//                Log.i("Error",e.getMessage());
//            }
//        }

        //GET
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://bookshopb.herokuapp.com/api/books";
                StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            textView.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Loi r");
                    }
                });
                requestQueue.add(stringRequest);
            }

        });

        //POST
        Button btnpost = findViewById(R.id.btnpost);
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id", 14);
                    jsonObject.put( "imageLink", "https://res.cloudinary.com/yami177/image/upload/v1600623930/conbo_frlfcg.jpg");
                    jsonObject.put("title", "Ngày Xưa Có Một Con Bò...");
                    jsonObject.put("author", "Camilo Cruz");
                    jsonObject.put("publisher", "NXB Trẻ");
                    jsonObject.put("releaseYear", 2016);
                    jsonObject.put("numOfPage", 148);
                    jsonObject.put("price", 49000);
                    jsonObject.put("description", "Dù muốn dù không thì trong mỗi người chúng ta đều đang nuôi ít nhất là 1 con bò và thậm chí là cả đàn bò. Đó là những con bò: bao biện, viện cớ, đổ lỗi, ỷ lại, mãi tự hào với quá khứ…");
                    jsonObject.put("categoty", "Sách thiếu niên");
                    jsonObject.put("rateStar", 0);
                    jsonObject.put("numOfReview",0);
                }catch(JSONException e){
                    e.printStackTrace();
                }
                    final String mrequestbody = jsonObject.toString();
                    String url = "https://bookshopb.herokuapp.com/api/books";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            textView.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textView.setText("Loi r");
                        }
                    }) {
                        //xu li du lieu cho body

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                if(mrequestbody==null){
                                    return null;
                                }
                                else{
                                    return mrequestbody.getBytes("utf-8");
                                }
                            }catch (Exception e){
                                e.getMessage();
                                return null;
                            }
                        }
                    };
                    requestQueue.add(stringRequest);

                }
        });

        //PUT
        Button btnput = findViewById(R.id.btnput);
        btnput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("_id","5ec3f97e6217fd21386453d4");
                    jsonObject.put("name", "Con cac");
                    jsonObject.put("description", "Abbcbcbcbcbcbcbcb");
                    jsonObject.put("price", "9999");
                    jsonObject.put("total", "1");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                    final String mrequestbody = jsonObject.toString();
                    String url = "http://hdk-shop.herokuapp.com/api/products";
                    StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            textView.setText(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textView.setText("Loi r");
                        }
                    }) {
                        //xu li du lieu cho body

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                if(mrequestbody==null){
                                    return null;
                                }
                                else{
                                    return mrequestbody.getBytes("utf-8");
                                }
                            }catch (Exception e){
                                e.getMessage();
                                return null;
                            }
                        }
                    };
                    requestQueue.add(stringRequest);

            }
        });

        //DELETE
        Button btndelete = findViewById(R.id.btndelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                String url = "https://bookshopb.herokuapp.com/api/book/18";
                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText("Xóa thành công: "+response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Loi r");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }//endcreate




}
