package com.example.park;

import java.sql.Timestamp;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log; 
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {   
TextView tv;
    @Override 
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tela_inicial);         
    tv = (TextView)this.findViewById(R.id.editText1);
    LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    LocationListener ll = new mylocationlistener();
    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);    
    }  
    private class mylocationlistener implements LocationListener {
    public void onLocationChanged(Location location) {    
     Date today = new Date();  
Timestamp currentTimeStamp = new Timestamp(today.getTime());
        if (location != null) {
        Log.d("LOCATION CHANGED", location.getLatitude() + "");
        Log.d("LOCATION CHANGED", location.getLongitude() + "");
        String str = "\n CurrentLocation: "+
        "\n Latitude: "+ location.getLatitude() + 
        "\n Longitude: " + location.getLongitude() + 
        "\n Accuracy: " + location.getAccuracy() + 
        "\n CurrentTimeStamp "+ currentTimeStamp;         
          Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
          tv.append(str);               
        } 
    } 
    public void selfSair(View view) {
		
	}

	public void selfAjuda(View view) {
		setContentView(R.layout.tela_ajuda);

	}

	public void selfPrincipal(View view) {
		setContentView(R.layout.tela_inicial);

	}
	
	public void selfGPS(View view) {

		
	}
	
	public void selfPesquisa(View view) {
		setContentView(R.layout.tela_pesquisa);

	}
    public void onProviderDisabled(String provider) {
    Toast.makeText(MainActivity.this,"Error onProviderDisabled",Toast.LENGTH_LONG).show();
    }    
    public void onProviderEnabled(String provider) {
    Toast.makeText(MainActivity.this,"onProviderEnabled",Toast.LENGTH_LONG).show();
    }
    public void onStatusChanged(String provider, int status, Bundle extras) {
    Toast.makeText(MainActivity.this,"onStatusChanged",Toast.LENGTH_LONG).show();
    }
    }
}