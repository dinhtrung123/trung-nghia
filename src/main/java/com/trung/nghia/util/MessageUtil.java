package com.trung.nghia.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MessageUtil {
    public Map<String,String> getMessageUitl(String message){
        Map<String,String> list = new HashMap<>();
        if(message.equals("update_success"))
        {
            list.put("alert","success");
            list.put("message","Update success");
        } else if(message.equals("insert_success")) {
            list.put("alert", "success");
            list.put("message", "insert success");
        } else if(message.equals("error_system"))
        {
            list.put("alert","danger");
            list.put("message","error system");
        }else if(message.equals("delete_success"))
        {
            list.put("alert","success");
            list.put("message","delete success");
        }
        return list;
    }
}
