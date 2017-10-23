package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developlus.sisfila.model.Estado;
import com.developlus.sisfila.repository.helper.EstadoQueries;

public interface EstadoRepository extends JpaRepository<Estado, Long>, EstadoQueries {

}
