package com.example.callndlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class watsapp extends AppCompatActivity {

    EditText mob,msg;
    Button bu;
    String smsg,smob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watsapp);

        msg=(EditText)findViewById(R.id.message);
        mob=(EditText)findViewById(R.id.mobile);

        bu=(Button)findViewById(R.id.sent);

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                smsg=msg.getText().toString();
                smob=mob.getText().toString();

                smsg="hello";
                Intent intu=new Intent(Intent.ACTION_VIEW);
                intu.setData(Uri.parse("https://api.whatsapp.com/sent?phone="+mob+"&text"+smsg));
                startActivity(intu);

                Toast.makeText(getApplicationContext(),"senting",Toast.LENGTH_LONG).show();
            }
        });
    }
}
