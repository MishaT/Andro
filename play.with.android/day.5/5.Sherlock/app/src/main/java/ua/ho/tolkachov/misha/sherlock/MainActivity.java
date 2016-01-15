package ua.ho.tolkachov.misha.sherlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    static private final int CHOOSE_THIEF = 0;

    public void onClick(View view) {
        Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
        startActivityForResult(quizIntent, CHOOSE_THIEF);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView infoTextView = (TextView)findViewById(R.id.textViewInfo);

        if (requestCode == CHOOSE_THIEF){
            if (resultCode == RESULT_OK){
                String thiefName = data.getStringExtra(QuizActivity.THIEF);
                infoTextView.setText(thiefName);
            } else {
                infoTextView.setText("");
            }
        }
    }


    public static final String ACTION_SECOND_ACTIVITY = "ua.ho.tolkachov.misha.sherlock.SECOND";

    public void onClickFilter(View view) {
        startActivity(new Intent(ACTION_SECOND_ACTIVITY));

    }
}
