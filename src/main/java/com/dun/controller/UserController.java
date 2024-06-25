package com.dun.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.dun.entity.User;
import com.dun.entity.command.LoginCommand;
import com.dun.entity.command.RegisterCommand;
import com.dun.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Pattern;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户数据
     */
    @GetMapping("getList")
    public List<User> getList() {
        return userService.getList();
    }

    /**
     * 根据名称获取用户数据
     */
    @GetMapping("getByName")
    public User getByName(@RequestParam("name") String name) {
        return userService.getByName(name);
    }

    /**
     * 根据ID删除用户数据
     */
    @PostMapping("deleteById")
    public void deleteById(@RequestParam("id") String id) {
        userService.deleteById(id);
    }

    /**
     * 登录
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public String login(LoginCommand command, HttpSession session, HttpServletRequest request) {
        // 校验
        if (StringUtils.isBlank(command.getName())) {
            request.setAttribute("msg", "用户名不能为空");
        } else if (StringUtils.isBlank(command.getPassword())) {
            request.setAttribute("msg", "密码不能为空");
        } else {
            // 根据名称获取用户数据
            User user = userService.getByName(command.getName());

            if (user == null || !user.getPassword().equals(command.getPassword())) {
                request.setAttribute("msg", "用户名或密码错误");
            } else {
                // 保存session
                session.setAttribute("userName", user.getName());
                return "index";
            }
        }

        request.setAttribute("user", command);
        return "login";
    }

    /**
     * 注册
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

    /**
     * 注册
     *
     * @param command
     */
    @PostMapping("register")
    public String register(RegisterCommand command, HttpServletRequest request) {
        request.setAttribute("user", command);
        // 校验
        // 密码正则表达式，为数字或字母，长度大于等于8小于等于16
        String pwdPattern = "^[0-9A-Za-z]{8,16}$";
        String phonePattern = "^1[3-9]\\d{9}$";
        if (StringUtils.isBlank(command.getName())) {
            request.setAttribute("msg", "用户名不能为空");
        } else if (StringUtils.isBlank(command.getPassword())) {
            request.setAttribute("msg", "密码不能为空");
        } else if (StringUtils.isBlank(command.getConfirmPassword())) {
            request.setAttribute("msg", "确认密码不能为空");
        } else if (StringUtils.isBlank(command.getPhone())) {
            request.setAttribute("msg", "手机号不能为空");
        } else if (!command.getPassword().equals(command.getConfirmPassword())) {
            request.setAttribute("msg", "两次输入密码不一致");
        } else if (!Pattern.matches(pwdPattern, command.getPassword())) {
            request.setAttribute("msg", "密码为数字或字母，且长度大于等于8小于等于16");
        } else if (!Pattern.matches(phonePattern, command.getPhone())) {
            request.setAttribute("msg", "请输入正确的手机号");
        } else if (userService.isExistName(command.getName(), null)) {
            request.setAttribute("msg", "用户名已存在");
        } else if (userService.isExistPhone(command.getPhone(), null)) {
            request.setAttribute("msg", "手机号已注册");
        } else {
            // 保存
            User user = new User(command.getName(), command.getPassword(), command.getPhone());
            userService.insert(user);
            request.setAttribute("msg", "注册成功");
            return "login";
        }
        return "register";
    }

    /**
     * 注销
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userName");
        return "login";
    }
}
