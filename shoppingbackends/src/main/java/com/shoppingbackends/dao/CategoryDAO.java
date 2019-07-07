package com.shoppingbackends.dao;

import java.util.List;

import com.shoppingbackends.dto.Category;

public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> getList();
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);

	
}
