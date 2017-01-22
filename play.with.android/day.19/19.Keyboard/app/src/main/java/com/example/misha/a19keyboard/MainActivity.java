package com.example.misha.a19keyboard;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed(){
        showQuitDialog();
        //super.onBackPressed();
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
