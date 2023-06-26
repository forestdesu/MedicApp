package com.example.MedicApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class CreateCardActivity extends AppCompatActivity {
    Button skip_fin;
    Button create;
    EditText name;
    EditText fname;
    EditText surname;
    EditText date;
    Spinner gender;
    DatePickerDialog datePickerDialog;
    String[] countries = {"Мужчина", "Женщина"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        skip_fin = findViewById(R.id.skipf_btn);
        skip_fin.setVisibility(View.VISIBLE);
        skip_fin.setBackgroundColor(Color.TRANSPARENT);
        create = findViewById(R.id.create_btn);
        name = findViewById(R.id.inp_name);
        fname = findViewById(R.id.inp_fathname);
        surname = findViewById(R.id.inp_surname);
        date = findViewById(R.id.inp_date);
        gender = findViewById(R.id.inp_gender);

        name.addTextChangedListener(loginTextWatcher);
        fname.addTextChangedListener(loginTextWatcher);
        surname.addTextChangedListener(loginTextWatcher);
        date.addTextChangedListener(loginTextWatcher);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        gender.setAdapter(adapter);

    }
    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nameInp = name.getText().toString().trim();
            String fnameInp = fname.getText().toString().trim();
            String surnameInp = surname.getText().toString().trim();
            String dateInp = date.getText().toString().trim();

            if (!nameInp.isEmpty()&&!fnameInp.isEmpty()&&!surnameInp.isEmpty()&&!dateInp.isEmpty()){
                create.setEnabled(true);
                create.setBackground(AppCompatResources.getDrawable(CreateCardActivity.this, R.color.blue));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onClickGETTOTHEBUSINESS(View view) {
        Intent intent = new Intent(this, TrueMainActivity.class);
        startActivity(intent);
    }

    public void onClickDatePick(View view){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "."
                                + (monthOfYear + 1) + "." + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}