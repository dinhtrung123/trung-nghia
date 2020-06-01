package com.trung.nghia.converter;

import com.trung.nghia.dto.CategoryDTO;
import com.trung.nghia.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDto(CategoryEntity cate){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(cate.getId());
        categoryDTO.setName(cate.getName());
        categoryDTO.setCode(cate.getCode());
        return categoryDTO;
    }
    public  CategoryEntity toEntity(CategoryDTO cate){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(cate.getId());
        categoryEntity.setName(cate.getName());
        categoryEntity.setCode(cate.getCode());
        return categoryEntity;
    }
}
