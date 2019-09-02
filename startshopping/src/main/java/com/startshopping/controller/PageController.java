package com.startshopping.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingbackends.dao.CategoryDAO;
import com.shoppingbackends.dao.ProductDAO;
import com.shoppingbackends.dto.Category;
import com.shoppingbackends.dto.Product;
import com.startshopping.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Home");
		
		logger.info("+++++++++++++Inside PageController index method - INFO");
		logger.debug("-----------Inside PageController index method - DEBUG");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.getList());

		mv.addObject("userClickHome", true);

		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		return mv;
	}
	


	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the products and based on category 
	 * */
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.getList());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// category DAO to fetch a single category
		
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.getList());
		
		//passing the single category object
		mv.addObject("category",category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	 /*
	  * 
	  *  Viewing a single product
	  */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews()+1);
		//update the view
		productDAO.updateProduct(product);
		
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		
		return mv;
		
	}
	public static void main(String args[]) {
		String result = "{\"result\":[{\"subjectNL\":\"Uw aanvraag werd succesvol ingediend.\",\"endDate\":\"2019-03-27\",\"messageID\":\"17440\",\"pinNumber\":\"250739\",\"employeeID\":\"523177\",\"contentNL\":\"Uw aanvraag Jaarlijks verlof van 2019-03-27 tot 2019-03-27 werd succesvol ingediend. \",\"supervisorID\":\"197483\",\"priority\":\"0\",\"transactionID\":\"99\",\"subjectFR\":\"Votre demande a été soumise.\",\"name\":\"Sven CLAERHOUT\",\"contentFR\":\"Votre demande de Jaarlijks verlof de 2019-03-27 à 2019-03-27 a été soumise. \",\"category\":\"ABSENCE\",\"notificationDateTime\":\"null\",\"startDate\":\"2019-03-27\"},{\"subjectNL\":\"Uw aanvraag werd succesvol ingediend.\",\"endDate\":\"2019-03-27\",\"messageID\":\"17440\",\"pinNumber\":\"250739\",\"employeeID\":\"509145\",\"contentNL\":\"Uw aanvraag Jaarlijks verlof van 2019-03-27 tot 2019-03-27 werd succesvol ingediend. \",\"supervisorID\":\"137219\",\"priority\":\"0\",\"transactionID\":\"100\",\"subjectFR\":\"Votre demande a été soumise.\",\"name\":\"Glenn DE VOGELAERE\",\"contentFR\":\"Votre demande de Jaarlijks verlof de 2019-03-27 à 2019-03-27 a été soumise. \",\"category\":\"ABSENCE\",\"notificationDateTime\":\"null\",\"startDate\":\"2019-03-27\"},{\"subjectNL\":\"Je aanvraag werd goedgekeurd\",\"endDate\":\"2019-05-03\",\"messageID\":\"17440\",\"pinNumber\":\"251370\",\"employeeID\":\"211894\",\"contentNL\":\"Je aanvraag Rust van 02/05/2019 tot 03/05/2019 werd goedgekeurd door Tina Van Cappellen.\\r\\n\r\n" + 
				"pour moi ok\",\"supervisorID\":\"211894\",\"priority\":\"0\",\"transactionID\":\"214\",\"subjectFR\":\"La demande a été approuvé\",\"name\":\"Corine VANLAER\",\"contentFR\":\"La demande Repos de 02/05/2019 à 03/05/2019 a été approuvé par Tina Van Cappellen.\\n\r\n" + 
				"pour moi ok\",\"category\":\"ABSENCE\",\"notificationDateTime\":\"2019-04-29\",\"startDate\":\"2019-05-02\"},{\"subjectNL\":\"Je aanvraag is ongeldig.\",\"endDate\":\"2019-05-24\",\"messageID\":\"17440\",\"pinNumber\":\"251094\",\"employeeID\":\"242471\",\"contentNL\":\"An error occurred while constructing the customized forecasting message for Absence Take: EXV. Please contact your system administrator.\",\"supervisorID\":\"236417\",\"priority\":\"0\",\"transactionID\":\"507\",\"subjectFR\":\"La demande n'est pas valide.\",\"name\":\"Elke MAYENS\",\"contentFR\":\"GetMessageText: No default message. (0,0)\",\"category\":\"ABSENCE\",\"notificationDateTime\":\"2019-05-21\",\"startDate\":\"2019-05-24\"},{\"subjectNL\":\"Je aanvraag is ongeldig.\",\"endDate\":\"2019-09-06\",\"messageID\":\"17440\",\"pinNumber\":\"250739\",\"employeeID\":\"362401\",\"contentNL\":\"Afwezigheid ANN CT van 06/09/2019 tot 06/09/2019 is verworpen omdat deze een negatieve impact heeft op een vroeger aangevraagde afwezigheid\",\"supervisorID\":\"210646\",\"priority\":\"0\",\"transactionID\":\"604\",\"subjectFR\":\"La demande n'est pas valide.\",\"name\":\"Farida AKALAY\",\"contentFR\":\"Absence ANN CT pour la période de 06/09/2019 au 06/09/2019 est rejetée car elle a un impact négatif sur une absence demandée précédemment\",\"category\":\"ABSENCE\",\"notificationDateTime\":\"2019-06-06\",\"startDate\":\"2019-09-06\"},{\"subjectNL\":\"Je aanvraag is ongeldig.\",\"endDate\":\"2019-07-20\",\"messageID\":\"17440\",\"pinNumber\":\"250739\",\"employeeID\":\"362401\",\"contentNL\":\"Afwezigheid ANN CT van 19/07/2019 tot 20/07/2019 is verworpen omdat deze een negatieve impact heeft op een vroeger aangevraagde afwezigheid\",\"supervisorID\":\"210646\",\"priority\":\"0\",\"transactionID\":\"605\",\"subjectFR\":\"La demande n'est pas valide.\",\"name\":\"Farida AKALAY\",\"contentFR\":\"Absence ANN CT pour la période de 19/07/2019 au 20/07/2019 est rejetée car elle a un impact négatif sur une absence demandée précédemment\",\"category\":\"ABSENCE\",\"notificationDateTime\":\"2019-06-06\",\"startDate\":\"2019-07-19\"}]}";
		
		result = "{\"NotificationsOutput\":{\"$rootArray\":[{\"transactionID\":\"605\",\"employeeID\":\"362401\",\"supervisorID\":\"210646\",\"name\":\"Farida AKALAY\",\"startDate\":\"2019-07-19\",\"endDate\":\"2019-07-20\",\"category\":\"ABSENCE\",\"priority\":\"0\",\"notificationDateTime\":\"2019-06-06\",\"messageID\":\"17440\",\"pinNumber\":\"250739\",\"subjectNL\":\"Je aanvraag  is ongeldig.\",\"subjectFR\":\"La demande  n'est pas valide.\",\"contentNL\":\"Afwezigheid ANN CT van 19/07/2019 tot 20/07/2019 is verworpen omdat deze een negatieve impact heeft op een vroeger aangevraagde afwezigheid\",\"contentFR\":\"Absence ANN CT pour la période de 19/07/2019 au 20/07/2019 est rejetée car elle a un impact négatif sur une absence demandée précédemment\"}]}}";
				System.out.println(result);
		JSONObject jsonObject = new JSONObject(result);
		try {
			System.out.println(jsonObject);
			Timestamp ts=new Timestamp(1563962155481l);
			Date date=new Date(ts.getTime());
			System.out.println(date);
			
			System.out.println(new Date((new Timestamp(1563962155481l)).getTime()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
