package com.parkhere.overlay;

import android.content.Context;

import com.google.android.maps.Overlay;
import com.parkhere.model.Marcador;

public class AreaOverlay extends Overlay{
	
	private final Double CONSTANTE_1E6 = 10E6;
	
	private Context contexto;
	private Marcador centro;
	private Marcador destino;
	private Double latideE6;
	private Double longitudeE6;
	private float raioCirculo;

	public AreaOverlay( Context contexto, Marcador centro, Marcador destino, float raioCirculo ) {
		this.contexto = contexto;
		this.centro = centro;
		this.destino = destino;
	    this.raioCirculo = raioCirculo;
	}
	
	public Context getContexto() {
		return contexto;
	}

	public void setContexto( Context contexto ) {
		this.contexto = contexto;
	}

	public Marcador getCentro() {
		return centro;
	}

	public void setCentro( Marcador centro ) {
		this.centro = centro;
	}

	public Double getLatideE6() {
		return latideE6;
	}

	public void setLatideE6( Double latideE6 ) {
		this.latideE6 = latideE6;
	}

	public Double getLongitudeE6() {
		return longitudeE6;
	}

	public void setLongitudeE6( Double longitudeE6 ) {
		this.longitudeE6 = longitudeE6;
	}

	public float getRaioCirculo() {
		return raioCirculo;
	}

	public void setRaioCirculo( float raioCirculo ) {
		this.raioCirculo = raioCirculo;
	}

	public Double getCONSTANTE_1E6() {
		return CONSTANTE_1E6;
	}

	public Marcador getDestino() {
		return destino;
	}

	public void setDestino(Marcador destino) {
		this.destino = destino;
	}
	
		
}
