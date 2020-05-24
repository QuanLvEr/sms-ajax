package com.sms.service;

import com.sms.pojo.User;

import java.util.List;

public interface UserService {

    User login(String loginName,String password);

}
