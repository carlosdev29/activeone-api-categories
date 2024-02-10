package com.activeone.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activeone.api.repository.entity.CategoryEntity;


@Repository
public interface ICategoriesRepository extends JpaRepository<CategoryEntity, Integer> {
	

}
