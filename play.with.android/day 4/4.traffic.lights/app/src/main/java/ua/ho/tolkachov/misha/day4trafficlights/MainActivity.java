package ua.ho.tolkachov.misha.day4trafficlights;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private RelativeLayout mRelativeLayout;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);
        mTextView = (TextView)findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onButtonClick(View view) {
        int colorValue = 0;

        switch (view.getId()){
            case R.id.buttonRed:
                mTextView.setText(R.string.red);
                colorValue = getResources().getColor(R.color.redColor);
                break;
            case R.id.buttonYellow:
                mTextView.setText(R.string.yellow);
                colorValue = getResources().getColor(R.color.yellowColor);
                break;
            case R.id.buttonGreen:
                mTextView.setText(R.string.green);
                colorValue = getResources().getColor(R.color.greenColor);
                break;
        }

        mRelativeLayout.setBackgroundColor(colorValue);
    }
}
