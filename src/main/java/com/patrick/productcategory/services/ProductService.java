package com.patrick.productcategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patrick.productcategory.models.Category;
import com.patrick.productcategory.models.Product;
import com.patrick.productcategory.repositories.CategoryRepo;
import com.patrick.productcategory.repositories.ProductRepo;

@Service
public class ProductService {
	private ProductRepo productRepo;
	private CategoryRepo categoryRepo;
	
	public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	public void newProduct(Product product) {
		productRepo.save(product);
	}
	
	public void newCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public void addCategoryToProduct(Long categId, Long id) {
		Product product = productRepo.findOne(id);
		product.getCategories().add(categoryRepo.findOne(categId));
		productRepo.save(product);
	}
	
	public void addProductToCategory(Long prodId, Long id) {
		Category category = categoryRepo.findOne(id);
		category.getProducts().add(productRepo.findOne(prodId));
		categoryRepo.save(category);
	}
	
	public Product findOneProduct(Long id) {
		return productRepo.findOne(id);
	}
	
	public List<Category> findAllCategories(){
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Category findOneCategory(Long id) {
		return categoryRepo.findOne(id);
	}
	
	public List<Product> findAllProducts(){
		return (List<Product>) productRepo.findAll();
	}
}
