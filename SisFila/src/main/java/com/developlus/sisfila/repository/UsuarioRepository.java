package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.developlus.sisfila.model.Usuario;
import com.developlus.sisfila.repository.helper.UsuarioQueries;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioQueries {
	
}
