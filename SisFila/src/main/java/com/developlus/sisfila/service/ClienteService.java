package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Cliente;
import com.developlus.sisfila.repository.ClienteRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository clienteRepository;

	@Transactional
	public void salvar(Cliente cliente) throws NegocioException {

		if (cliente.getNome() == null || cliente.getNome().trim().equals("")) {
			throw new NegocioException("O nome é obrigatório");
		}

		clienteRepository.save(cliente);
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

}
