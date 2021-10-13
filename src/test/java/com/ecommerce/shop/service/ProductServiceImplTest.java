package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceIml;

    @BeforeEach
    void setUp() {
        productServiceIml = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceIml.save(product)).thenReturn(product);
        productServiceIml.save(product);
        verify(productRepository, times(1)).save(product);
    }
}