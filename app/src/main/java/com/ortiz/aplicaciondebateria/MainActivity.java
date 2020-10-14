package com.ortiz.aplicaciondebateria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BatteryReceiver mBatteryReceiver = new BatteryReceiver();
    private IntentFilter mIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBatteryReceiver);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        super.onResume();
        registerReceiver(mBatteryReceiver,mIntentFilter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}