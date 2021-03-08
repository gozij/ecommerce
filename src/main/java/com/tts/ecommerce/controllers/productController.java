package com.tts.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.services.ProductService;

@Controller
public class productController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}" )
	public String show(@pathVariable int id, Model model) {
		Product product = productService.findById(id);
		model.addAllAttributes(product);
		return "product";
	}
    @RequestMapping(value = "/product", method = {RequestMethod.POST,
 RequestMethod.PUT})
    public String createOrUpdated (@valid Product product) {
    	ProductService.save(product);
    	return "redirect:/product/" + product.getId();
    }
}
