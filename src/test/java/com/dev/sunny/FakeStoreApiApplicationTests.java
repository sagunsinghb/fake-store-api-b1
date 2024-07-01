package com.dev.sunny;

import com.dev.sunny.model.Category;
import com.dev.sunny.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FakeStoreApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testProductEquals() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");
        product1.setPrice(10.0);
        product1.setDescription("Description 1");
        product1.setImage("Image 1");

        Category category = new Category();
        category.setId(1L);
        category.setName("Category 1");

        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(1L);
        product2.setTitle("Product 1");
        product2.setPrice(10.0);
        product2.setDescription("Description 1");
        product2.setImage("Image 1");

        product2.setCategory(category);

        assert(product1.equals(product2));
    }
}
