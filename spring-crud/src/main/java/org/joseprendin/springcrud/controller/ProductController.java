package org.joseprendin.springcrud.controller;



import org.joseprendin.springcrud.entity.Product;
import org.joseprendin.springcrud.repository.ProductRepository;
import org.joseprendin.springcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product addById(@PathVariable long id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        productService.removeById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product);
    }








}
