package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.repository.EstadoRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class EstadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoRepository estadoRepository;

	@Transactional
	public void salvar(Estado estado) throws NegocioException {
		estadoRepository.save(estado);
	}

	public List<Estado> listar() {
		return estadoRepository.findAll();
	}

}
