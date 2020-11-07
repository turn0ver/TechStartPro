package org.joseprendin.springcrud.service;


import org.joseprendin.springcrud.entity.Product;
import org.joseprendin.springcrud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        return optionalProduct.orElseThrow(() -> new RuntimeException("Product does not exist"));
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }


    public Product updateProduct(Product product) {
        Optional<Product> OptProduct = productRepository.findById(product.getId());

        if(OptProduct.isPresent()) {
            product.setId(product.getId());
            return productRepository.save(product);
        }

        return productRepository.save(product);
    }
}
