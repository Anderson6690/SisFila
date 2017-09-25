package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.developlus.sisfila.model.TipoSenha;
import com.developlus.sisfila.repository.TipoSenhaRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class TipoSenhaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoSenhaRepository tipoSenhaRepository;

	@Transactional
	public void salvar(TipoSenha tipoSenha) throws NegocioException {
		tipoSenhaRepository.save(tipoSenha);
	}

	public List<TipoSenha> listar() {
		return tipoSenhaRepository.findAll();
	}

}
