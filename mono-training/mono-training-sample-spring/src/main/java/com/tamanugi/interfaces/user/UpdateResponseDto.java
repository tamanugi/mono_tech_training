package com.tamanugi.interfaces.user;

import com.tamanugi.domain.user.UsersEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateResponseDto {

    private int id;
    private String name;

    public UpdateResponseDto(UsersEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

}
