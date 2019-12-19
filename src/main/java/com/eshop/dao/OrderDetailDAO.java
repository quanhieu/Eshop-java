package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eshop.entity.OrderDetail;

@Repository
public class OrderDetailDAO extends CrudDAO<OrderDetail, Integer>{

	@Override
	public OrderDetail findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(OrderDetail.class, id);
	}

	@Override
	public List<OrderDetail> findAll() {
		return findBy("FROM OrderDetail", 0, 0);
	}

	@Override
	public void create(OrderDetail entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(OrderDetail entity) {
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
	public List<OrderDetail> findBy(String hql, int pageNo, int pageSize, Object... params) {
		Session session = factory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
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
