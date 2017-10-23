package com.developlus.sisfila.repository.helper;

import java.util.List;

import com.developlus.sisfila.filter.EstadoFilter;
import com.developlus.sisfila.model.Estado;

public interface EstadoQueries {

	public List<Estado> filtrar(EstadoFilter filtro);
	
}
