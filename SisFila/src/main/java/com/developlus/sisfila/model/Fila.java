package com.developlus.sisfila.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fila")
public class Fila implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date data;
	private List<ItemFila> itens;
	private TipoAtendimentoPai tipoAtendimentoPai;
	private TipoSenha tipoSenha;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "A data é obrigatória")
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fila")
	public List<ItemFila> getItens() {
		return itens;
	}

	public void setItens(List<ItemFila> itens) {
		this.itens = itens;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_atendimento_id")
	public TipoAtendimentoPai getTipoAtendimento() {
		return tipoAtendimentoPai;
	}

	public void setTipoAtendimento(TipoAtendimentoPai tipoAtendimentoPai) {
		this.tipoAtendimentoPai = tipoAtendimentoPai;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_senha_id")
	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fila other = (Fila) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}