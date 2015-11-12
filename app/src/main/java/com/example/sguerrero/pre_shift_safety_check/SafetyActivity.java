package com.example.sguerrero.pre_shift_safety_check;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SafetyActivity extends ActionBarActivity {

    private EditText name,vehicle;
    private RadioGroup radiogroup;
    private RadioButton day,night;
    private TextView shift;
    private Button next;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);

        radiogroup = (RadioGroup) findViewById(R.id.myRadioGroup);

        context = this.getApplicationContext();

        name = (EditText) findViewById(R.id.Operator_Name);
        vehicle = (EditText) findViewById(R.id.Vehicle_Number);

        day = (RadioButton) findViewById(R.id.day_shift);
        night = (RadioButton) findViewById(R.id.night_shift);
        shift = (TextView) findViewById(R.id.shift);

        next = (Button) findViewById(R.id.button_safety_submit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radiogroup.getCheckedRadioButtonId();

                if(selectedId == day.getId()) {
                    shift.setText("Day Shift");
                } else if(selectedId == night.getId()) {
                    shift.setText("Night Shift");
                }

                Intent myIntent = new Intent(context,checklist.class);
                myIntent.putExtra("name", name.getText().toString());
                myIntent.putExtra("vehicle", vehicle.getText().toString());
                myIntent.putExtra("shift", shift.getText().toString());
                startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_safety, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
