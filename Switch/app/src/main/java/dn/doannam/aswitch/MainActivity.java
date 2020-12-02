package dn.doannam.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch wifi;
    CheckBox cb;
    Button btn;
    RadioGroup radio;
    String x = "Hi";
    ProgressBar prbar;
    void AnhXa()
    {
        btn = (Button)findViewById(R.id.check);
        cb = (CheckBox)findViewById(R.id.java);
        wifi = (Switch)findViewById(R.id.switch1);
        radio = (RadioGroup) findViewById(R.id.radiogr);
        prbar =(ProgressBar) findViewById(R.id.progressBar);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         AnhXa();
        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "Wifi On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "You have chosen Java", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "You have unchecked Java", Toast.LENGTH_SHORT).show();
                }
            }
        });
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.Hi :
                        Toast.makeText(MainActivity.this, "You have chosen Hi", Toast.LENGTH_SHORT).show();
                        x = "Hi";
                        break;
                    case  R.id.He:
                        Toast.makeText(MainActivity.this, "You have chosen He", Toast.LENGTH_SHORT).show();
                        x ="He";
                        break;
                    case R.id.cmmm:
                        x = "mm";
                        Toast.makeText(MainActivity.this, "You have chosen cmmm", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CountDownTimer countDownTimer = new CountDownTimer(16000,1000) {
                    @Override
                    public void onTick(long l) {
                        int current = prbar.getProgress();
                        prbar.setProgress(current+10);
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Download completed", Toast.LENGTH_SHORT).show();
                    }
                }.start();

                String str ="You have chosen " + x;
                if(cb.isChecked())
                {
                    Toast.makeText(MainActivity.this, str + " and Java", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "You haven't chosen a subject", Toast.LENGTH_SHORT).show();
            }
        });
    }
}