package com.developlus.sisfila.repository.helper;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.developlus.sisfila.filter.UsuarioFilter;
import com.developlus.sisfila.model.Usuario;

public interface UsuarioQueries {
	
	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);

	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable);
}
