package com.activeone.api.service;

import java.util.List;

import com.activeone.api.service.dto.CategoryRequestByDTO;
import com.activeone.api.service.dto.CategoryRequestUpdDTO;
import com.activeone.api.service.dto.CategoryResponseByDTO;
import com.activeone.api.service.dto.CategoryResponseSavedDTO;

public interface ICategoryService {
	
	public CategoryResponseByDTO getCategoryByIdServ(Integer id);
	
	public List<CategoryResponseByDTO> getAllCategoryServ();
	
	public CategoryResponseSavedDTO saveCategory(
			CategoryRequestByDTO categoryRequestByDTO);
	
	public CategoryResponseSavedDTO updateCategory(
			CategoryRequestUpdDTO categoryRequestUpdDTO, Integer id);

}
