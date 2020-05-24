package com.sms.controller;

import com.sms.pojo.RespBean;
import com.sms.pojo.User;
import com.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跨域请求login方法
     * @param loginName
     * @param password
     * @return RespBean
     */
//    @CrossOrigin
    @GetMapping("/login")
    public RespBean login(@RequestParam String loginName,@RequestParam String password){
        User user = userService.login(loginName,password);
        try{
             return null != user ? RespBean.ok("登陆成功",user) : RespBean.error("用户名或密码错误") ;
        }catch (Exception e){
            return RespBean.error("未知错误");
        }
    }



}
