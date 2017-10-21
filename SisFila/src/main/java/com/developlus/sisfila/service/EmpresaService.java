package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Empresa;
import com.developlus.sisfila.repository.EmpresaRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class EmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;

	@Transactional
	public void salvar(Empresa empresa) throws NegocioException {
		empresaRepository.save(empresa);
	}

	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

}
