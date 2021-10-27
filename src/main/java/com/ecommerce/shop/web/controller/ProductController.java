package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import com.ecommerce.shop.web.controller.exception.ProductNotFoundExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    ProductService productServiceIml;

    @Autowired
    public ProductController(ProductService productServiceIml){
        this.productServiceIml = productServiceIml;
    }

    @GetMapping("/")
    public List<Product> getAll(){
        return productServiceIml.findAll();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product){
        log.info("Product request --> {}", product);
        return productServiceIml.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteProduct(@PathVariable Long id){
        productServiceIml.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){

        log.info("Request id --> {}", id);
        log.info("Product dto details --> {}", productDto);
        Product product = null;
        try{
            product = productServiceIml.update(id, productDto);
        }
        catch(ProductNotFoundExistException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(product);
    }

}
