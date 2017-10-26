package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.developlus.sisfila.model.TipoAtendimentoPai;
import com.developlus.sisfila.repository.TipoAtendimentoPaiRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class TipoAtendimentoPaiService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoPaiRepository tipoAtendimentoPaiRepository;

	@Transactional
	public void salvar(TipoAtendimentoPai tipoAtendimentoPai) throws NegocioException {
		tipoAtendimentoPaiRepository.save(tipoAtendimentoPai);
	}

	public List<TipoAtendimentoPai> listar() {
		return tipoAtendimentoPaiRepository.findAll();
	}

}
