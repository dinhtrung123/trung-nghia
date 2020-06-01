package com.trung.nghia.converter;

import com.trung.nghia.dto.NewDTO;
import com.trung.nghia.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewDTO toDto (NewEntity newEntity){
        NewDTO newDTO = new NewDTO();
          newDTO.setId(newEntity.getId());
          newDTO.setTitle(newEntity.getTitle());
          newDTO.setShortdese(newEntity.getShortdese());
          newDTO.setContent(newEntity.getContent());
          newDTO.setThumbnail(newEntity.getThumbnail());
          newDTO.setCategoryCode(newEntity.getCategory().getCode());

        return newDTO ;
    }
    public  NewEntity toEntity( NewDTO newDTO){
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setShortdese(newDTO.getShortdese());
        newEntity.setContent(newDTO.getContent());
        newEntity.setThumbnail(newDTO.getThumbnail());
        return newEntity;
    }
    public  NewEntity  toEntity(NewEntity newEntity ,NewDTO newDTO){
        newEntity.setTitle(newDTO.getTitle());
        newEntity.setShortdese(newDTO.getShortdese());
        newEntity.setContent(newDTO.getContent());
        newEntity.setThumbnail(newDTO.getThumbnail());
        return newEntity;
    }
}
