package com.dozygeek.androidsensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listSensors;
    SensorManager sensorManager;
    ArrayList<String> sensorNamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSensors = findViewById(R.id.listSensors);
        sensorNamesList = new ArrayList<>();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, sensorNamesList);
        listSensors.setAdapter(listAdapter);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor: sensorList){
            String sensorName = sensor.getName();
            sensorNamesList.add(sensorName);
        }
        listAdapter.notifyDataSetChanged();

    }
}
