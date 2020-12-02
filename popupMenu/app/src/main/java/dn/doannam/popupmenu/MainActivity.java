package dn.doannam.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu();
            }
        });
    }

    private void popupMenu()
    {
        PopupMenu popupMenu =new PopupMenu(this,button);
        popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.first:
                        button.setText("First");
                        break;

                    case R.id.second:
                        button.setText("Second");
                        break;

                    case R.id.third:
                        button.setText("Third");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}