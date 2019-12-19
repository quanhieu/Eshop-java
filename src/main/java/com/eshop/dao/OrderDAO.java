package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Customer;
import com.eshop.entity.Order;
import com.eshop.entity.OrderDetail;
import com.eshop.entity.Product;
import com.eshop.service.ShoppingCartService;

@Repository
public class OrderDAO extends CrudDAO<Order, Integer>{

	@Override
	public Order findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Order.class, id);
	}

	@Override
	public List<Order> findAll() {
		return findBy("FROM Order", 0, 0);
	}

	@Override
	public void create(Order entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Order entity) {
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
	public List<Order> findBy(String hql, int pageNo, int pageSize, Object... params) {
		Session session = factory.getCurrentSession();
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
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

	@Autowired
	OrderDetailDAO ddao;
	
	public void create(Order order, ShoppingCartService cart) {
		Session session = factory.getCurrentSession();
		session.save(order);
		for(Product p : cart.getItems()) {
			OrderDetail d = new OrderDetail();
			d.setProduct(p);
			d.setUnitPrice(p.getUnitPrice());
			d.setQuantity(p.getQuantity());
			d.setOrder(order);
			
			ddao.create(d);
		}
	}

	public List<Order> findByCustomer(Customer customer) {
		String hql = "FROM Order WHERE customer.id=? ORDER BY orderDate DESC";
		return this.findBy(hql, 0, 0, customer.getId());
	}

	public List<Product> findItemsByCustomer(Customer customer) {
		String hql = "SELECT DISTINCT d.product FROM OrderDetail d "
				+ " WHERE d.order.customer.id=?";
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter(0, customer.getId());
		return query.getResultList();
	}

}
