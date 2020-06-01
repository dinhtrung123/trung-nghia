package com.trung.nghia.service.impl;

import com.trung.nghia.DAO.INewDAO;
import com.trung.nghia.converter.CategoryConverter;
import com.trung.nghia.converter.NewConverter;
import com.trung.nghia.dto.CategoryDTO;
import com.trung.nghia.dto.NewDTO;
import com.trung.nghia.entity.CategoryEntity;
import com.trung.nghia.entity.NewEntity;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.repository.CategoryRepository;
import com.trung.nghia.repository.NewRepository;
import com.trung.nghia.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {
    //      @Autowired
//    private INewDAO iNewModelDAO ;
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private NewConverter newConverter;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> list = newRepository.findAll(pageable).getContent();
        for (NewEntity item : list
        ) {
            NewDTO newDTO = newConverter.toDto(item);
            models.add(newDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {

        return (int) newRepository.count();
    }

    @Override
    public NewDTO findById(long id) {
        NewEntity newEntity = newRepository.findOne(id);
        return newConverter.toDto(newEntity);
    }

    @Override
    @Transactional
    public NewDTO insert(NewDTO newDTO) {
        NewEntity newEntity = newConverter.toEntity(newDTO);
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        return newConverter.toDto(newRepository.save(newEntity));
    }

    @Override
    @Transactional
    public NewDTO update(NewDTO newDTO) {
        NewEntity newEntity = newRepository.findOne(newDTO.getId());
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newUpdate = newConverter.toEntity(newEntity,newDTO);
        newUpdate.setCategory(categoryEntity);
        return newConverter.toDto(newRepository.save(newUpdate));
    }

    @Override
    @Transactional
    public NewDTO save(NewDTO newDTO) {
         NewEntity newEntity = new NewEntity();
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());

        if(newDTO.getId()!=null)
        {
             newEntity = newRepository.findOne(newDTO.getId());
            newEntity = newConverter.toEntity(newEntity,newDTO);
            newEntity.setCategory(categoryEntity);
        }else
        {
             newEntity = newConverter.toEntity(newDTO);
             newEntity.setCategory(categoryEntity);
        }
        return newConverter.toDto(newRepository.save(newEntity));
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids
             ) {
            newRepository.delete(id);
        }
    }


}
