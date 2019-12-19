package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Customer;

@Repository
public class CustomerDAO extends CrudDAO<Customer, String>{

	@Override
	public Customer findById(String id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public List<Customer> findAll() {
		return findBy("FROM Customer", 0, 0);
	}

	@Override
	public void create(Customer entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Customer entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(String... ids) {
		Session session = factory.getCurrentSession();
		for(String id : ids) {
			session.delete(findById(id));
		}
	}

	@Override
	public List<Customer> findBy(String hql, int pageNo, int pageSize, Object... params) {
		Session session = factory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
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

	public List<Customer> findPage(Integer pageNo, Integer pageSize) {
		String hql = "FROM Customer";
		return this.findBy(hql, pageNo, pageSize);
	}

	public long getPageCount(int pageSize) {
		String hql = "SELECT count(e) FROM Customer e";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql, Long.class);
		long rowCount = query.getSingleResult();
		long pageCount = (long) Math.ceil(1.0*rowCount/pageSize);
		return pageCount;
	}

}
