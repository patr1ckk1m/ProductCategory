package com.patrick.productcategory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.patrick.productcategory.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{

}
