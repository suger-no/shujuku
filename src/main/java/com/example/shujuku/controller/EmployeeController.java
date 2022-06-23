package com.example.shujuku.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shujuku.common.Result;
import com.example.shujuku.entity.Book;
import com.example.shujuku.entity.Buy;
import com.example.shujuku.entity.Employee;
import com.example.shujuku.service.BuyService;
import com.example.shujuku.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    BuyService buyService;
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee){
        System.out.println(3123);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(employee.getEmName(), employee.getEmPassword()));
        }catch (Exception e){
            return Result.fail("账号或密码错误");
        }
        Employee em_name = employeeService.getBaseMapper().selectOne(new QueryWrapper<Employee>().eq("em_name", employee.getEmName()));
        return Result.success(em_name);
    }

    @GetMapping("/ee")
    public String ee(){
        return "ee";
    }



}
