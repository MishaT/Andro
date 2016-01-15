package ua.ho.tolkachov.misha.sherlock;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class QuizActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public final static String THIEF = "ua.ho.tolkachov.misha.sherlock.THIEF";

    public void onRadioClick(View view) {

    }
}
