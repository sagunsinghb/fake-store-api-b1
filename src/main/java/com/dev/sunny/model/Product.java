package com.dev.sunny.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private Category category;
    private String image;
}
