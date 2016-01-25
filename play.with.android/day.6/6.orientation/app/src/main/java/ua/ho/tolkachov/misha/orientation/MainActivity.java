package ua.ho.tolkachov.misha.orientation;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
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

    private String getScreenOrientation(){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Landscape Orientation";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Portrait Orientation";
        else return "Unknown";
    }

    private String getRotationOrientation(){
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "Did Not Rotate";
            case Surface.ROTATION_90:
                return "Turned 90 degrees clockwise";
            case Surface.ROTATION_180:
                return "Turned 180 degrees";
            case Surface.ROTATION_270:
                return "Turned 90 degrees counterclockwise";
            default:
                return "Not Clear";
        }
    }

    public void onButtonClick(View view){
        TextView editText = (TextView)findViewById(R.id.editText1);

        if (view.getId() == findViewById(R.id.button1).getId())
            editText.setText(getScreenOrientation());
        else if (view.getId() == findViewById(R.id.button2).getId())
            editText.setText(getRotationOrientation());
        else if (view.getId() == findViewById(R.id.button3).getId())
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        else if (view.getId() == findViewById(R.id.button4).getId())
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
    }

}
