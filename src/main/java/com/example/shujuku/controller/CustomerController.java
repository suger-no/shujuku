package com.example.shujuku.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shujuku.common.Result;
import com.example.shujuku.entity.Customer;
import com.example.shujuku.entity.Employee;
import com.example.shujuku.mapper.CustomerMapper;
import com.example.shujuku.service.CustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;
    @PostMapping("/zhuce")
    public Result zhuce(@RequestBody Customer customer){
        if(customerService.getOne(new QueryWrapper<Customer>().eq("cu_tel",customer.getCuTel()))!=null){
            return Result.fail("该电话号码已被使用");
        }
        int i = customerMapper.insertCustomer(customer);
        if(i==1)
            return Result.success("success");
        else
            return Result.fail("fail");
    }
    @PostMapping("/login")
    public Result login(@RequestBody Customer customer){
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(customer.getCuTel().toString(), customer.getCuPassword().toString()));
        }catch (Exception e){
            return Result.fail("账号或密码错误");
        }
        Customer cu_tel = customerService.getBaseMapper().selectOne(new QueryWrapper<Customer>().eq("cu_tel", customer.getCuTel()));
        return Result.success(cu_tel);
    }


    @GetMapping("/information")
    public Result information(Integer id){
        Customer customer = customerService.getBaseMapper().selectById(id);
        if(customer==null){
            return Result.fail("用户不存在");
        }
        return Result.success(customer);
    }

    @PostMapping("/xiugai")
    public Result xiugai(@RequestBody Customer customer){
        boolean b = customerService.updateById(customer);
        if(b){
            return Result.success();
        }else{
            return Result.fail("失败");
        }
    }

}
