package com.developlus.sisfila.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String escricaoEstadual;
	
	@Column(length = 100)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(length = 100)
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	@Column(length = 18)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(length = 20)
	public String getEscricaoEstadual() {
		return escricaoEstadual;
	}

	public void setEscricaoEstadual(String escricaoEstadual) {
		this.escricaoEstadual = escricaoEstadual;
	}

}
