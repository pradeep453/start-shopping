package com.shoppingbackends.dao;

import java.util.List;

import com.shoppingbackends.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> getList();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
	
	

}
