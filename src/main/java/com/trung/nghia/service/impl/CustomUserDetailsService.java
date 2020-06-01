package com.trung.nghia.service.impl;

import com.trung.nghia.constant.SystemConstant;
import com.trung.nghia.dto.MyUser;
import com.trung.nghia.entity.RoleEntity;
import com.trung.nghia.entity.UserEntity;
import com.trung.nghia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(userName ,SystemConstant.ACTIVE_STATUS);
        if(userEntity == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities =  new ArrayList<>();
        for (RoleEntity roleEntity: userEntity.getRoles()
             ) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));

        }
        MyUser myUser = new MyUser(userEntity.getUserName(),userEntity.getPassWord(),true,
                true,true,true,authorities);
       myUser.setFullName(userEntity.getFullName());
        return myUser;
    }
}
