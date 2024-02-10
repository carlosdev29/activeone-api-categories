package com.activeone.api.service.dto;

import java.util.Date;

public class CategoryResponseByDTO {

	private Integer categoryId;
	private String categoryName;
	private Date creationDate;
	private Date updateDate;
	private StatusResponseDTO statusResponseDTO;
	
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public StatusResponseDTO getStatusResponseDTO() {
		return statusResponseDTO;
	}
	public void setStatusResponseDTO(StatusResponseDTO statusResponseDTO) {
		this.statusResponseDTO = statusResponseDTO;
	}
	
	
	
	
	
	
	
}