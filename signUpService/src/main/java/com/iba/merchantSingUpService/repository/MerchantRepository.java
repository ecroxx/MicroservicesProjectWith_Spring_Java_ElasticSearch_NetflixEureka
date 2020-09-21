package com.iba.merchantSingUpService.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.iba.merchantSingUpService.model.Merchant;

@Repository
public interface MerchantRepository extends ElasticsearchRepository<Merchant, String> {

}