package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Category;

@Repository
public class CategoryDAO extends CrudDAO<Category, Integer>{
	@Override
	public Category findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		return findBy("FROM Category", 0, 0);
	}

	@Override
	public void create(Category entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Category entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Integer... ids) {
		Session session = factory.getCurrentSession();
		for(Integer id : ids) {
			session.delete(findById(id));
		}
	}

	@Override
	public List<Category> findBy(String hql, int pageNo, int pageSize, Object... params) {
		Session session = factory.getCurrentSession();
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		if(pageNo >= 0 && pageSize > 0) {
			query.setFirstResult(pageNo*pageSize);
			query.setMaxResults(pageSize);
		}
		if(params.length > 0) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.getResultList();
	}

}
