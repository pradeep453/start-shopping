package com.shoppingbackends.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoppingbackends.dao.CategoryDAO;
import com.shoppingbackends.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoppingbackends");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}

	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		System.out.println(categoryDAO);
		// adding first category
				//category.setId(2);
				category.setName("Television");
				category.setDescription("This is some description for Television ! ");
				category.setImageURL("CAT_1.png");
				
				
				assertEquals("Successfully added a category inside the table !",true,categoryDAO.addCategory(category));
				
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(2);
		
		assertEquals("Successfully  fetched a single category from the table the table !","Television",category.getName());
		
		
	}*/
	
	/*@Test
	public void testUpdateCategroy() {
		
		category = categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("Successfully updated a category inside the table ! !",true,categoryDAO.updateCategory(category));
		
	}
	*/
	/*@Test
	public void testdeleteCategroy() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully deleted a category inside the table ! !",true,categoryDAO.deleteCategory(category));
		
	}*/
	
	/*
	@Test
	public void testListCategroy() {
		
		assertEquals("Successfully fetched the list of categories from  the table ! !",1,categoryDAO.getList().size());
		
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		category = new Category();
		
		// adding  category
				category.setName("Laptop");
				category.setDescription("This is some description for Laptop ! ");
				category.setImageURL("CAT_1.png");
				
				
				assertEquals("Successfully added a category inside the table !",true,categoryDAO.addCategory(category));
				category = new Category();

				category.setName("Televison");
				category.setDescription("This is some description for Television ! ");
				category.setImageURL("CAT_2.png");
				
				
				assertEquals("Successfully added a category inside the table !",true,categoryDAO.addCategory(category));
			
				category = new Category();

				category.setName("Mobile");
				category.setDescription("This is some description for Mobile ! ");
				category.setImageURL("CAT_3.png");
				
				
				assertEquals("Successfully added a category inside the table !",true,categoryDAO.addCategory(category));
			
				// fetching and updating the category
				category = categoryDAO.get(2);
				category.setName("TV");
				
				assertEquals("Successfully updated a category inside the table ! !",true,categoryDAO.updateCategory(category));
				
				// delete the category
				assertEquals("Successfully deleted a category inside the table ! !",true,categoryDAO.deleteCategory(category));
				
				// fetching the list
				assertEquals("Successfully fetched the list of categories from  the table ! !",2,categoryDAO.getList().size());
				
				
				
				
	}


}
