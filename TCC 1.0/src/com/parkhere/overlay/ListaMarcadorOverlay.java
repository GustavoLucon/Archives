package com.parkhere.overlay;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class ListaMarcadorOverlay extends ItemizedOverlay<OverlayItem> {
	
	private Context contexto;
	private AreaOverlay areaOverlay;
	private List<OverlayItem> listaOverlays;
	
	
	public ListaMarcadorOverlay( Drawable defaultMarker ) {
		super( boundCenterBottom( defaultMarker ) );
	}
	
	public ListaMarcadorOverlay( Drawable defaultMarker, Context contexto ) {
		this( defaultMarker );
		this.contexto = contexto;
	}
	
	public void addOverlay( OverlayItem overlay ) {
		listaOverlays.add( overlay );
	    populate();
	}
	
	@Override
	public void draw( Canvas canvas, MapView mapa, boolean sombra ) {

		if( sombra ) return; // Ignora camada de sombra.

	    Projection projecao = mapa.getProjection();
	    Point ponto = new Point();
	    projecao.toPixels( getAreaOverlay().getCentro(), ponto );
	    
	    float raioCirculo = projecao.metersToEquatorPixels( getAreaOverlay().getRaioCirculo() ) * 
			( 1 / FloatMath.cos( (float) Math.toRadians( getAreaOverlay().getCentro().getLatitudeE6() / 
															getAreaOverlay().getCONSTANTE_1E6() ) ) );

	    Paint desenhoConteudoCirculo = new Paint();
	    desenhoConteudoCirculo.setColor( Color.BLUE );
	    desenhoConteudoCirculo.setAlpha( 30 );
	    desenhoConteudoCirculo.setAntiAlias( true );
	    desenhoConteudoCirculo.setStyle( Paint.Style.FILL );
	    
	    Paint desenhoLinhaCirculo = new Paint();
	    desenhoLinhaCirculo.setColor( Color.DKGRAY );
	    desenhoLinhaCirculo.setAntiAlias( true );
	    desenhoLinhaCirculo.setStyle( Paint.Style.STROKE );

	    canvas.drawCircle( ponto.x, ponto.y, raioCirculo, desenhoConteudoCirculo );
	    canvas.drawCircle( ponto.x, ponto.y, raioCirculo, desenhoLinhaCirculo );
	    super.draw( canvas, mapa, sombra );
	}
	
	
	@Override
	protected boolean onTap( int index ) {
	  /*OverlayItem item = listaOverlays.get( index );
	  AlertDialog.Builder dialog = new AlertDialog.Builder( getContexto() );
	  dialog.setTitle( item.getTitle() );
	  dialog.setMessage( item.getSnippet() );
	  dialog.show();*/
	  return true;
	}
	
	@Override
	protected OverlayItem createItem( int i ) {
		return listaOverlays.get( i );
	}

	@Override
	public int size() {
		return listaOverlays.size();
	}

	public Context getContexto() {
		return contexto;
	}

	public void setContexto( Context contexto ) {
		this.contexto = contexto;
	}

	public List<OverlayItem> getListaOverlays() {
		return listaOverlays;
	}

	public void setListaOverlays( List<OverlayItem> listaOverlays ) {
		this.listaOverlays = listaOverlays;
		populate();
	}

	public AreaOverlay getAreaOverlay() {
		return areaOverlay;
	}

	public void setAreaOverlay(AreaOverlay areaOverlay) {
		this.areaOverlay = areaOverlay;
	}
	
}
