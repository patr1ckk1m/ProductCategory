package com.patrick.productcategory.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrick.productcategory.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{

}
