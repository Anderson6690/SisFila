package com.developlus.sisfila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.developlus.sisfila.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
