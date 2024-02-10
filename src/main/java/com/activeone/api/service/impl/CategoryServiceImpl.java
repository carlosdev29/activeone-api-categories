package com.activeone.api.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activeone.api.repository.ICategoriesRepository;
import com.activeone.api.repository.entity.CategoryEntity;
import com.activeone.api.service.ICategoryService;
import com.activeone.api.service.dto.CategoryRequestByDTO;
import com.activeone.api.service.dto.CategoryRequestUpdDTO;
import com.activeone.api.service.dto.CategoryResponseByDTO;
import com.activeone.api.service.dto.CategoryResponseSavedDTO;
import com.activeone.api.service.dto.StatusResponseDTO;


@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoriesRepository repository;
	
	
	@Override
	public List<CategoryResponseByDTO> getAllCategoryServ() {
		
		CategoryResponseByDTO categoryResponseByDTO = 
				new CategoryResponseByDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		List<CategoryResponseByDTO>categoryResponseByList =
				new ArrayList<>();
		List<CategoryEntity>categoryList = this.repository
				.findAll();
		
		if (categoryList.size()>0) {
			statusResponseDTO.setCod("200");
			statusResponseDTO.setMessage("OK");
		}else {
			statusResponseDTO.setCod("203");
			statusResponseDTO.setMessage("data not found db");
			categoryResponseByDTO.setStatusResponseDTO(statusResponseDTO);
			categoryResponseByList.add(categoryResponseByDTO);
			return categoryResponseByList;
		}
		for (CategoryEntity categoryEntity : categoryList) {
			categoryResponseByDTO.setCategoryId(categoryEntity.getId());
			categoryResponseByDTO.setCategoryName(categoryEntity.getName());
			categoryResponseByDTO.setCreationDate(categoryEntity.getCreationDate());
			categoryResponseByDTO.setUpdateDate(categoryEntity.getUpdateDate());
			categoryResponseByList.add(categoryResponseByDTO);
		}
		
		categoryResponseByDTO.setStatusResponseDTO(statusResponseDTO);
		return categoryResponseByList;
	}
	
	@Override
	public CategoryResponseByDTO getCategoryByIdServ(Integer id) {
		CategoryResponseByDTO categoryResponseByDTO = 
				new CategoryResponseByDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		CategoryEntity categoryEntity = this.repository
				.findById(id).orElse(null);
		
		Optional<CategoryEntity>categoryEntityData =
				Optional.ofNullable(categoryEntity);
		if (categoryEntityData.isPresent()) {
			statusResponseDTO.setCod("200");
			statusResponseDTO.setMessage("OK");
			categoryResponseByDTO.setStatusResponseDTO(statusResponseDTO);
			categoryResponseByDTO.setCategoryId(categoryEntity.getId());
			categoryResponseByDTO.setCategoryName(categoryEntity.getName());
			categoryResponseByDTO.setCreationDate(categoryEntity.getCreationDate());
			categoryResponseByDTO.setUpdateDate(categoryEntity.getUpdateDate());
		} else {
			statusResponseDTO.setCod("200");
			statusResponseDTO.setMessage("OK");
			categoryResponseByDTO.setStatusResponseDTO(statusResponseDTO);
		}
		
		return categoryResponseByDTO;
	}
	
	
	@Override
	public CategoryResponseSavedDTO saveCategory(CategoryRequestByDTO categoryRequestByDTO) {
		CategoryResponseSavedDTO carCategoryResponseSavedDTO = 
				new CategoryResponseSavedDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		Date date = new Date();
		//Timestamp timestamp = new Timestamp(date.getTime());
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryRequestByDTO.getCategoryName());
		categoryEntity.setCreationDate(date);
		CategoryEntity responseCategory = this.repository
				.save(categoryEntity);
		statusResponseDTO.setCod("201");
		statusResponseDTO.setMessage("OK");
		carCategoryResponseSavedDTO.setIdCategory(responseCategory.getId());
		carCategoryResponseSavedDTO.setStatusResponseDTO(statusResponseDTO);
		return carCategoryResponseSavedDTO;
	}
	
	@Override
	public CategoryResponseSavedDTO updateCategory(
			CategoryRequestUpdDTO categoryRequestUpdDTO,Integer id) {
		CategoryResponseSavedDTO carCategoryResponseSavedDTO = 
				new CategoryResponseSavedDTO();
		StatusResponseDTO statusResponseDTO = new StatusResponseDTO();
		Date date = new Date();
		//Timestamp timestamp = new Timestamp(date.getTime());
		CategoryEntity categoryEntity = this.repository
				.findById(id).orElse(null);
		categoryEntity.setName(categoryRequestUpdDTO.getCategoryName());
		categoryEntity.setCreationDate(date);
		CategoryEntity responseCategory = this.repository
				.save(categoryEntity);
		statusResponseDTO.setCod("201");
		statusResponseDTO.setMessage("OK");
		carCategoryResponseSavedDTO.setIdCategory(responseCategory.getId());
		carCategoryResponseSavedDTO.setStatusResponseDTO(statusResponseDTO);
		return carCategoryResponseSavedDTO;
	}
	
	
	

}
