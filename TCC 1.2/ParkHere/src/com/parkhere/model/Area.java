package com.parkhere.model;

import java.util.List;

/**
 *	@author Michel Souza. 
 * 	@since 05/09/2012
 * 	@category POJO
 * 	@version 1.0
 **/
public class Area {
	
	private Marcador centroArea;
	private List<Marcador> listaMarcadores;
	
	public Marcador getCentroArea() {
		return centroArea;
	}
	
	public void setCentroArea( Marcador centroArea ) {
		this.centroArea = centroArea;
	}
	
	public List<Marcador> getListaMarcadores() {
		return listaMarcadores;
	}
	
	public void setListaMarcadores( List<Marcador> listaMarcadores ) {
		this.listaMarcadores = listaMarcadores;
	}
}
