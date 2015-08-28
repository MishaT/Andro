package com.example.misha.thesecondtest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView mInputText;
    private TextView mStatusBar;
    private boolean isNewValue = false;
    private boolean isCalculated = true;
    private float mCurrentValue = 0;
    private String mOperator = ""; //todo: change it to the special type

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputText = (TextView)findViewById(R.id.inputText);
        mStatusBar = (TextView)findViewById(R.id.textViewOperator);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        if (id == R.id.action_about) {
            onAboutClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAboutClick(){   //(View view)
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
//==================================================
    public void setOperator(String newOperator) {
        mStatusBar.setText(newOperator);

        if (!isCalculated) doCalculate();

        mOperator = newOperator;
    }

    public void setInputText(String digit) {
        String lCurrentText = mInputText.getText().toString();

        if ((isNewValue) || (Float.parseFloat(lCurrentText) == 0)){
            mInputText.setText(digit);
            isNewValue = false;
        }
        else {
            mInputText.setText(lCurrentText + digit);

        }
        isCalculated = false;
    }

    public void doCalculate(){
        float lEditingValue = Float.parseFloat(mInputText.getText().toString());
        float lResult = 0;

        if ((mCurrentValue == 0)){
            mCurrentValue = lEditingValue;
           }
        else {
            switch (mOperator){
                case "+": {
                    lResult = mCurrentValue + lEditingValue;
                }
                break;
                case "-": {
                    lResult = mCurrentValue - lEditingValue;
                }
                break;
                case "/": {
                    if (lEditingValue != 0) {
                        lResult = mCurrentValue / lEditingValue;
                    }
                }
                break;
                case "*": {
                    lResult = mCurrentValue * lEditingValue;
                }
                break;
            }

            mInputText.setText(Float.toString(lResult));
            mCurrentValue = lResult;
        }
        isNewValue = true;
        isCalculated = true;
    }

    public void btnClearClick(View view) {
        mInputText.setText("0");
        mCurrentValue = 0;
        mOperator = "";
    }

    public void btnEqualClick(View view) {
        setOperator("=");
    }
    //-----------------------------------------
    public void btnPlusClick(View view) {
        setOperator("+");
    }

    public void btnMinusClick(View view) {
        setOperator("-");
    }

    public void btnSignClick(View view) {
        String lText = mInputText.getText().toString();
        if (Float.parseFloat(lText) == 0)
            return;

        if (lText.substring(0, 1).equals("-")) {
            lText = lText.substring(1, lText.length());
        }
        else {
            lText = "-" + lText;
        }
        mInputText.setText(lText);
    }

    public void btnDivideClick(View view) {
        setOperator("/");
    }

    public void btnMultiplyClick(View view) {
        setOperator("*");
    }
//-----------------------------------------
    public void btn1Click(View view) {
        setInputText("1");
    }
    public void btn2Click(View view) {
        setInputText("2");
    }
    public void btn3Click(View view) {
        setInputText("3");
    }
    public void btn4Click(View view) {
        setInputText("4");
    }
    public void btn5Click(View view) {
        setInputText("5");
    }
    public void btn6Click(View view) {
        setInputText("6");
    }
    public void btn7Click(View view) {
        setInputText("7");
    }
    public void btn8Click(View view) {
        setInputText("8");
    }
    public void btn9Click(View view) {
        setInputText("9");
    }
    public void btn0Click(View view) {
        setInputText("0");
    }
    public void btnDotClick(View view) {
        setInputText(".");
    }
}
