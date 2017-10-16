package jp.techacademy.naoya.ueno.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

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

        try {
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
        catch (NumberFormatException e) {
            showAlertDialog();
        }

    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("正しい数値を入力してください。");

        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        mEditText1.getEditableText().clear();
                        mEditText2.getEditableText().clear();
                        mEditText1.requestFocus();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}