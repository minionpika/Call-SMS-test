package com.example.user.callsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2SMS extends AppCompatActivity {

    EditText editmsg, editnumber;
    Button sendbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_sms);

        editmsg= (EditText)findViewById(R.id.editText);
        editnumber= (EditText)findViewById(R.id.editText2);
        sendbtn= (Button)findViewById(R.id.button3);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss1= editmsg.getText().toString();
                String ss2= editnumber.getText().toString();

                if(ss1.length()>0 && ss2.length()>0 )
                {
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(ss1, null, ss2, null, null);
                    }
                    catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Please Enter message and phone number", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
