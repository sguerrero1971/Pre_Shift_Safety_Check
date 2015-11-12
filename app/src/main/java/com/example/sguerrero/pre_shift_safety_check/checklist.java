package com.example.sguerrero.pre_shift_safety_check;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by sguerrero on 4/29/15.
 */
public class checklist extends Activity {

    private CheckBox backup,horn,glass_wipers,seatbelt,lights,mirrors,doors_latches,housekeeping,brakes,parking_brake,steering,wheels_tires,fire_extinguisgher,steps_handles,guards,oil_level,water_level,radiator,differential,transmission,scsr;
    private Button checklist_next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String name = extras.getString("name");
        String vehicle = extras.getString("vehicle");
        String shift = extras.getString("shift");

        TextView nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(name);

        TextView vehicleText = (TextView) findViewById(R.id.vehicleText);
        vehicleText.setText(vehicle);

        TextView shiftText = (TextView) findViewById(R.id.shiftText);
        shiftText.setText(shift);

        addlistenerOnButton();
    }

    public void addlistenerOnButton() {

        backup = (CheckBox) findViewById(R.id.checkbox_backup);
        horn = (CheckBox) findViewById(R.id.checkbox_horn);
        glass_wipers = (CheckBox) findViewById(R.id.checkbox_glass_wipers);
        seatbelt = (CheckBox) findViewById(R.id.checkbox_seatbelts);
        lights = (CheckBox) findViewById(R.id.checkbox_lights);
        mirrors = (CheckBox) findViewById(R.id.checkbox_mirrors);
        doors_latches = (CheckBox) findViewById(R.id.checkbox_door_latches);
        housekeeping = (CheckBox) findViewById(R.id.checkbox_housekeeping);
        brakes = (CheckBox) findViewById(R.id.checkbox_brakes);
        parking_brake = (CheckBox) findViewById(R.id.checkbox_parking_brake);
        steering = (CheckBox) findViewById(R.id.checkbox_steering);
        wheels_tires = (CheckBox) findViewById(R.id.checkbox_wheels_tires);
        steps_handles = (CheckBox) findViewById(R.id.checkbox_steps_handels);
        fire_extinguisgher = (CheckBox) findViewById(R.id.checkbox_fire_extinguisher);
        guards = (CheckBox) findViewById(R.id.checkbox_guards);
        oil_level = (CheckBox) findViewById(R.id.checkbox_oil_level);
        water_level = (CheckBox) findViewById(R.id.checkbox_water_level);
        radiator = (CheckBox) findViewById(R.id.checkbox_radiator);
        differential = (CheckBox) findViewById(R.id.checkbox_differential);
        transmission = (CheckBox) findViewById(R.id.checkbox_transmission);
        scsr = (CheckBox) findViewById(R.id.checkbox_scsr);
        checklist_next = (Button) findViewById(R.id.button_checklist_next);

        checklist_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer list = new StringBuffer();

                list.append("backup").append(backup.isChecked());
                list.append("horn").append(horn.isChecked());
                list.append("glass_wipers").append(glass_wipers.isChecked());
                list.append("seatbelt").append(seatbelt.isChecked());
                list.append("lights").append(lights.isChecked());
                list.append("mirrors").append(mirrors.isChecked());
                list.append("doors_latches").append(doors_latches.isChecked());
                list.append("housekeeping").append(housekeeping.isChecked());
                list.append("brakes").append(brakes.isChecked());
                list.append("parking_brake").append(parking_brake.isChecked());
                list.append("steering").append(steering.isChecked());
                list.append("wheels_tires").append(wheels_tires.isChecked());
                list.append("steps_handles").append(steps_handles.isChecked());
                list.append("fire_extinguisher").append(fire_extinguisgher.isChecked());
                list.append("guards").append(guards.isChecked());
                list.append("oil_level").append(oil_level.isChecked());
                list.append("water_level").append(water_level.isChecked());
                list.append("radiator").append(radiator.isChecked());
                list.append("differential").append(differential.isChecked());
                list.append("transmission").append(transmission.isChecked());
                list.append("scsr").append(scsr.isChecked());

                Toast.makeText(checklist.this, list.toString(),
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
