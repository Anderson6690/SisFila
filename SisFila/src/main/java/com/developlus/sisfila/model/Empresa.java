package com.developlus.sisfila.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "empresa")
public class Empresa extends PessoaJuridica {

	private static final long serialVersionUID = 1L;

	private String latitude;
	private String longitude;

	@NotBlank(message = "A latitude é obrigatória")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@NotBlank(message = "A longitude é obrigatória")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}