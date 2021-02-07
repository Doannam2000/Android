package com.example.thngbopiny;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.MissingFormatArgumentException;

public class MainActivity<x> extends AppCompatActivity {

    Button btnCaiDat,btnHenGio;
    TextView tvPinCaiDat;
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
                            Intent intent = new Intent(MainActivity.this,Battery.class);
                            intent.putExtra("percent",Integer.parseInt(tvPin.getText().toString().substring(0,2)));
                            intent.putExtra("ch",true);
                            dialog.dismiss();
                            PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
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
                else {
                    Intent intent = new Intent(MainActivity.this,Battery.class);
                    intent.putExtra("percent",0);
                    intent.putExtra("ch",true);
                    PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
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
                Toast.makeText(MainActivity.this,"Hiện tại đang lười làm chức năng này",Toast.LENGTH_LONG).show();
            }
        });

    }



}