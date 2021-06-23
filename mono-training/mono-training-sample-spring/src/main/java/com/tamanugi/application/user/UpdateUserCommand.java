package com.tamanugi.application.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserCommand {
    private int targetId;
    private String updateName;
}
