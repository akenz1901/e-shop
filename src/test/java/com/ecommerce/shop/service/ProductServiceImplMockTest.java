package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
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
    @Test
    public void findExistingProductById(){
        Product existing = productRepository.findById(110L).orElse(null);
        assertThat(existing).isNotNull();
        log.info("Product --> {}", existing);
    }
    @Test
    void deleteExistingProductById(){
        assertThat(productRepository.findById(110L).orElse(null)).isNotNull();

        productRepository.deleteById(110L);
        assertThat(productRepository.findById(100L).orElse(null)).isNull();
    }
    @Test
    void updateExistingProductById(){
        Product product = new Product();
        product.setId(17L);
        product.setName("Airpod");
        product.setDetails("Latest Airpod made by me");
        product.setPrice(19045.00);
        product.setCurrency(Currency.NGN);

        assertThat(product.getId()).isEqualTo(17L);

        productServiceIml.save(product);

        assertThat(productServiceIml.findById(17L)).isNotNull();
        Product existingProduct = productRepository.findById(110L).orElse(null);
        assertThat(existingProduct).isNull();

    }

}