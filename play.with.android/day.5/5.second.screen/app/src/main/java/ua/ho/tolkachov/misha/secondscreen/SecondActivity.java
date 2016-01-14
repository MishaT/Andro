package ua.ho.tolkachov.misha.secondscreen;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String user = "Animal";
        String gift = "donut hole";
        String sender = "Nobody";


        user = getIntent().getExtras().getString("username");
        gift = getIntent().getExtras().getString("gift");
        sender = getIntent().getStringExtra("sender");

        TextView textView = (TextView)findViewById(R.id.infoTextView);
        textView.setText(user + ", you have got a " + gift + "\n\n" + sender);
    }

}
