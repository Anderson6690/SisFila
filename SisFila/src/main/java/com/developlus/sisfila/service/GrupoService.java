package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.repository.GrupoRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class GrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoRepository grupoRepository;
	
	@Transactional
	public void salvar(Grupo grupo) throws NegocioException {
		grupoRepository.merge(grupo);
	}
	
	public List<Grupo> listar() {
		return grupoRepository.findAll();
	}

}
