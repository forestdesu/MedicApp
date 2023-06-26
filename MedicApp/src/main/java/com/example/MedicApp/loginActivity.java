package com.example.MedicApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {

    Button next;
    Button skipp;
    EditText email_input;
    int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_input = (EditText) findViewById(R.id.inp_email);
        next = (Button) findViewById(R.id.next_btn);
        skipp = (Button) findViewById(R.id.skipp_btn);

        email_input.addTextChangedListener(loginTextWatcher);


        skipp.setVisibility(View.VISIBLE);
        skipp.setBackgroundColor(Color.TRANSPARENT);

    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String mailInp = email_input.getText().toString().trim();
            next.setEnabled(!mailInp.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void onClickT(View view) {
        Intent intent = new Intent(this, CreatePasswordActivity.class);
        startActivity(intent);
    }
    public void onClickNext(View view) {

        Intent intent = new Intent(this, EnterEmailActivity.class);
        startActivity(intent);
    }
}