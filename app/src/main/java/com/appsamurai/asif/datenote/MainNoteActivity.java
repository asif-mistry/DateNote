package com.appsamurai.asif.datenote;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;

import com.appsamurai.asif.datenote.Models.Note;
import com.appsamurai.asif.datenote.Services.DatabaseHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainNoteActivity extends AppCompatActivity implements  OnClickListener {

    //UI References
    private EditText dateText;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private Calendar selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_note);
        dateFormatter = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.US);
        findViewsById();
        setDateTimeField();
        //insertData();
        getAllData();
    }

    private void findViewsById() {
        dateText = (EditText) findViewById(R.id.text_date);
        dateText.setInputType(InputType.TYPE_NULL);
        dateText.requestFocus();
    }

    private void setDateTimeField() {
        dateText.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();

        selectedDate = newCalendar;
        datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dateText.setText(dateFormatter.format(newDate.getTime()));
                selectedDate = newDate;
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        dateText.setText(dateFormatter.format(new Date()));
    }

    @Override
    public void onClick(View view) {
        datePickerDialog.show();
    }

    private void insertData() {
        DatabaseHandler db = new DatabaseHandler(this);
        db.addNote(new Note("2/2/2017", "9100000000"));
        db.addNote(new Note("3/2/2017", "9199999999"));
        db.addNote(new Note("4/2/2017", "9522222222"));
        db.addNote(new Note("5/2/2017", "9533333333"));
    }
    private void getAllData() {
        DatabaseHandler db = new DatabaseHandler(this);
        List<Note> notes = db.getAllNotes();
        for (Note cn : notes) {
            String log = "Id: "+cn.getID()+" ,Date: " + cn.getDate() + " ,Note: " + cn.getNote();
            Log.d("NoteDetail: ", log);
        }
    }
}