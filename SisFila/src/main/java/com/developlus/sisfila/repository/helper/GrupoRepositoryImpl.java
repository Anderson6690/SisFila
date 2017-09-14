package com.developlus.sisfila.repository.helper;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.developlus.sisfila.model.Grupo;

public class GrupoRepositoryImpl implements GrupoQueries {

	@Inject
	private EntityManager manager;

	@Override
	public Grupo merge(Grupo grupo) {
		return manager.merge(grupo);
	}

}
