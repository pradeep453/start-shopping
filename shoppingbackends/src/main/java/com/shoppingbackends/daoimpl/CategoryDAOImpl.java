package com.shoppingbackends.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingbackends.dao.CategoryDAO;
import com.shoppingbackends.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("deprecation")
	@Override
	public List<Category> getList() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*Getting single category based on id*/
	
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean addCategory(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			// update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			// delete the category to the database table
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
