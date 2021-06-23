package com.tamanugi.application.user;

import java.util.List;
import java.util.Optional;

import com.tamanugi.domain.user.UsersEntity;
import com.tamanugi.domain.user.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class UserApplicationService {
    
    private final UsersRepository usersRepository;
    
    public UsersEntity createUser(CreateUserCommand command) {

        UsersEntity entity = new UsersEntity();
        entity.setName(command.getName());
        return usersRepository.save(entity);
    }

    public void updateUser(UpdateUserCommand command) {
        Optional<UsersEntity> target = usersRepository.findById(command.getTargetId());

        target.ifPresent(t -> {
            t.setName(command.getUpdateName());
            usersRepository.save(t);
        });
    }

    public Optional<UsersEntity> getUser(int id) {
        return usersRepository.findById(id);
    }

    public List<UsersEntity> findByNameContaining(String name) {
        return usersRepository.findByNameContaining(name);
    }

}
