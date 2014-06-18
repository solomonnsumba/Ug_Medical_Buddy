package com.ugmedicalbuddy.orange;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class Inspiration extends Activity {

    private TextView mRegionArea;
    private Button imageButton;
    private Button sendmessage;
    private EditText phoneNo;
    private TextView messageBody;
    private smss sc = new smss();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspiration); // Must call setContentView before findViewById
        mRegionArea = (TextView) findViewById(R.id.color_region);

        mRegionArea.setText(sc.getArray()[0]);

        Button nextButton = (Button)findViewById(R.id.next);
        Button previousButton = (Button)findViewById(R.id.previous);

        nextButton.setOnClickListener(new NextButtonClass(Color.BLACK, this));
        previousButton.setOnClickListener(new PreviousButtonClass(Color.BLACK, this));

        imageButton=(Button)findViewById(R.id.cancelButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(),"refresh", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Inspiration.this,Inspiration.class);
                startActivity(intent);
            }
        });

        sendmessage=(Button)findViewById(R.id.sendMessage);
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.message);
            }
        });

    }
    public TextView getTxtView(){
        return this.mRegionArea;
    }

    public void send(View v){

    if (v== (View) findViewById(R.id.sendBtn)){

                phoneNo = (EditText) findViewById(R.id.mn);
                messageBody = (TextView) findViewById(R.id.mb);
                String number = phoneNo.getText().toString();
                String sms =mRegionArea.getText().toString();
                messageBody.setText(sms);

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!",Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"SMS failed, Check your phone number", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

     }
    }

    public void back(View w){

        if(w==(View)findViewById(R.id.backtmenu)){

            Intent intent=new Intent(getApplicationContext(),Inspiration.class);
            startActivity(intent);

        }


    }


}