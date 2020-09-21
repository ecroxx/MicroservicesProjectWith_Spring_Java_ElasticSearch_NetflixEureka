package com.iba.merchantSingUpService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.merchantSingUpService.model.Merchant;
import com.iba.merchantSingUpService.service.MerchantService;

@RestController
@RequestMapping(value= "/Merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	/**
	 * Method to save the Merchants in the database.
	 * @param merchants
	 * @return
	 */
	@PostMapping(value= "/saveAll")
	public String saveMerchant(@RequestBody List<Merchant> merchants) {
		merchantService.saveAllMerchants(merchants);
		return "Records saved in the db.";
	}

	/**
	 * Method to fetch all Merchants from the database.
	 * @return
	 */
	@GetMapping(value= "/getAll")
	public Iterable<Merchant> getAllMerchants() {
		return merchantService.findAllMerchants();
	}

	@GetMapping(value= "/deleteAll")
	public void deleteAllMerchants() {
		 merchantService.deleteAllMerchants();
	}

	@GetMapping(value= "/get/{merchantId}")
	public Optional<Merchant> findMerchantById(@PathVariable(name= "merchantId") String merchantId) {
		return merchantService.findById(merchantId);
	}



	/*
	@GetMapping(value= "/findbydesignation/{Merchant-designation}")
	public Iterable<Merchant> getByDesignation(@PathVariable(name= "Merchant-designation") String designation) {
		return merchantService.findByDesignation(designation);
	}
	*/
}