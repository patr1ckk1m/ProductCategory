package com.patrick.productcategory.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patrick.productcategory.models.*;
import com.patrick.productcategory.services.ProductService;

@Controller
public class ProductController {
	private final ProductService service;
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/products/new";
        }else{
            service.newProduct(product);
            return "redirect:/category/new";
        }
	}
	
	@PostMapping("/category/new")
	public String addProduct(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/category/new";
        }else{
            service.newCategory(category);
            return "redirect:/category/new";
        }
	}

	@RequestMapping("/products/{id}")
	public String product(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", service.findOneProduct(id));
		model.addAttribute("categories", service.findAllCategories());
		return "product.jsp";
	}
	
	@PostMapping("/products/{id}/new")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam(value="category") Long categId) {
		service.addCategoryToProduct(categId, id);
		String url = "redirect:/products/" + id;
		return url;
	}
	
	@RequestMapping("/categories/{id}")
	public String category(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", service.findOneCategory(id));
		model.addAttribute("products", service.findAllProducts());
		return "category.jsp";
	}
	@PostMapping("/categories/{id}/new")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam(value="product") Long prodId) {
		service.addProductToCategory(prodId, id);
		String url = "redirect:/categories/" + id;
		return url;
	}
}
