package com.iba.merchantSingUpService.service;

import java.util.List;
import java.util.Optional;

import com.iba.merchantSingUpService.model.Merchant;

public interface MerchantService {

	/**
	 * Method to save the collection of Merchants in the database.
	 * @param merchants
	 */
	public void saveAllMerchants(List<Merchant> merchants);

	/**
	 * Method to fetch all Merchants from the database.
	 * @return
	 */
	public Iterable<Merchant> findAllMerchants();


	public void deleteAllMerchants();

	public Optional<Merchant> findById(String id);


}