package com.developlus.sisfila.dao;

import java.util.List;

public interface DAO<T>{
	
	public T salvar(T t);

	public List<T> listar();

	public List<T> listar(String campo, Object value);
	
	public T getPorParametro(String campo, Object value);
		
}
