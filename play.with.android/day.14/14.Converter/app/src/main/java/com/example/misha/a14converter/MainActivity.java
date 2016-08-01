package com.example.misha.a14converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public enum ConvertType{ctToParrots, ctToMeters}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private float doConvert(float aInput, ConvertType convertType){
        if (convertType == ConvertType.ctToMeters) {
            return (float) (aInput * 7.6);
        } else if (convertType == ConvertType.ctToParrots) {
            return (float) (aInput / 7.6);
        } else return (float) 0;
    }

    public void onClick(View v){
        RadioButton meterRadioButton = (RadioButton)findViewById(R.id.rbMeters);
        EditText inputEditText = (EditText)findViewById(R.id.editText);

        if (inputEditText.getText().length() == 0){
            Toast.makeText(MainActivity.this, "Please enter the Length", Toast.LENGTH_LONG).show();
            return;
        }
        float inputValue = Float.parseFloat(inputEditText.getText().toString());

        if (meterRadioButton.isChecked()){
            inputEditText.setText(String.valueOf(doConvert(inputValue, ConvertType.ctToMeters)));
        }else{
            inputEditText.setText(String.valueOf(doConvert(inputValue, ConvertType.ctToParrots)));
        }

    }
}
