package com.example.shujuku.service.impl;

import com.example.shujuku.entity.Customer;
import com.example.shujuku.mapper.CustomerMapper;
import com.example.shujuku.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
