package com.demo.mytimestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ListView listViewNumbers;
    ArrayList<Integer> arrayList;
    private int max = 20;
    private int min = 1;
    private int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        listViewNumbers = findViewById(R.id.listViewNumbers);
        arrayList = new ArrayList<>();
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listViewNumbers.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                arrayList.clear();
                if (progress < min) {
                    seekBar.setProgress(min);
                }
                for (int i = min; i <= counter; i++) {
                    arrayList.add(seekBar.getProgress() * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}