package com.tamanugi.interfaces.user;

import java.util.List;
import java.util.Optional;

import com.tamanugi.application.user.CreateUserCommand;
import com.tamanugi.application.user.UpdateUserCommand;
import com.tamanugi.application.user.UserApplicationService;
import com.tamanugi.domain.user.UsersEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_= {@Autowired})
public class UserController {

    private final UserApplicationService userApplicationService;

    @PostMapping("/users")
    public CreateResponseDto create(@ModelAttribute CreateRequetDto request) {
        CreateUserCommand command = new CreateUserCommand(request.getName());
        UsersEntity entity = userApplicationService.createUser(command);

        return new CreateResponseDto(entity);
    }

    @PatchMapping("/users/{id}")
    public UpdateResponseDto update(@PathVariable("id") int id, @ModelAttribute UpdateRequestDto request) {
        UpdateUserCommand command = new UpdateUserCommand(id, request.getName());

        Optional<UsersEntity> optionalEntity = userApplicationService.updateUser(command);
        return optionalEntity.map(UpdateResponseDto::new).orElse(null);
    }

    @GetMapping("/users/{id}")
    public GetOneResponseDto get(@PathVariable("id") int id) {
        return userApplicationService.getUser(id)
            .map(GetOneResponseDto::new)
            .orElse(null);
    }

    @GetMapping("/users")
    public GetListResponseDto list(@RequestParam(value="name", required=false, defaultValue="") String name) {
        List<UsersEntity> users = userApplicationService.findByNameContaining(name);
        return new GetListResponseDto(users);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int id) {
        userApplicationService.deleteUser(id);
        return;
    }
}
