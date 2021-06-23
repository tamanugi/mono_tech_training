package com.tamanugi.domain.user;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    List<UsersEntity> findByNameContaining(String name);
    
}
