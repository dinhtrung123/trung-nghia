package com.trung.nghia.repository;

import com.trung.nghia.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findOneByUserNameAndStatus(String userName ,int status) ;
}
