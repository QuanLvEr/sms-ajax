package com.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sms.mapper.EmpMapper;
import com.sms.pojo.Emp;
import com.sms.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageInfo<Emp> getEmpsByPage(Integer pageNum, Integer pageSize, Map<String,Object> map) throws RuntimeException {
        //构建条件查询容器
        Example example = new Example(Emp.class);
        Example.Criteria criteria = example.createCriteria();
        if(map!=null && StringUtil.isNotEmpty(map.get("empName").toString().trim())){
            criteria.andLike("empName","%"+map.get("empName")+"%");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Emp> list = empMapper.selectByExample(example);

        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean addEmp(Emp emp) {
        return empMapper.insertSelective(emp)>0?true:false;
    }

    @Override
    public Emp getEmpByEmpNo(Integer empNo) {
        Emp emp = empMapper.selectByPrimaryKey(empNo);
        if (null!=emp){
            return emp;
        }else {
            return null;
        }
    }

    @Override
    public boolean updateEmp(Emp emp) {
        return empMapper.updateByPrimaryKey(emp)>0?true:false;
    }

    @Override
    public boolean deleteEmp(Integer empNo) {
        return empMapper.deleteByPrimaryKey(empNo)>0?true:false;
    }


}
