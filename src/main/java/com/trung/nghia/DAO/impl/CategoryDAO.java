package com.trung.nghia.DAO.impl;

import com.trung.nghia.DAO.ICategoryDAO;
import com.trung.nghia.mapper.CateMapper;
import com.trung.nghia.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

     @Override
	public List<CategoryModel> findAll() {
    	 String sql = "SELECT * FROM category";
		return query(sql, new CateMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE  id = ?";
		List<CategoryModel> categories = query(sql, new CateMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE  code = ?";
		List<CategoryModel> categories = query(sql, new CateMapper(), code);
		return categories.isEmpty() ? null : categories.get(0);
	}


}
