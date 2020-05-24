package com.sms.controller;

import com.sms.pojo.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCrossOrigin {
    //@CrossOrigin
    @GetMapping("/login.do")
    public RespBean login(){
        return RespBean.ok("@CrossOrigin实现跨域请求！");
    }
}
