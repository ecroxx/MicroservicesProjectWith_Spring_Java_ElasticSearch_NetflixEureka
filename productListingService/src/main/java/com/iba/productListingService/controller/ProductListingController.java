package com.iba.productListingService.controller;

import com.iba.productListingService.model.Product;
import com.iba.productListingService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/product")
public class ProductListingController {

	@Autowired
    ProductService productService;

	/**
	 * Method to save the Products in the database.
	 * @param products
	 * @return
	 */
	@PostMapping(value= "/saveAll")
	public String saveProduct(@RequestBody List<Product> products) {
		productService.saveAllProducts(products);
		return "Records saved in the db.";
	}

	/**
	 * Method to fetch all Products from the database.
	 * @return
	 */
	@GetMapping(value= "/getAll")
	public Iterable<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping(value= "/deleteAll")
	public void deleteAllProducts() {
		 productService.deleteAllProducts();
	}

	@GetMapping(value= "/get/{productId}")
	public Optional<Product> findProductById(@PathVariable(name= "productId") String productId) {
		return productService.findById(productId);
	}

	@GetMapping(value= "/getAllByPrice")
	public Iterable<Product> getAllProductsByPrice() {
		return productService.findAllProductsByPrice();
	}

	@GetMapping(value= "/getAllByInventory")
	public Iterable<Product> getAllProductsByInventory() {
		return productService.findAllProductsByInventory();
	}


	/*
	@GetMapping(value= "/findbydesignation/{Product-designation}")
	public Iterable<Product> getByDesignation(@PathVariable(name= "Product-designation") String designation) {
		return productService.findByDesignation(designation);
	}
	*/
}