package com.example.callndlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class location extends AppCompatActivity {

    FusedLocationProviderClient fused;
    Button butt;
    String latitude,longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        butt=(Button)findViewById(R.id.location);

        fused= LocationServices.getFusedLocationProviderClient(this);
        fused.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null)
                {
                     latitude=String.valueOf(location.getLatitude());
                     longitude=String.valueOf(location.getLongitude());
                }

            }
        });

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"lati"+latitude+"long"+longitude,Toast.LENGTH_LONG).show();

            }
        });
    }
}
