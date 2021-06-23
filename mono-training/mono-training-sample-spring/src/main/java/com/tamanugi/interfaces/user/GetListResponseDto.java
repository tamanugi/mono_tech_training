package com.tamanugi.interfaces.user;

import java.util.List;
import java.util.stream.Collectors;

import com.tamanugi.domain.user.UsersEntity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetListResponseDto {

    private List<GetOneResponseDto> users;

    public GetListResponseDto(List<UsersEntity> entities) {
        this.users = entities.stream().map(GetOneResponseDto::new).collect(Collectors.toList());
    }

}
