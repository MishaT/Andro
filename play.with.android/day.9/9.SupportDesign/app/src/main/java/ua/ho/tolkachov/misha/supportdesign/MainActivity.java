package ua.ho.tolkachov.misha.supportdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Snackbar mSnack;

    View.OnClickListener snackOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Toast.makeText(getApplicationContext(), "Good job", Toast.LENGTH_LONG);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnack = Snackbar.make(view, "Go home man!!", Snackbar.LENGTH_INDEFINITE).setAction("Action", null);

                mSnack.setAction("Yes", snackOnClick);
                View snackBarView = mSnack.getView();
                //snackBarView.setBackgroundColor(Color.BLUE);

                TextView snackBarTextView = (TextView)snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                snackBarTextView.setTextColor(Color.RED);
                snackBarTextView.setTextSize(30);

                mSnack.setCallback(new Snackbar.Callback(){
                 //   public void onDismissed(Snackbar s, int event){
                 //   @Override
                 //       Toast.makeText(getApplicationContext(), "Snackbar is dismiss", Toast.LENGTH_SHORT).show();
                 //   }

                    @Override
                    public void onShown(Snackbar s){
                        Toast.makeText(getApplicationContext(), "Snackbar is shown", Toast.LENGTH_SHORT).show();
                    }
                });

                mSnack.show();
            }
        });

        Button dismissButton = (Button) findViewById(R.id.buttonDismiss);
        dismissButton.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View view){
                                               mSnack.dismiss();
                                           }
                                        }

        );
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
}
