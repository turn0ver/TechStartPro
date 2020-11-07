package org.joseprendin.springcrud.repository;

import org.joseprendin.springcrud.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
