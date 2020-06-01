package com.trung.nghia.controller.admin;


import com.trung.nghia.dto.NewDTO;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.service.ICategoryService;
import com.trung.nghia.service.INewService;
import com.trung.nghia.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Map;

@Controller("newControllerOfAdmin")
public class NewController {
     @Autowired
  private INewService iNewService ;

     @Autowired
     private ICategoryService iCategoryService;
     @Autowired
     private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit ,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/list");
        NewDTO newDTO = new NewDTO();
       newDTO.setLimit(limit);
       newDTO.setPage(page);
        Pageable pageable = new PageRequest(page-1 ,limit);
        newDTO.setListResult(iNewService.findAll(pageable));
        newDTO.setTotalItem(iNewService.getTotalItem());
         newDTO.setTotalPage((int) Math.ceil((double) newDTO.getTotalItem() / newDTO.getLimit()));
         if(request.getParameter("message") !=null)
         {
             if(request.getParameter("message") !=null)
             {
                 Map<String,String> list = messageUtil.getMessageUitl(request.getParameter("message"));
                 mav.addObject("message",list.get("message"));
                 mav.addObject("alert",list.get("alert"));
             }
         }

        mav.addObject("model" , newDTO);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(value = "id" ,required = false) Long id , HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/edit");
      NewDTO newDTO = new NewDTO();
        if(id != null)
        {
         newDTO = iNewService.findById(id);
        }
      if(request.getParameter("message") !=null)
      {
          Map<String,String> list = messageUtil.getMessageUitl(request.getParameter("message"));
          mav.addObject("message",list.get("message"));
          mav.addObject("alert",list.get("alert"));
      }

        mav.addObject("categorys",iCategoryService.findAll());
        mav.addObject("model" , newDTO);
        return mav;

    }

}
