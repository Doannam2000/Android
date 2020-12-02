package dn.doannam.switchlanguage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView,txtThongTin;
    EditText editTextHoten,editTextSDT,editTextEmail;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = (TextView)findViewById(R.id.textView);
        txtThongTin =(TextView)findViewById(R.id.textView2);
        editTextEmail =(EditText)findViewById(R.id.etxtemail);
        editTextHoten=(EditText)findViewById(R.id.etxtHoten);
        editTextSDT = (EditText)findViewById(R.id.etxtSdt);
        button =(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Hoten = editTextHoten.getText().toString();
                String Email = editTextEmail.getText().toString();
                String SDT = editTextSDT.getText().toString();
                String Hello = getResources().getString(R.string.text_Hello);
                String email = getResources().getString(R.string.text_Email);
                String sdt = getResources().getString(R.string.text_SDT);
                txtThongTin.setText(Hello + " "+Hoten + "\n"+ email + ": " +Email + "\n" + sdt + ": " +SDT);
            }
        });
    }
}