package com.ortiz.aplicaciondebateria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        TextView statusLabel = ((MainActivity)context).findViewById(R.id.statusLabel);
        TextView porcentageLabel = ((MainActivity)context).findViewById(R.id.porcentageLabel);
        ImageView batteryImage = ((MainActivity)context).findViewById(R.id.batteryImage);

        String action = intent.getAction();

        if(action != null && action.equals(intent.ACTION_BATTERY_CHANGED)){

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            String menssage = "";


            switch (status) {
                case BatteryManager.BATTERY_STATUS_FULL:
                    menssage = "Cargada";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    menssage = "Cargando Bateria";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    menssage = "Bateria Descargada";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    menssage = "bateria";
                    break;


            }
            statusLabel.setText(menssage);

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int percentage = level * 100 /scale;

            porcentageLabel.setText(percentage + "%");

            Resources res = context.getResources();

            if( percentage >= 90 ) {
                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b100));

            }else if (90> percentage && percentage >= 65 ){

                batteryImage.setImageDrawable((res.getDrawable(R.drawable.b75)));
            }else if (65> percentage && percentage >= 40 ) {

                batteryImage.setImageDrawable((res.getDrawable(R.drawable.b50)));
            }else if (40> percentage && percentage >= 15 ) {

                batteryImage.setImageDrawable((res.getDrawable(R.drawable.b25)));

            }else if (40> percentage && percentage >= 15 ) {

                batteryImage.setImageDrawable((res.getDrawable(R.drawable.b0)));
            }



        }


    }
}
