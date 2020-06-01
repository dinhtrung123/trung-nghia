package com.trung.nghia.mapper;

import com.trung.nghia.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CateMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapper(ResultSet resultSet) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}

	}
	
}
