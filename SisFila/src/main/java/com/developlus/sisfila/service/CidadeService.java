package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Cidade;
import com.developlus.sisfila.repository.CidadeRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class CidadeService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeRepository cidadeRepository;

	@Transactional
	public void salvar(Cidade cidade) throws NegocioException {
		cidadeRepository.save(cidade);
	}

	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

}