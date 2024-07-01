package com.dev.sunny.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDTO {
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
}
