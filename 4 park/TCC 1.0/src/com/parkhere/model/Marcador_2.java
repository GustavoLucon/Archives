package com.parkhere.model;

import com.google.android.maps.GeoPoint;

/**
 *	@author Michel Souza. 
 * 	@since 05/09/2012
 * 	@category POJO
 * 	@version 1.0
 **/
public class Marcador extends GeoPoint{
	
	private int latitudeE6;
	private int longitudeE6;
	
	public Marcador(int latitudeE6, int longitudeE6) {
		super(latitudeE6, longitudeE6);
		this.latitudeE6 = latitudeE6;
		this.longitudeE6 = longitudeE6;
	}

	public int getLatitudeE6() {
		return this.latitudeE6;
	}

	public void setLatitudeE6(int latitudeE6) {
		this.latitudeE6 = latitudeE6;
	}

	public int getLongitudeE6() {
		return longitudeE6;
	}

	public void setLongitudeE6(int longitudeE6) {
		this.longitudeE6 = longitudeE6;
	}
	
}
