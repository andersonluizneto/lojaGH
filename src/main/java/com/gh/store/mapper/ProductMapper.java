package com.gh.store.mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.gh.store.domain.entity.Product;
import com.gh.store.mapper.request.ProductRequest;
import com.gh.store.mapper.response.ProductResponse;

@Mapper(unmappedSourcePolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface ProductMapper {
	
	Product toEntity(ProductRequest request);
	
	ProductResponse toReponse(Product product);
}


