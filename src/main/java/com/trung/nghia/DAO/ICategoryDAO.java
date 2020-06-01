package com.trung.nghia.DAO;

import com.trung.nghia.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericeDAO<CategoryModel> {
	   List<CategoryModel> findAll() ;
	   CategoryModel findOne(Long id);
	   CategoryModel findOneByCode(String code);
}
