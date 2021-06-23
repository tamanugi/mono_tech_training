package com.tamanugi.interfaces.user;

import javax.annotation.Generated;

import com.tamanugi.domain.user.UsersEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateResponseDto {
    private int id;

    public CreateResponseDto(UsersEntity entity) {
        this.id = entity.getId();
    }
}
