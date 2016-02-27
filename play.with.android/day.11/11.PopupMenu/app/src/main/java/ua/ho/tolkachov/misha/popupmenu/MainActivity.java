package ua.ho.tolkachov.misha.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        TextView textView = (TextView)findViewById(R.id.textView1);
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);

        button.setOnClickListener(viewOnClickListener);
        textView.setOnClickListener(viewOnClickListener);
        imageView.setOnClickListener(viewOnClickListener);
    }

    View.OnClickListener viewOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(), "Menu 1 selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "Menu 2 selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "Menu 3 selected", Toast.LENGTH_LONG).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu){
                Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }
}
