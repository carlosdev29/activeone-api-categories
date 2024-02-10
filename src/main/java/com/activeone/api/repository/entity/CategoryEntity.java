package com.activeone.api.repository.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class CategoryEntity {
	
	
	@Id
	@Column(name = "id_categorias")
	private Integer id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "fecha_crecion")
	private Date creationDate;
	
	@Column(name = "fecha_actualizacion")
	private Date updateDate ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	
	

}
