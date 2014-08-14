package com.example.unitapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	public static boolean isMph = true;
	public static Button mphShow;
	public static Button fpsShow;
	public static int speed;
	public static TextView spd;
	public static TextView unit;
	public static ExpandableListView dist, time;

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
					speed = (int) Math.round(speed * 0.681818);
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
					speed = (int) Math.round(speed * 1.4666);
					spd.setText(Integer.toString(speed));
					isMph = false;
				}
			}
    	};
    	fpsShow.setOnClickListener(fpsListener);
    	
    	// add stuff to the list view
    	dist = (ExpandableListView) findViewById(R.id.distance);
    	time = (ExpandableListView) findViewById(R.id.time);
    	
    	List<String> distDataHeader = new ArrayList<String> ();
    	HashMap<String, List<String>> distDataChild = new HashMap<String, List<String>> ();
    	prepareDistView(distDataHeader, distDataChild);
    	ExpandableListAdapter distAdapter = new ExpandableListAdapter(this, distDataHeader, distDataChild);
        dist.setAdapter(distAdapter);
        
        List<String> timeDataHeader = new ArrayList<String> ();
    	HashMap<String, List<String>> timeDataChild = new HashMap<String, List<String>> ();
    	prepareTimeView(timeDataHeader, timeDataChild);
    	ExpandableListAdapter timeAdapter = new ExpandableListAdapter(this, timeDataHeader, timeDataChild);
        time.setAdapter(timeAdapter);
    }
    
    public void prepareDistView(List<String> l, HashMap<String, List<String>> h) {
    	l.add("Distance");
    	List<String> dUnit = new ArrayList<String> ();
    	dUnit.add("miles");
    	dUnit.add("kiometers");
    	dUnit.add("feet");
    	dUnit.add("meters");
    	dUnit.add("inches");
    	dUnit.add("centimeters");
    	dUnit.add("milimeters");
    	h.put(l.get(0), dUnit);
    }
    
    public void prepareTimeView(List<String> l, HashMap<String, List<String>> h) {
    	l.add("Time");
    	List<String> tUnit = new ArrayList<String> ();
    	tUnit.add("hour");
    	tUnit.add("minute");
    	tUnit.add("second");
    	tUnit.add("day");
    	tUnit.add("week");
    	h.put(l.get(0), tUnit);
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
