package com.cookandroid.a10_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button btnPlus,btn1,btn2,btn3;
    LinearLayout liner1,liner2,liner3;
    TextView textView1,textView2,textView3;
    Button btnBack,btnRead,btnBack2;
    EditText editID;
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal,rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMinute;
    int selectYear,selectMonth,selectDay;
    View dialogView;
    SeekBar seekBar;
    RadioGroup rGroup;
    RadioButton rbtn0,rbtn5,rbtn10,rbtn15;
    EditText editMemo;
    int a = 0;
    int b= 0;
    int c= 0;
    int d =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Alarm");
        btnEnd = (Button) findViewById(R.id.btnEnd);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime=(RadioButton) findViewById(R.id.rdoTime);
        calView = (CalendarView) findViewById(R.id.calendarView1);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        liner1 = (LinearLayout) findViewById(R.id.linear1);
        liner2 = (LinearLayout) findViewById(R.id.linear2);
        liner3 = (LinearLayout) findViewById(R.id.linear3);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnBack2 = (Button) findViewById(R.id.btnBack2);
        editID = (EditText) findViewById(R.id.editID);
        seekBar = (SeekBar)findViewById(R.id.seek1);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rbtn0 = (RadioButton) findViewById(R.id.rbtn0);
        rbtn5 = (RadioButton) findViewById(R.id.rbtn5);
        rbtn10 = (RadioButton) findViewById(R.id.rbtn10);
        rbtn15 = (RadioButton) findViewById(R.id.rbtn15);
        editMemo = (EditText)findViewById(R.id.editMemo);
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liner1.setVisibility(View.INVISIBLE);
                liner2.setVisibility(View.VISIBLE);

            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                if(rbtn0.isChecked() == true){
                    d = 0;
                }
                else if(rbtn5.isChecked() == true){
                    d = 5;
                }
                else if(rbtn10.isChecked() == true){
                    d = 10;
                }
                else{
                    d= 15;
                }




                AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);
                dlg.setTitle("?????? ??????");
                dlg.setIcon(R.mipmap.ic_launcher);
               if((a==0) || (b ==0) || (c == 0)){
                dlg.setMessage(Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"???" + tPicker.getCurrentHour()+"???" + tPicker.getCurrentMinute()+"??? ?????????");
               }
               else
                   dlg.setMessage("????????? ???????????????. ?????? ????????? ??????????????????");

                if(a == 0){
                    textView1.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???");
                    textView1.setTextSize(20);
                    textView1.setTextColor(Color.BLACK);

                    editID.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???\n"
                    + "?????? : " + seekBar.getProgress()+"%\n" + "????????? ?????? : " + d +"???"+ "\n???????????? : " + editMemo.getText().toString());

                    a = 1;
                }
                else if(b==0){
                    textView2.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???");
                    textView2.setTextSize(20);
                    textView2.setTextColor(Color.BLACK);
                    editID.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???\n"
                            + "?????? : " + seekBar.getProgress()+"%\n" + "????????? ?????? : " + d+"???" + "\n???????????? : " + editMemo.getText().toString());
                    b= 1;
                }
                else if(c ==0){
                    textView3.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???");
                    textView3.setTextSize(20);
                    textView3.setTextColor(Color.BLACK);
                    editID.setText("?????? : "+Integer.toString(selectYear) + "??? " + Integer.toString(selectMonth) + "??? " +Integer.toString(selectDay) +"??? " + tPicker.getCurrentHour()+"??? " + tPicker.getCurrentMinute()+"???\n"
                            + "?????? : " + seekBar.getProgress()+"%\n" + "????????? ?????? : " + d +"???"+ "\n???????????? : " + editMemo.getText().toString());
                    c= 1;
                }

                dlg.setPositiveButton("??????",null);
                dlg.show();
                liner1.setVisibility(View.VISIBLE);
                liner2.setVisibility(View.INVISIBLE);


            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay= dayOfMonth;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("???????????? ?????? ??????");
                textView1.setTextSize(40);
                textView1.setTextColor(Color.GRAY);
                a = 0;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("???????????? ?????? ??????");
                textView2.setTextSize(40);
                textView2.setTextColor(Color.GRAY);
                b = 0;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.setText("???????????? ?????? ??????");
                textView3.setTextSize(40);
                textView3.setTextColor(Color.GRAY);
                c = 0;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liner1.setVisibility(View.VISIBLE);
                liner2.setVisibility(View.INVISIBLE);
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liner1.setVisibility(View.INVISIBLE);
                liner3.setVisibility(View.VISIBLE);





            }
        });
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liner1.setVisibility(View.VISIBLE);
                liner3.setVisibility(View.INVISIBLE);
            }
        });

    }
}
