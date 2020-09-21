package com.iba.merchantSingUpService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iba.merchantSingUpService.model.Merchant;
import com.iba.merchantSingUpService.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	// The dao repository will use the Elastic-Search-Repository to perform the database operations.
	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public void saveAllMerchants(List<Merchant> merchants) {
		merchantRepository.saveAll(merchants);
	}

	@Override
	public Iterable<Merchant> findAllMerchants() {
		return merchantRepository.findAll(PageRequest.of(0,10));
	}

	@Override
	public void deleteAllMerchants() {
		merchantRepository.deleteAll();
	}

	@Override
	public Optional<Merchant> findById(String id) {
		return merchantRepository.findById(id);
	}
}