package com.developlus.sisfila.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_atendimento")
public class TipoAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private TipoAtendimentoPai tipoAtendimentoPai;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "O tipo de atendimento é obrigatório")
	@ManyToOne
	@JoinColumn(name = "tipo_atendimento_pai_id")
	public TipoAtendimentoPai getTipoAtendimentoPai() {
		return tipoAtendimentoPai;
	}

	public void setTipoAtendimentoPai(TipoAtendimentoPai tipoAtendimentoPai) {
		this.tipoAtendimentoPai = tipoAtendimentoPai;
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
		TipoAtendimento other = (TipoAtendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}