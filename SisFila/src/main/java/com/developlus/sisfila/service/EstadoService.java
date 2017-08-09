package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.repository.EstadoReṕository;
import com.developlus.sisfila.util.jpa.Transactional;

public class EstadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoReṕository estadoReṕository;

	@Transactional
	public void salvar(Estado estado) throws NegocioException {
		estadoReṕository.save(estado);
	}

	public List<Estado> listar() {
		return estadoReṕository.findAll();
	}

}
