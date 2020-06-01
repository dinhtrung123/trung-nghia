package com.trung.nghia.DAO.impl;

import com.trung.nghia.DAO.INewDAO;
import com.trung.nghia.mapper.NewMapper;
import com.trung.nghia.model.NewModel;
import org.springframework.stereotype.Repository;

import java.util.List;
  @Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
      return query(sql.toString(), new NewMapper());
	}


}
