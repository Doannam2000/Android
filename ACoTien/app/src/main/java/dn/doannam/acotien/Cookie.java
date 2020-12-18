package dn.doannam.acotien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Cookie extends AppCompatActivity {

    Button OK,guide;
    EditText cookie;
    final public static String COOKIE="cookie";
    final public static String User1 = "ten";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        OK = (Button)findViewById(R.id.Ok);
        guide = ( Button)findViewById(R.id.guide);
        cookie =(EditText) findViewById(R.id.cookie);
        final Intent intent = getIntent();
        cookie.setHint("Nhập Cookie nick Acotien "+intent.getStringExtra(MainActivity.USER));
        final String user = intent.getStringExtra(MainActivity.USER);
        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Cookie.this,Guide.class);
                startActivity(intent1);
            }
        });
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Cookie.this,NickFB.class);
                intent1.putExtra(User1,user);
                intent1.putExtra(COOKIE,cookie.getText().toString());
                startActivity(intent1);
            }
        });
    }
}