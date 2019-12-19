package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ReportDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Object[]> inventoryByCategory(){
		Session session = factory.getCurrentSession();
		String hql = "SELECT p.category.nameVN,"
				+ " sum(p.quantity),"
				+ " sum(p.quantity*p.unitPrice),"
				+ " min(p.unitPrice),"
				+ " max(p.unitPrice),"
				+ " avg(p.unitPrice) "
				+ " FROM Product p "
				+ " GROUP BY p.category.nameVN";
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		return query.getResultList();
	}
	
	public List<Object[]> revenueByCategory(){
		Session session = factory.getCurrentSession();
		String hql = "SELECT d.product.category.nameVN,"
				+ " sum(d.quantity),"
				+ " sum(d.quantity*d.unitPrice),"
				+ " min(d.unitPrice),"
				+ " max(d.unitPrice),"
				+ " avg(d.unitPrice) "
				+ " FROM OrderDetail d "
				+ " GROUP BY d.product.category.nameVN";
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		return query.getResultList();
	}
	
	public List<Object[]> revenueByCustomer(){
		Session session = factory.getCurrentSession();
		String hql = "SELECT d.order.customer.id,"
				+ " sum(d.quantity),"
				+ " sum(d.quantity*d.unitPrice),"
				+ " min(d.unitPrice),"
				+ " max(d.unitPrice),"
				+ " avg(d.unitPrice) "
				+ " FROM OrderDetail d "
				+ " GROUP BY d.order.customer.id"
				+ " ORDER BY sum(d.quantity*d.unitPrice) DESC";
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		return query.getResultList();
	}
}
