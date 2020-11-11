package com.parkhere.main;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.parkhere.R;
import com.parkhere.model.Marcador;
import com.parkhere.overlay.AreaOverlay;
import com.parkhere.overlay.ListaMarcadorOverlay;

public class ParkHereActivity extends MapActivity {
	
	private Context contexto;
	private MapView mapa;
	private MapController controle;
	
	
    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.park_here_activity );
    }
       

	// INSIRA AQUI O METODO DE PASSAR XML
    
    
    
    public void buscar (View v)
    {
    	EditText campoEndereco = (EditText) findViewById(R.id.campoEndereco);
    	String endereço = campoEndereco.getText().toString();
    	
    	// Passa endereço acima para o XML
    	
    	// recebe aqui na lista
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ALi EM CIMA

	public void mapa(View v)
    {
    	setContentView( R.layout.mapa );  	
    	
        setMapa( (MapView) findViewById( R.id.mapview ) );

    	setControle( getMapa().getController() );
        getMapa().setBuiltInZoomControls( true );
        getMapa().setSatellite( false );
        getControle().setZoom(14);
        
        ListaMarcadorOverlay listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
        ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();
        
        Marcador itemSP = new Marcador( -23563596, -46653885 );
        AreaOverlay areaOverlay = new AreaOverlay( this, itemSP, 1000F);
        
        listaOverlay.setAreaOverlay( areaOverlay );
        
        listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
        listaOverlay.setListaOverlays( listaLocais );
        
        getMapa().getOverlays().add( listaOverlay );
        getMapa().getOverlays().add( areaOverlay );
        getControle().setCenter( itemSP );
        getMapa().invalidate();
        
       }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.park_here_activity, menu );
        return true;
    }
    
    

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	

	public MapView getMapa() {
		return mapa;
	}

	public void setMapa( MapView mapa ) {
		this.mapa = mapa;
	}
	public void Sair(View v)
	{
		System.exit(0);
	}
	
	public void voltar(View v)
	{
		 setContentView( R.layout.park_here_activity );
	}

	public void Creditos(View v)
	{
		 setContentView( R.layout.creditos );
	}
	

	public MapController getControle() {
		return controle;
	}

	public void setControle( MapController controle ) {
		this.controle = controle;
	}

	public Context getContexto() {
		return contexto;
	}

	public void setContexto( Context contexto ) {
		this.contexto = contexto;
	}
}
