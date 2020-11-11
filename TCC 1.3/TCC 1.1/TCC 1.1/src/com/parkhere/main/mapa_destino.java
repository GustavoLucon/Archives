package com.parkhere.main;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.parkhere.R;
import com.parkhere.model.Marcador;
import com.parkhere.overlay.AreaOverlay;
import com.parkhere.overlay.ListaMarcadorOverlay;


public class mapa_destino  extends MapActivity {
	
	private Context contexto;
	private MapView mapa;
	private MapController controle;
	private ListaMarcadorOverlay listaOverlay;
	private  int x;
	private  int y;
	
    @Override
    public void onCreate( Bundle savedInstanceState ) {
    	
        super.onCreate( savedInstanceState );
        setContentView( R.layout.test);
        Intent intent = getIntent();
        this.x = Integer.parseInt(intent.getStringExtra("x"));
        this.y = Integer.parseInt(intent.getStringExtra("y"));

    }
    




public void setControle( MapController controle ) {
	this.controle = controle;
}



public MapController getControle() {
	return controle;
}


public void mapa(View v)
{

setMapa( (MapView) findViewById( R.id.mapview2 ) );

setControle(getMapa().getController());
getMapa().setBuiltInZoomControls( true );
getMapa().setSatellite( false );
getControle().setZoom(14);

listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();	

Marcador itemSP = new Marcador( -23569596,-46646519 ); // brigadeiro
Marcador destino = new Marcador( -23569576,-46646559);
  
  AreaOverlay areaOverlay = new AreaOverlay( this, itemSP , destino, 1000F);

  
  listaOverlay.setAreaOverlay( areaOverlay );
  
  listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
  listaOverlay.setListaOverlays( listaLocais );
  

        
  
getMapa().getOverlays().add( areaOverlay );

getMapa().getOverlays().add( listaOverlay );

getControle().setCenter( itemSP );
getMapa().invalidate();


}

public MapView getMapa() {
	return mapa;
}

public void setMapa( MapView mapa ) {
	this.mapa = mapa;
}

@Override
protected boolean isRouteDisplayed() {
	// TODO Auto-generated method stub
	return false;
}
}
