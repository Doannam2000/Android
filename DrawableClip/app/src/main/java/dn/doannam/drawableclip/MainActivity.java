package dn.doannam.drawableclip;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        imageView = (ImageView)findViewById(R.id.anh);
        imageView.setImageLevel(1000);
        button =(Button)findViewById(R.id.btn);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int time = clipDrawable.getLevel();
                        if(time >10000)
                              time = 0;
                        imageView.setImageLevel(time +1000);
                        handler.postDelayed(this,1000);
                    }
                },2000);
            }
        });

    }
}