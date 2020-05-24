package com.sms.test;

import com.sms.pojo.Emp;
import com.sms.pojo.User;
import com.sms.service.EmpService;
import com.sms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMyBatis {

//    private UserService userService;
//    private EmpService empService;
    /*public void testEmpList(){
        List<Emp> list = empService.selectEmpList();
        if (null!=list){
            for (Emp emp : list) {
                System.out.println(emp);
            }
        }
    }*/
   /* public void testUserList(){
        List<User> list = userService.getUserList();
        if (null!=list){
            for (User user : list) {
                System.out.println(user);
            }
        }
    }*/
    /*public void testLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login("admin","123456");
        if (null!=user){
            System.out.println(user);
        }

    }*/

}
