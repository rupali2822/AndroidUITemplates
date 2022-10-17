package com.example.androiduitemplates;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button dateBtn;
    Spinner spCountry;
    String selectedGender="male";
    String genderArray[];
    Chip android,java,kotlin;
    ChipGroup chipGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                spCountry=findViewById(R.id.spCountry);
        dateBtn=findViewById(R.id.bttnDob);
        android=findViewById(R.id.chipandroid);
        java=findViewById(R.id.chipjava);
        kotlin=findViewById(R.id.chipkotlin);
        chipGroup=findViewById(R.id.chipGroup);

                dateBtn.setText(getToadysDate());

       initDatePicker();
genderArray= new String[]{"male", "female"};
        String[] country = { "--Country--","India", "USA", "China", "Japan", "Other"};

        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,country);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spCountry.setAdapter(adapter);

        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (!checkedIds.isEmpty()){
                   // chipGroup.setBackgroundColor(R.color.colorPrimaryDark);

                }
            }
        });
        android.setOnClickListener(new View.OnClickListener() {
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        if (android.isChecked()) {
            Toast.makeText(MainActivity.this, "android selected", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.this, "android removed", Toast.LENGTH_SHORT).show();

        }
    }
});
    }
    private void showOptionDialog() {
        final String[] genders={"Male","Female","Other"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose gender");
        builder.setSingleChoiceItems(genders, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedGender=genders[which];
                Toast.makeText(MainActivity.this, "You have selected "+selectedGender, Toast.LENGTH_SHORT).show();
                // genderBtn.setText(selectedGender);
            }
        });
        builder.show();

    }
    private String getToadysDate() {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        month=month+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(day,month,year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                dateBtn.setText(date);
            }
        };

        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private String makeDateString(int day, int month, int year) {

        return getMonthFormat(month)+" "+day+" "+year;
    }

    private String getMonthFormat(int month) {
        if (month==1)
            return "JAN";
        if (month==2)
            return "FEB";
        if (month==3)
            return "MAR";
        if (month==4)
            return "APR";
        if (month==5)
            return "MAY";
        if (month==6)
            return "JUN";
        if (month==7)
            return "JUL";
        if (month==8)
            return "AUG";
        if (month==9)
            return "SEP";
        if (month==10)
            return "OCT";
        if (month==11)
            return "NOV";
        if (month==12)
            return "DES";

//default
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}