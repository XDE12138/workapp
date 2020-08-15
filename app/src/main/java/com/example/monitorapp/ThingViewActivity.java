package com.example.monitorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThingViewActivity extends AppCompatActivity {

    private Device[] devices = {new Device("正常", R.drawable.kuang1),
            new Device("故障", R.drawable.kuang2),
            new Device("故障", R.drawable.kaung3),
            new Device("正常", R.drawable.kaung4),
            new Device("正常", R.drawable.kuang5),
            new Device("未运行", R.drawable.kaung6),
            new Device("正常", R.drawable.kuang7),
            new Device("正常", R.drawable.kuang8),
            new Device("未运行", R.drawable.kuang9)};

    private List<Device> deviceList = new ArrayList<>();

    private DeviceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing_view);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DeviceAdapter(deviceList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        deviceList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(devices.length);
            deviceList.add(devices[index]);
        }
    }
}
