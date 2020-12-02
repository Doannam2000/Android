package dn.doannam.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
    }
        public boolean onCreateOptionsMenu(Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuSetting:
                Toast.makeText(this,"You chosen Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuProfile:
                Toast.makeText(this,"You chosen Profile",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2hi:
                Toast.makeText(this,"You chosen view - hi",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2ha:
                Toast.makeText(this,"You chosen view - ha",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}