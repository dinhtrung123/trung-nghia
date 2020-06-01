package com.trung.nghia.service.impl;

import com.trung.nghia.converter.CategoryConverter;
import com.trung.nghia.dto.CategoryDTO;
import com.trung.nghia.entity.CategoryEntity;
import com.trung.nghia.repository.CategoryRepository;
import com.trung.nghia.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService  implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Map<String,String> findAll() {
   Map<String,String>  lisMap  = new HashMap<>() ;
    List<CategoryEntity> list = categoryRepository.findAll();

    for (CategoryEntity cate: list
    ) {
       lisMap.put(cate.getCode(),cate.getName());
    }
    return lisMap;



}
}
