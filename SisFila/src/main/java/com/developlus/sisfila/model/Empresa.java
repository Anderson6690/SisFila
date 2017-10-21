package com.developlus.sisfila.model;

import javax.persistence.Entity;

@Entity(name = "empresa")
public class Empresa extends PessoaJuridica {

	private static final long serialVersionUID = 1L;

	private String latitude;
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}