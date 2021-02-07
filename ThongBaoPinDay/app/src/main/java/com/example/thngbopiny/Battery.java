package com.example.thngbopiny;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Battery extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        TextView tvTrangThai =((MainActivity)context).findViewById(R.id.trangThai);
        TextView pin = ((MainActivity)context).findViewById(R.id.tSoPin);
        ImageView anhpin = ((MainActivity)context).findViewById(R.id.anh);
        String action = intent.getAction();
        Intent intent1 = new Intent(context, ThongBao.class);
        int p = intent.getIntExtra("percent",-1);
        boolean ch = intent.getBooleanExtra("ch",false);
        if(action!= null && action.equals(intent.ACTION_BATTERY_CHANGED))
        {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            String x ="";
            switch (status)
            {
                case BatteryManager.BATTERY_STATUS_FULL:
                    x = "Đã Đầy";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    x = "Đang Sạc";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    x = "Tình Trạng Pin";
                    break;
                case  BatteryManager.BATTERY_STATUS_DISCHARGING:
                    x = "Đã Rút Sạc";
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    x = "Unkown";
            }
            tvTrangThai.setText(x);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int percentage = level * 100 / scale;
            pin.setText(percentage + "%");

            if (percentage >= 90) {
                anhpin.setImageDrawable(context.getResources().getDrawable(R.drawable.b100));

            } else if (90 > percentage && percentage >= 65) {
                anhpin.setImageDrawable(context.getResources().getDrawable(R.drawable.b75));

            } else if (65 > percentage && percentage >= 40) {
                anhpin.setImageDrawable(context.getResources().getDrawable(R.drawable.b50));

            } else if (40 > percentage && percentage >= 15) {
                anhpin.setImageDrawable(context.getResources().getDrawable(R.drawable.b25));

            } else {
                anhpin.setImageDrawable(context.getResources().getDrawable(R.drawable.b0));
            }
        }
        if (Integer.parseInt(pin.getText().toString().substring(0,2)) >= p && ch == true)
        {
            context.startService(intent1);
            ch = false;
        }
        if(p == 0 && ch == false)
        {
            context.stopService(intent1);
        }
    }
}
