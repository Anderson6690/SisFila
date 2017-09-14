package com.developlus.sisfila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.developlus.sisfila.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
}
