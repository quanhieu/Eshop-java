package com.eshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Product;

@Repository
public class ProductDAO extends CrudDAO<Product, Integer>{

	@Override
	public Product findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		return findBy("FROM Product", 0, 0);
	}

	@Override
	public void create(Product entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Product entity) {
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
	public List<Product> findBy(String hql, int pageNo, int pageSize, Object... params) {
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
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

	public List<Product> findByPrice(Double min, Double max, boolean orderby, String prop) {
		String hql = "FROM Product WHERE unitPrice BETWEEN ? AND ? " + (orderby?" ORDER BY " + prop:" ORDER BY "+prop+" DESC");
		
		return findBy(hql, 0, 0, min, max);
	}
	
	public List<Product> findPage(int pageNo, int pageSize) {
		String hql = "FROM Product";
		return findBy(hql, pageNo, pageSize);
	}

	public List<Product> findByLatest() {
		String hql = "FROM Product ORDER BY productDate DESC";
		return findBy(hql, 0, 9);
	}

	public List<Product> findByBest() {
		String hql = "FROM Product p ORDER BY size(p.orderDetails) DESC";
//		String hql = "SELECT d.product"
//				+ " FROM OrderDetail d "
//				+ " GROUP BY d.product "
//				+ " ORDER BY sum(d.quantity*d.unitPrice) DESC";
		return findBy(hql, 0, 9);
	}

	public List<Product> findByKeywords(String keywords) {
		String hql = "FROM Product p "
				+ " WHERE p.name LIKE ? OR "
				+ " p.category.name LIKE ? OR "
				+ " p.category.nameVN LIKE ? ";
		String kw = "%"+keywords+"%";
		return findBy(hql, 0, 0, kw, kw, kw);
	}

	public List<Product> findByFavorites(String ids) {
		String hql = "FROM Product WHERE id IN ("+ids+")";
		return findBy(hql, 0, 0);
	}
}
