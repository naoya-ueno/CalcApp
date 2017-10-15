package jp.techacademy.naoya.ueno.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double num1 = Double.parseDouble(mEditText1.getText().toString());
        double num2 = Double.parseDouble(mEditText2.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", num1);
        intent.putExtra("VALUE2", num2);
        if (v.getId() == R.id.button1) {
            intent.putExtra("VALUE3", 1);
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE3", 2);
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE3", 3);
        } else {
            intent.putExtra("VALUE3", 4);
        }
        startActivity(intent);
    }

}