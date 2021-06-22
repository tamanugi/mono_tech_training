package com.tamanugi.application.user;

import com.tamanugi.domain.user.UsersEntity;
import com.tamanugi.domain.user.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class UserApplicationService {
    
    private final UsersRepository usersRepository;
    
    public void createUser(CreateUserCommand command) {

        UsersEntity entity = new UsersEntity();
        entity.setName(command.getName());
        usersRepository.save(entity);

    }
    
}
