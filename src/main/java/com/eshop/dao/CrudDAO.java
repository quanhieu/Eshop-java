package com.eshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
abstract public class CrudDAO<E, K> {
	@Autowired
	protected SessionFactory factory;
	
	abstract public E findById(K id);
	abstract public List<E> findAll();
	abstract public void create(E entity);
	abstract public void update(E entity);
	abstract public void delete(K...ids);
	abstract public List<E> findBy(String hql, int pageNo, int pageSize, Object...params);
}
