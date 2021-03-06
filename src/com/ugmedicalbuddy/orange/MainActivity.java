package com.ugmedicalbuddy.orange;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	final Context context = this;
	private ImageView medicalcenter, button, helpicon, healthtips,firstaid;
 	
	public void onCreate(Bundle savedInstanceState) {
 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		medicalcenter =(ImageView) findViewById(R.id.image1);
		button = (ImageView ) findViewById(R.id.image3);
		healthtips = (ImageView ) findViewById(R.id.image2);
		
		medicalcenter.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				
				String uri = "geo:0,0?q=Hospital";
 				startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
 
			}
 
		});
		
		
		
		
		
		
        healthtips.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent healthtips = new Intent(context, Inspiration.class);
		    	startActivity(healthtips);
				
			}
		});
		
        
        			
		helpicon =	(ImageView) findViewById(R.id.image5);
        helpicon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent helptips = new Intent(context, NasaActivity.class);
		    	startActivity(helptips);
		    	
				
			}
		});
		
		firstaid = (ImageView) findViewById(R.id.image4);
 
		firstaid.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent firsAidtips = new Intent(context, QuoteListActivity.class);
		    	startActivity(firsAidtips);
				
			}
		});
		
		// add PhoneStateListener
		PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) this
			.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);
 
		// add button listener
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:0791487165"));
				startActivity(callIntent);
 
			}
 
		});
 
	}
 
	//monitor phone call activities
	private class PhoneCallListener extends PhoneStateListener {
 
		private boolean isPhoneCalling = false;
 
		String LOG_TAG = "LOGGING 123";
 
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
 
			if (TelephonyManager.CALL_STATE_RINGING == state) {
				// phone ringing
				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
			}
 
			if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
				// active
				Log.i(LOG_TAG, "OFFHOOK");
 
				isPhoneCalling = true;
			}
 
			if (TelephonyManager.CALL_STATE_IDLE == state) {
				// run when class initial and phone call ended, 
				// need detect flag from CALL_STATE_OFFHOOK
				Log.i(LOG_TAG, "IDLE");
 
				if (isPhoneCalling) {
 
					Log.i(LOG_TAG, "restart app");
 
					// restart app
					Intent i = getBaseContext().getPackageManager()
						.getLaunchIntentForPackage(
							getBaseContext().getPackageName());
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
 
					isPhoneCalling = false;
				}
 
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
