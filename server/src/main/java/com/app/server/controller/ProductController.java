package com.app.server.controller;

import javax.validation.Valid;
import com.app.server.model.Product;
import com.app.server.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")

// enable cross origin request
@CrossOrigin("*") 
public class ProductController{
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAll(){
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");        
        return productRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/product")
    public Product create(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping(value="/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        Product product = productRepository.findOne(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @PutMapping(value="/product/{id}")    
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @Valid @RequestBody Product product){
        Product data = productRepository.findOne(id);
        if(data == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        data.setTitle(product.getTitle());
        Product updatedProduct = productRepository.save(data);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value="/product/{id}")    
    public void deleteProduct(@PathVariable("id") String id){
        productRepository.delete(id);
    }
}