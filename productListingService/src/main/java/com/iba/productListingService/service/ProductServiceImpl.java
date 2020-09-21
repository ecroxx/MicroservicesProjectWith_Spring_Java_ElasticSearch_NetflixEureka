package com.iba.productListingService.service;

import com.iba.productListingService.model.Product;
import com.iba.productListingService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	// The dao repository will use the Elastic-Search-Repository to perform the database operations.
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveAllProducts(List<Product> products) {
		productRepository.saveAll(products);
	}

	@Override
	public Iterable<Product> findAllProducts() {
		return productRepository.findAll(PageRequest.of(0,2));
	}

	@Override
	public Iterable<Product> findAllProductsByPrice() {
		Pageable sortedByPriceDesc =
				PageRequest.of(0, 10, Sort.by("price").descending());
		 return productRepository.findAll(sortedByPriceDesc);
	}

	@Override
	public Iterable<Product> findAllProductsByInventory() {
		Pageable sortedByPriceDesc =
				PageRequest.of(0, 10, Sort.by("inventory").descending());
		 Iterable<Product> productList= productRepository.findAll(sortedByPriceDesc);
		return ((Page<Product>) productList).getTotalElements() > 4 ? productList : new ArrayList<>();
	}




	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

	@Override
	public Optional<Product> findById(String id) {
		return productRepository.findById(id);
	}
}