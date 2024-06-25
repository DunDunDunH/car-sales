package com.dun.entity.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginCommand {

    private String name; // 名称
    private String password; // 密码
}