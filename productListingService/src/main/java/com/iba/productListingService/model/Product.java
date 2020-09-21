package com.iba.productListingService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Component
// ElasticSearch annotation.
@Document(indexName= "products", type= "product")
public class Product {

	@Id
	private String id;

	private String name;
	private String category;
	private String description;
	private Float price;
	private Long inventory;
	private String paymentOption;
	private String deliveryOption;



	public Product() { }

	public Product(String id, String name, String category, String description, Float price, Long inventory, String paymentOption, String deliveryOption) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.inventory = inventory;
		this.paymentOption = paymentOption;
		this.deliveryOption = deliveryOption;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getInventory() {
		return inventory;
	}

	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getDeliveryOption() {
		return deliveryOption;
	}

	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", inventory=" + inventory +
				", paymentOption='" + paymentOption + '\'' +
				", deliveryOption='" + deliveryOption + '\'' +
				'}';
	}
}