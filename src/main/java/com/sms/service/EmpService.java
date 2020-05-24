package com.sms.service;

import com.github.pagehelper.PageInfo;
import com.sms.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {

    public PageInfo<Emp> getEmpsByPage(Integer pageNum, Integer pageSize, Map<String,Object> map);

    boolean addEmp(Emp emp);

    Emp getEmpByEmpNo(Integer empNo);

    boolean updateEmp(Emp emp);

    boolean deleteEmp(Integer empNo);
}
