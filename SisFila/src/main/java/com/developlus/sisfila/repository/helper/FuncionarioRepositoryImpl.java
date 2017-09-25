package com.developlus.sisfila.repository.helper;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.developlus.sisfila.filter.FuncionarioFilter;
import com.developlus.sisfila.model.Funcionario;

public class FuncionarioRepositoryImpl implements FuncionarioQueries {

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> filtrar(FuncionarioFilter filtro) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Funcionario.class);

		if (filtro != null) {

			if (filtro.getId() != null) {
				criteria.add(Restrictions.idEq(filtro.getId()));
			}

			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

		}

		return criteria.list();
	}

}
