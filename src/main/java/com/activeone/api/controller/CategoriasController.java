package com.activeone.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activeone.api.service.ICategoryService;
import com.activeone.api.service.dto.CategoryRequestByDTO;
import com.activeone.api.service.dto.CategoryRequestUpdDTO;
import com.activeone.api.service.dto.CategoryResponseByDTO;
import com.activeone.api.service.dto.CategoryResponseSavedDTO;

@RestController
@RequestMapping(value = "/category")
public class CategoriasController {
	
	@Autowired
	private ICategoryService service;
	
	@GetMapping(value = "/getCategory/{idCategory}")
	public CategoryResponseByDTO getCategoryById(@PathVariable Integer idCategory) {
		CategoryResponseByDTO categoryResponseByDTO = this.service.getCategoryByIdServ(idCategory);
		return categoryResponseByDTO;
	}
	
	@GetMapping(value = "/getCategories")
	public List<CategoryResponseByDTO> getAllCategories() {
		List<CategoryResponseByDTO>listCategories = this.service.getAllCategoryServ();
		return listCategories;
	}
	
	
	@PostMapping(value = "/saveCategory")
	public CategoryResponseSavedDTO saveCategory(
			@RequestBody CategoryRequestByDTO categoryRequestSave) {
		CategoryResponseSavedDTO categoryResponseSavedDTO = 
				this.service.saveCategory(categoryRequestSave);
		return categoryResponseSavedDTO;
	}
	
	@PostMapping(value = "/updateCategory/{id}")
	public CategoryResponseSavedDTO updateCategory(
			@RequestBody CategoryRequestUpdDTO categoryRequestUpd,
			@PathVariable Integer id) {
		CategoryResponseSavedDTO categoryResponseSavedDTO = 
				this.service.updateCategory(categoryRequestUpd, id);
		return categoryResponseSavedDTO;
	}
	

}
