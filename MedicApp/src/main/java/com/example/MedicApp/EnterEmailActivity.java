package com.example.MedicApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EnterEmailActivity extends AppCompatActivity {

    EditText digit1;
    EditText digit2;
    EditText digit3;
    EditText digit4;
    TextView ctimer;
    Button returnb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_email);
        digit1 = (EditText) findViewById(R.id.inp_digit1);
        digit2 = (EditText) findViewById(R.id.inp_digit2);
        digit3 = (EditText) findViewById(R.id.inp_digit3);
        digit4 = (EditText) findViewById(R.id.inp_digit4);
        ctimer = (TextView) findViewById(R.id.timer_text);
        returnb = (Button) findViewById(R.id.return_btn);
        returnb.setVisibility(View.VISIBLE);
        returnb.setBackgroundColor(Color.TRANSPARENT);
        returnb.setEnabled(false);

        digit1.addTextChangedListener(loginTextWatcher);
        digit2.addTextChangedListener(loginTextWatcher2);
        digit3.addTextChangedListener(loginTextWatcher3);
        digit4.addTextChangedListener(loginTextWatcher4);

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long sec = (millisUntilFinished / 1000) % 60;
                ctimer.setText("Отправить код повторно можно будет через "+f.format(sec)+" секунд.");
            }
            public void onFinish() {
                ctimer.setText("Отправить код повторно.");
                returnb.setEnabled(true);
            }

        }.start();

    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String firstdigit = digit1.getText().toString().trim();
            digit2.requestFocus();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher loginTextWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String seconddigit = digit2.getText().toString().trim();
            digit3.requestFocus();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher loginTextWatcher3 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String thirddigit = digit3.getText().toString().trim();
            digit4.requestFocus();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher loginTextWatcher4 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String fourthdigit = digit4.getText().toString().trim();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onClickReturn(View view) {
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
}