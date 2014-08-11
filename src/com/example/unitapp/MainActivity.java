package com.example.unitapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	public static boolean isMph = true;
	public static Button mphShow;
	public static Button fpsShow;
	public static int speed;
	public static TextView spd;
	public static TextView unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mphShow = (Button) findViewById(R.id.mph);
        fpsShow = (Button) findViewById(R.id.ftpsec);
        spd = (TextView) findViewById(R.id.number);
        unit = (TextView) findViewById(R.id.unit);
        View.OnClickListener mphListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				unit.setText("mph");
				if (!isMph) {
					speed = Integer.parseInt((String) spd.getText());
					speed = (int) (speed * 0.681818);
					spd.setText(Integer.toString(speed));
					isMph = true;
				}
			}
    	};
    	mphShow.setOnClickListener(mphListener);
    	
    	View.OnClickListener fpsListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Here we have to start the game.
				unit.setText("ft/sec");
				if (isMph) {
					speed = Integer.parseInt((String) spd.getText());
					speed = (int) (speed * 1.4666);
					spd.setText(Integer.toString(speed));
					isMph = false;
				}
			}
    	};
    	fpsShow.setOnClickListener(fpsListener);
    	
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
