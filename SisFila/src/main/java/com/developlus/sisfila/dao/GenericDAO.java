package com.developlus.sisfila.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDAO<T> implements DAO<T>{

	@Inject
	private EntityManager em;
	
	private Class<T> classe;
	
	private Criteria criteria;
	private Session session;
	
	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	@Transactional
	public T salvar(T t) {
		return em.merge(t);
	}
	
	@Override 
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		session = em.unwrap(Session.class);
		criteria = session.createCriteria(classe);
		
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listar(String campo, Object value) {
		session = em.unwrap(Session.class);
		criteria = session.createCriteria(classe);
		
		criteria.add(Restrictions.eq(campo, value));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getPorParametro(String campo, Object value) {
		session = em.unwrap(Session.class);
		criteria = session.createCriteria(classe);
		
		criteria.add(Restrictions.eq(campo, value));
		
		return (T) criteria.uniqueResult();
	}

}
