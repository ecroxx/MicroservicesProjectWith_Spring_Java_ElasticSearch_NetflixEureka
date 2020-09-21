package com.iba.merchantSingUpService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Component
// ElasticSearch annotation.
@Document(indexName= "products", type= "product")
public class Merchant {

	@Id
	private String id;

	private String merchantName;
	private String type;
	private String ownerName;
	private String adress ;
	private String phoneNumber;
	private String email;
	private String password;



	public Merchant() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Merchant{" +
				"id='" + id + '\'' +
				", merchantName='" + merchantName + '\'' +
				", type='" + type + '\'' +
				", ownerName='" + ownerName + '\'' +
				", adress='" + adress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}