package ua.ho.tolkachov.misha.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        TextView infoTextView = (TextView)findViewById(R.id.TextView);
        switch (itemId) {
            case R.id.action_settings:
                infoTextView.setText("you selected SETTINGS");
                return true;
            case R.id.action_man:
                infoTextView.setText("you selected MAN");
                return true;
            case R.id.action_femail:
                infoTextView.setText("you selected WOMAN");
                return true;
            case R.id.action_child:
                infoTextView.setText("you selected KID");
                Toast.makeText(MainActivity.this, "you selected KID", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSettingsMenuClick(MenuItem item) {
        Toast.makeText(MainActivity.this, "you selected SETTINGS", Toast.LENGTH_SHORT).show();
    }
}
