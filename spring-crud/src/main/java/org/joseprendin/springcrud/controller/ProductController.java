package org.joseprendin.springcrud.controller;



import org.joseprendin.springcrud.entity.Product;
import org.joseprendin.springcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/new")
    public String showCreateProduct(Product product) {
        return "create-product";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateProduct(@PathVariable ("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteProduct(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-product";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());

        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "update-customer";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }








}
