package com.dev.sunny.controllers;

import com.dev.sunny.dtos.ProductResponseDTO;
import com.dev.sunny.mappers.ProductMapper;
import com.dev.sunny.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper mapper;
    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Product productByID(@PathVariable("id") Long id) {
        ProductResponseDTO fetchedProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductResponseDTO.class);

        if (fetchedProduct == null) return new Product();

        return mapper.productResponseDTOToProduct(fetchedProduct);
    }

    @GetMapping("/all")
    public List<Product> listAllProduct() {
        ProductResponseDTO[] productArray = restTemplate.getForObject("https://fakestoreapi.com/products", ProductResponseDTO[].class);
        List<ProductResponseDTO> fetchedProducts = productArray != null ? List.of(productArray) : Collections.emptyList();

        return fetchedProducts.stream()
                .map(mapper::productResponseDTOToProduct)
                .toList();
    }

}
