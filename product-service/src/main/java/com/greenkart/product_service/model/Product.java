package com.greenkart.product_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("products")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
