package ua.ho.tolkachov.misha.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        Toast.makeText(getApplicationContext(), "POPUP", Toast.LENGTH_LONG).show();


    }
}
