package com.example.thngbopiny;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity<x> extends AppCompatActivity {

    Button btnCaiDat,btnHenGio;
    TextView tvPinCaiDat;
    private Battery battery = new Battery();
    private IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    boolean check = false;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnCaiDat       = findViewById(R.id.caiDat);
        btnHenGio       = findViewById(R.id.henGio);
        tvPinCaiDat     = findViewById(R.id.pinCaiDat);
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        check = sharedPreferences.getBoolean("checked",false);
        if (check == false)
            btnCaiDat.setText("Cài Đặt");
        else
            btnCaiDat.setText("STOP");
        btnCaiDat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(check == false)
                {
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.activity_setting);
                    dialog.setCanceledOnTouchOutside(false);

                    TextView tvPin  = dialog.findViewById(R.id.luongpin);
                    SeekBar sbPin   = dialog.findViewById(R.id.seekBar);
                    Button btnOK    = dialog.findViewById(R.id.ok);
                    Button btnHuy   = dialog.findViewById(R.id.huy);
                    tvPin.setText(sbPin.getProgress() +"%");


                    sbPin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            int pro = progress;
                            tvPin.setText(pro+"%");
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            Toast.makeText(MainActivity.this, "Cài đặt lượng pin cần thông báo", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            Toast.makeText(MainActivity.this, "Pin đạt " + tvPin.getText()+" sẽ thông báo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tvPinCaiDat.setText("Lượng pin đạt "+tvPin.getText() +" sẽ thông báo");
                            battery.Betery(Integer.parseInt(tvPin.getText().toString().substring(0,2)),true);
                            dialog.dismiss();
                        }
                    });
                    btnHuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                    btnCaiDat.setText("STOP");
                    check = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("checked",true);
                    editor.commit();
                }
                else
                    {
                    battery.Betery(0,false);
                    btnCaiDat.setText("Cài Đặt");
                    check = false;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("checked",false);
                    editor.commit();
                }
            }
        });

        btnHenGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Chức năng này tạm thời đang lười làm",Toast.LENGTH_LONG).show();
            }
        });
        registerReceiver(battery, intentFilter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(battery, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        registerReceiver(battery, intentFilter);
    }
}