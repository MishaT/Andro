package com.example.misha.a19keyboard;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static long back_pressed_time;
    private static final long double_press_interval = 2000;

    @Override
    public void onBackPressed(){
        if(back_pressed_time + 2000 > System.currentTimeMillis()) {
            //showQuitDialog();
            super.onBackPressed();
        }else{
            Toast.makeText(getBaseContext(),
                            getResources().getText(R.string.double_press_to_exit),
                            Toast.LENGTH_SHORT).show();
        }

        back_pressed_time = System.currentTimeMillis();

    }

    private void showQuitDialog(){
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle(getResources().getString(R.string.exit_dialog_title));

        exitDialog.setPositiveButton(getResources().getString(R.string.exit_dialog_Yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        exitDialog.setNegativeButton(getResources().getString(R.string.exit_dialog_No),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                });

        exitDialog.show();

    }
}
