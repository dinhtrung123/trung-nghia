package com.trung.nghia.DAO;

import com.trung.nghia.mapper.RowMapper;

import java.util.List;

public interface  GenericeDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowmapper, Object... parameters);
    void updata(String sql, Object... parameters) ;
    Long insert(String sql, Object... parameters) ;
    int count(String sql, Object... parameters) ;
}
