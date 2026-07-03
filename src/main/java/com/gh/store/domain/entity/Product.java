package com.gh.store.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@EqualsAndHashCode.Include
	private UUID id;
	
	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = false, length = 200)
	private String description;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal price;
	
	@Column(nullable = false)
	private Boolean avaliable = Boolean.TRUE;
}
