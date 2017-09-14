package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developlus.sisfila.model.Grupo;
import com.developlus.sisfila.repository.helper.GrupoQueries;

public interface GrupoRepository extends JpaRepository<Grupo, Long>, GrupoQueries {

}
