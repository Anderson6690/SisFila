package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.TipoAtendimento;
import com.developlus.sisfila.repository.TipoAtendimentoRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class TipoAtendimentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoAtendimentoRepository tipoAtendimentoRepository;

	@Transactional
	public void salvar(TipoAtendimento tipoAtendimento) throws NegocioException {
		tipoAtendimentoRepository.save(tipoAtendimento);
	}

	public List<TipoAtendimento> listar() {
		return tipoAtendimentoRepository.findAll();
	}

}
