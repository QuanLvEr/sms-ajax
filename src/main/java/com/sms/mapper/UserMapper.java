package com.sms.mapper;

import com.sms.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<User>{

    User getUserToLogin(@Param("loginName") String loginName, @Param("password") String password);

}
