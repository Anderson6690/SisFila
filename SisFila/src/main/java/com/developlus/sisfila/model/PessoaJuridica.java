package com.developlus.sisfila.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String inscricaoEstadual;

	@Size(max = 100, message = "A razão social deve conter no náximo 100 caracteres")
	@NotBlank(message = "A razão social é obrigatória")
	@Column(name = "razao_social", length = 100)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Size(max = 100, message = "A fantasia deve conter no náximo 100 caracteres")
	@Column(length = 100)
	@NotBlank(message = "A fantasia é obrigatória")
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	@Size(max = 18, message = "CNPJ inválido")
	@NotBlank(message = "O CNPJ  é obrigatório")	
	@Column(length = 18)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Size(max = 20, message = "A inscrição estadual deve conter no náximo 20 caracteres")
	@Column(name = "inscricao_estadual", length = 20)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

}
