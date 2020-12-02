package dn.doannam.testcode;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    TextView txtNoiDung,number,minn,maxx;
    int n =0;
    RelativeLayout anh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNoiDung =(TextView) findViewById(R.id.TextView1);
        btnClick = (Button) findViewById(R.id.button1);
        number = (TextView) findViewById(R.id.Number1);
        minn = (TextView) findViewById(R.id.min);
        maxx = (TextView) findViewById(R.id.max);
       anh = (RelativeLayout) findViewById(R.id.imageView);
        anh.setBackgroundResource(R.drawable.android2);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                n++;
                if(minn.getText().toString().trim().equals("") || maxx.getText().toString().trim().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Vui lòng nhập đủ bằng thông tin",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int min = Integer.parseInt(minn.getText().toString());
                    int max =Integer.parseInt(maxx.getText().toString());
                    Random random = new Random();
                    if(min>max)
                    {
                        int p = min;
                        min = max;
                        max = p;
                    }
                    number.setText(random.nextInt(max - min +1) + min +"");
                    if(n%2==0)
                    { txtNoiDung.setText("Trần Thị Quỳnh Hoa");
                        anh.setBackgroundResource(R.drawable.android);}
                    else
                    {
                        anh.setBackgroundResource(R.drawable.android2);
                        txtNoiDung.setText("Đoàn Duy Nam");
                    }
                }
            }
        });
    }
}