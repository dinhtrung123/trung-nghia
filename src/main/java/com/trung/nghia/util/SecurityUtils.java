package com.trung.nghia.util;

import com.trung.nghia.dto.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public  static MyUser getPrincipal(){
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUser;
    }
    @SuppressWarnings("unchecked")
    public  static List<String> getAuthorittes(){
     List<String> results =  new ArrayList<>();
     List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority grantedAuthority: authorities
             ) {
            results.add(grantedAuthority.getAuthority());
        }
     return  results;
    }
}
