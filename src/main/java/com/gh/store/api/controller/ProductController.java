package com.gh.store.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gh.store.domain.entity.Product;
import com.gh.store.domain.service.ProductService;
import com.gh.store.mapper.ProductMapper;
import com.gh.store.mapper.request.ProductRequest;
import com.gh.store.mapper.response.ProductResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;
	private final ProductMapper mapper;
	@PostMapping
	public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request){
		Product product = service.create(request);
		ProductResponse response = mapper.toReponse(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
				
	}
}
