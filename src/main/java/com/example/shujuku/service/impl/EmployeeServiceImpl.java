package com.example.shujuku.service.impl;

import com.example.shujuku.entity.Employee;
import com.example.shujuku.mapper.EmployeeMapper;
import com.example.shujuku.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
