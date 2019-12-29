package com.example.callndlocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call extends AppCompatActivity {

    EditText cal;
    Button button;
    String scall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        cal=(EditText)findViewById(R.id.enter);

        button=(Button)findViewById(R.id.ccall);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scall=cal.getText().toString();
                Intent in=new Intent(Intent.ACTION_CALL);
                in.setData(Uri.parse("tel:"+scall));

               if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                    startActivity(in);

                Toast.makeText(getApplicationContext(),"calling",Toast.LENGTH_LONG).show();

            }
        });
    }
}
