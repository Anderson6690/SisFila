package com.developlus.sisfila.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.developlus.sisfila.model.Usuario;
import com.developlus.sisfila.repository.UsuarioRepository;
import com.developlus.sisfila.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void salvar(Usuario usuario) throws NegocioException {
		usuarioRepository.save(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

}
