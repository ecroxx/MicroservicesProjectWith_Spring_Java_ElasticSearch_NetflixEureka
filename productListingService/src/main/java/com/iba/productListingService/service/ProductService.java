package com.iba.productListingService.service;

import com.iba.productListingService.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	/**
	 * Method to save the collection of Products in the database.
	 * @param products
	 */
	public void saveAllProducts(List<Product> products);

	/**
	 * Method to fetch all Products from the database.
	 * @return
	 */
	public Iterable<Product> findAllProducts();


	public void deleteAllProducts();

	public Optional<Product> findById(String id);

	public Iterable<Product> findAllProductsByPrice();

	public Iterable<Product> findAllProductsByInventory();

}