package com.developlus.sisfila.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String telefone;
	private Cidade cidade;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private Date dataCadastro;
	private boolean ativo = true;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(max = 50, message = "O email deve conter no náximo 50 caracteres")
	@NotBlank(message = "O email é obrigatória")
	@Email(message = "O email informado não é valido")
	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Size(min = 10, max = 16, message = "Informe um telefone válido")
	@NotBlank(message = "O telefone é obrigatória")
	@Column(length = 16)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@NotNull(message = "Selecione uma cidade")
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Size(max = 100, message = "O logradouro deve conter no náximo 100 caracteres")
	@NotBlank(message = "O logradouro é obrigatória")
	@Column(length = 100)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Size(max = 4, message = "O número deve conter no náximo 4 caracteres")
	@NotBlank(message = "O número é obrigatório")
	@Column(length = 4)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Size(max = 100, message = "O bairro deve conter no náximo 100 caracteres")
	@NotBlank(message = "O bairro é obrigatório")
	@Column(length = 100)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Size(min = 9, max = 9, message = "Informe um CEP válido")
	@NotBlank(message = "O CEP é obrigatório")
	@Column(length = 9)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@PrePersist
	private void gerarData() {
		if (this.dataCadastro == null) {
			this.dataCadastro = new Date();
		}
	}
	
}
