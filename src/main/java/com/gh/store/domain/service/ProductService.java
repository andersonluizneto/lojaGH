package com.gh.store.domain.service;

import org.springframework.stereotype.Service;

import com.gh.store.domain.entity.Product;
import com.gh.store.domain.repository.ProductRepository;
import com.gh.store.mapper.ProductMapper;
import com.gh.store.mapper.request.ProductRequest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	@Transactional
	public Product create(ProductRequest request) {
		Product product = mapper.toEntity(request);
		return repository.save(product);
	}
}
