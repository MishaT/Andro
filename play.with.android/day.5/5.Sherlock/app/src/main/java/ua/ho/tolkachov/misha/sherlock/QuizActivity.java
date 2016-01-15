package ua.ho.tolkachov.misha.sherlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class QuizActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent answerIntent = new Intent();
        answerIntent.putExtra(THIEF, "Nobody");
        setResult(RESULT_OK, answerIntent);
    }

    public final static String THIEF = "ua.ho.tolkachov.misha.sherlock.THIEF";

    public void onRadioClick(View view) {
        Intent answerIntent = new Intent();

        switch (view.getId()){
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "Black Crown");
                break;
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Little Dog");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "freaking Cat");
                break;

            default:
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();

    }
}
