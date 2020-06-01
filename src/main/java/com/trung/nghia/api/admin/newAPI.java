package com.trung.nghia.api.admin;

import com.trung.nghia.dto.NewDTO;
import com.trung.nghia.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class newAPI {
    @Autowired
    private INewService iNewService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {

        return  iNewService.save(newDTO);
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){

        return  iNewService.save(newDTO);
    }

    @DeleteMapping("/api/new")
    public  void  deleteNew(@RequestBody  long[] ids){
       iNewService.delete(ids);
    }

}
