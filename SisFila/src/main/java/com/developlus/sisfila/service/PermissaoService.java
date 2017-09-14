package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.developlus.sisfila.model.Permissao;
import com.developlus.sisfila.repository.PermissaoRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class PermissaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PermissaoRepository permissaoRepository;

	@Transactional
	public void salvar(Permissao permissao) throws NegocioException {
		permissaoRepository.save(permissao);
	}

	public List<Permissao> listar() {
		return permissaoRepository.findAll();
	}

}
