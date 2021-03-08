package com.tts.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.crossstore.ChangeSetPersister;


@Service
public class ProductService {
   
	@Autowired
	private ProductRepository producyRepository;
	
	public List<product> findAll(){
		return productRepository.findAll(){
	}
		
 public List<String> findDistinctBrands (){
	return new ArrayList<> (productRepository.findDistinctBrands());
 
	 
 }
 
	public List<String> findDistinctCategories (){
		return new ArrayList<>(productRepository.findDistinctCategories());
     
}
   public List<Product> findByBrandAndOrCategory(String brand, String category){
	   if(category == null && brand == null) {
		   return productRepository.findAll();
	   }else if (category == null) {
		   return productRepository.findByBrand);
	   }else if (brand == null) {
		   return productionRepository.findByCategory(category);
		   
	   }else {
		   return productRepository.ByBrandAndCategory(brand, category);
		   
	   }
   }
	  
   public Product findById(long id) {
	   return productRepository.findById();
   }
	
	public void deleteById(long id) {
	productRepository.deletsById(id);
	
	}
	
	}
		