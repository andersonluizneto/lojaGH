package com.gh.store.mapper.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequest(
		@NotNull
		@Size(min = 3, max = 80)
		String name,
		
		@NotNull
		@Size(max = 200)
		String description,
		
		@NotNull
		@Positive
		@Digits(integer=12, fraction = 2)
		BigDecimal price, 
		
		Boolean available
) {}
