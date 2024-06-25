package com.dun.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class User {

    private String id; // ID
    private String name; // 名称
    private String password; // 密码
    private String phone; // 手机
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
    @TableLogic(value = "0", delval = "1")
    private boolean isDeleted; // 是否删除。0：否；1：是

    public User(String name, String password, String phone) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.createTime = new Date();
        this.isDeleted = false;
    }

    private void deleted() {
        this.isDeleted = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", phone=" + phone +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

