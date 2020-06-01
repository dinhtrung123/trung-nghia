package com.trung.nghia.service;

import com.trung.nghia.dto.CategoryDTO;
import com.trung.nghia.dto.NewDTO;
import com.trung.nghia.entity.NewEntity;
import com.trung.nghia.model.NewModel;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface INewService {
   List<NewDTO>  findAll(  Pageable pageable) ;
   int getTotalItem();
   NewDTO findById(long id) ;
   NewDTO insert(NewDTO newDTO);
   NewDTO update(NewDTO newDTO);
   NewDTO save(NewDTO newDTO);
   void delete(long[] ids);
}
