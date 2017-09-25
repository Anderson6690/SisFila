package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developlus.sisfila.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
