

package com.ugmedicalbuddy.orange;

import com.ugmedicalbuddy.orange.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.webkit.WebView;
import android.content.Context;

public class MapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.centermap);
		WebView myWebView2 = (WebView) findViewById(R.id.webView2);
		myWebView2.getSettings().setBuiltInZoomControls(true);
		// Not needed today...
		// myWebView.getSettings().setJavaScriptEnabled(true);

		// Open asset/index.html
		myWebView2.loadUrl("file:///android_asset/solomon.html");
	
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
