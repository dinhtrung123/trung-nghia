package com.trung.nghia.DAO;

import com.trung.nghia.model.NewModel;

import java.util.List;

public interface INewDAO extends GenericeDAO<NewModel> {
   List<NewModel> findAll() ;

}
