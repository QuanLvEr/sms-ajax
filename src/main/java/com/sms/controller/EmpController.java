package com.sms.controller;

import com.github.pagehelper.PageInfo;
import com.sms.pojo.Emp;
import com.sms.pojo.RespBean;
import com.sms.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/emp.do")
public class EmpController {

    @Autowired
    private EmpService empService;

   // @CrossOrigin
    @GetMapping("/emps")
    public RespBean getEmpsByPage(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize,
                                  @RequestParam(name = "empName") String empName) throws RuntimeException, UnsupportedEncodingException {
        Map<String, Object> map=new HashMap<>();
        empName=new String(empName.getBytes("ISO-8859-1"),"UTF-8");
        map.put("empName",empName);
        PageInfo<Emp> pageInfo = empService.getEmpsByPage(pageNum, pageSize, map);
        return RespBean.ok("page",pageInfo);
    }

    @PostMapping(value = "/add")
    public RespBean addEmp(@RequestBody Emp emp){
        if(empService.addEmp(emp)){
            return RespBean.ok("添加员工成功");
        }else{
            return RespBean.error("添加员工失败");
        }
    }

    @DeleteMapping(value = "/delete/{empNo}")
    public RespBean deleteEmp(@PathVariable("empNo") Integer empNo){
        if(empService.deleteEmp(empNo)){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }

    @GetMapping(value = "/select/{empNo}")
    public RespBean get(@PathVariable Integer empNo){
        Emp emp = empService.getEmpByEmpNo(empNo);
        if(null!=emp){
            return RespBean.ok("查询成功！",emp);
        }else {
            return RespBean.error("查询失败");
        }
    }

    @PutMapping(value = "/update")
    public RespBean updateEmp(@RequestBody Emp emp){

        if (empService.updateEmp(emp)){
            return RespBean.ok("修改成功！");
        }else {
            return RespBean.error("修改失败！");
        }
    }

    @PostMapping("/upload")
    public RespBean upload(MultipartFile picFile, HttpServletRequest request){
        //1、获得上传文件夹的真实路径（是文件在tomcat服务上的路径）
        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile/");
        //2、如果上传的文件夹不存在就创建
        File realPathFolder=new File(realPath);
        if(!realPathFolder.exists()){
            realPathFolder.mkdirs();
        }
        //3、上传文件的原始文件名
        String oldName=picFile.getOriginalFilename();
        //4、创建新文件名，防止上传的文件同名覆盖之前上传的文件
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            picFile.transferTo(new File(realPath,newName));

            //返回资源的路径 http://localhost:8080/
            String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                    "/uploadFile/"+ newName;
            return RespBean.ok("上传成功",filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("上传失败");
    }
}
