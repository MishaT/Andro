package ua.ho.tolkachov.misha.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public enum Operator{Undefined, Plus, Minus, Multiply, Divide, Sign, Equal}

    private TextView mInputText;
    private TextView mStatusBar;
    private boolean isNewValue = false;
    private boolean isCalculated = true;
    private float mCurrentValue = 0;
    private Operator mOperator = Operator.Undefined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputText = (TextView)findViewById(R.id.inputText);
        mStatusBar = (TextView)findViewById(R.id.textViewOperator);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

    public String OperatorText(Operator newOperator){
        switch (newOperator) {
            case Plus:
                return "+";
            //break;
            case Minus: return "-";
            //break;
            case Multiply: return "*";
           // break;
            case Divide: return "+";
            //break;
            case Equal: return "+";
            //break;
            case Sign: return "+";
            //break;
            default: return " ";
           // break;
        }

    }

    public void setOperator(Operator newOperator) {

        mStatusBar.setText(OperatorText(newOperator));

        if (!isCalculated) doCalculate();

        mOperator = newOperator;
    }

    public void setInputText(String digit) {
        String lCurrentText = mInputText.getText().toString();
        if (digit.equals(".") & (lCurrentText.indexOf(".") >= 0))
            return;

        if ((isNewValue) || lCurrentText.equals ("0"))  // Float.parseFloat(lCurrentText) == 0))
        {
            if (digit.equals("."))
                mInputText.setText("0" + digit);
            else
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
                case Plus: {
                    lResult = mCurrentValue + lEditingValue;
                }
                break;
                case Minus: {
                    lResult = mCurrentValue - lEditingValue;
                }
                break;
                case Divide: {
                    if (lEditingValue != 0) {
                        lResult = mCurrentValue / lEditingValue;
                    }
                }
                break;
                case Multiply: {
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
        mOperator = Operator.Undefined;
    }

    public void btnEqualClick(View view) {
        setOperator(Operator.Equal);
    }
    //-----------------------------------------
    public void btnPlusClick(View view) {
        setOperator(Operator.Plus);
    }

    public void btnMinusClick(View view) {
        setOperator(Operator.Minus);
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
        setOperator(Operator.Divide);
    }

    public void btnMultiplyClick(View view) {
        setOperator(Operator.Multiply);
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
