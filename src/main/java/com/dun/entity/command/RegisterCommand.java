package com.dun.entity.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class RegisterCommand {

    private String name; // 名称
    private String password; // 密码
    private String confirmPassword; // 确认密码
    private String phone; // 手机
    private Date createTime = new Date(); // 创建时间
}
