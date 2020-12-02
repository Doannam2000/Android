package dn.doannam.gamemini;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar luffy,naruto,songuku;
    CheckBox cbluffy,cbnaruto,cbsonguku;
    ImageButton play;
    TextView tvdiem;
    void AnhXa()
    {
        tvdiem      =(TextView)findViewById(R.id.diem);
        luffy       =(SeekBar)findViewById(R.id.Seekbar2);
        naruto      =(SeekBar)findViewById(R.id.Seekbar3);
        songuku     =(SeekBar)findViewById(R.id.Seekbar1);
        cbluffy     =(CheckBox)findViewById(R.id.Cb2);
        cbnaruto    =(CheckBox)findViewById(R.id.Cb3);
        cbsonguku   =(CheckBox)findViewById(R.id.Cb1);
        play        =(ImageButton)findViewById(R.id.btnplay);
    }
    void enable()
    {
        cbnaruto.setEnabled(true);
        cbluffy.setEnabled(true);
        cbsonguku.setEnabled(true);
    }
    void enablefalse()
    {
        cbnaruto.setEnabled(false);
        cbluffy.setEnabled(false);
        cbsonguku.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AnhXa();
        luffy.setEnabled(false);
        naruto.setEnabled(false);
        songuku.setEnabled(false);
        final CountDownTimer countDownTimer = new CountDownTimer(30000,300) {
            @Override
            public void onTick(long l) {
                if(luffy.getProgress() >= luffy.getMax() )
                {
                    int diem = 0;
                    Toast.makeText(MainActivity.this, "Luffy win", Toast.LENGTH_SHORT).show();
                    play.setVisibility(View.VISIBLE);
                    this.cancel();;
                    if(cbluffy.isChecked())
                    {
                        Toast.makeText(MainActivity.this, "Congratulation\n" +
                                "You get an additional 10 points", Toast.LENGTH_SHORT).show();
                        diem = 10;
                    }
                    else
                    {
                        diem = -20;
                        Toast.makeText(MainActivity.this, "You lose\n" +
                                "You are deducted 20 points", Toast.LENGTH_SHORT).show();
                    }
                    tvdiem.setText(Integer.parseInt(tvdiem.getText().toString()) + diem +"");
                    enable();

                }
                if(naruto.getProgress() >= naruto.getMax() )
                {
                    int diem ;
                    Toast.makeText(MainActivity.this, "Naruto win", Toast.LENGTH_SHORT).show();
                    play.setVisibility(View.VISIBLE);
                    this.cancel();;
                    if(cbnaruto.isChecked())
                    {
                        Toast.makeText(MainActivity.this, "Congratulation\n" +
                                "You get an additional 10 points", Toast.LENGTH_SHORT).show();
                      diem =10;
                    }
                    else
                    {

                        Toast.makeText(MainActivity.this, "You lose\n" +
                                "You are deducted 20 points", Toast.LENGTH_SHORT).show();
                        diem = -20;
                    }
                    tvdiem.setText(Integer.parseInt(tvdiem.getText().toString()) + diem +"");
                    enable();
                }
                if(songuku.getProgress() >= songuku.getMax() )
                {
                    int diem;
                    Toast.makeText(MainActivity.this, "Songuku win", Toast.LENGTH_SHORT).show();
                    play.setVisibility(View.VISIBLE);
                    this.cancel();;
                    if(cbsonguku.isChecked())
                    {
                        Toast.makeText(MainActivity.this, "Congratulation\n" +
                                "You get an additional 10 points", Toast.LENGTH_SHORT).show();
                        diem =10;
                    }
                    else
                    {
                        diem =-5;
                        Toast.makeText(MainActivity.this, "You lose\n" +
                                "You are deducted 20 points", Toast.LENGTH_SHORT).show();
                    }
                    tvdiem.setText(Integer.parseInt(tvdiem.getText().toString()) + diem +"");
                    enable();
                }
                Random random = new Random();
                luffy.setProgress( luffy.getProgress() + random.nextInt(5));
                naruto.setProgress( naruto.getProgress() +random.nextInt(5));
                songuku.setProgress(songuku.getProgress() +random.nextInt(5));
            }

            @Override
            public void onFinish() {

            }
        };
        cbsonguku.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbluffy.setChecked(false);
                cbnaruto.setChecked(false);
            }
        });
        cbluffy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbnaruto.setChecked(false);
                cbsonguku.setChecked(false);
            }
        });
        cbnaruto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbluffy.setChecked(false);
                cbsonguku.setChecked(false);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvdiem.getText().equals("0"))
                {
                    Toast.makeText(MainActivity.this, "You are out of points", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (cbluffy.isChecked() || cbnaruto.isChecked() || cbsonguku.isChecked())
                    {
                        play.setVisibility(View.INVISIBLE);
                        luffy.setProgress(0);
                        naruto.setProgress(0);
                        songuku.setProgress(0);
                        enablefalse();
                        countDownTimer.start();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "You must select at least one option", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}