package com.dev.sunny.mappers;

import com.dev.sunny.dtos.ProductResponseDTO;
import com.dev.sunny.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    @Mapping(source = "category", target = "category.name")
    Product productResponseDTOToProduct(ProductResponseDTO productResponseDTO);

}
