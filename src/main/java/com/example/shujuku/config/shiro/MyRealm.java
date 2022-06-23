package com.example.shujuku.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shujuku.entity.Customer;
import com.example.shujuku.entity.Employee;
import com.example.shujuku.service.CustomerService;
import com.example.shujuku.service.EmployeeService;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken authenticationToken1 = (UsernamePasswordToken) authenticationToken;
        Employee em_name = employeeService.getOne(new QueryWrapper<Employee>().eq("em_name", authenticationToken1.getUsername()).
                eq("em_password",new String(authenticationToken1.getPassword())));
        if(em_name==null){
            Customer one = customerService.getOne(new QueryWrapper<Customer>().eq("cu_tel", authenticationToken1.getUsername()).eq("cu_password", new String(authenticationToken1.getPassword())));
            if(one==null)
                return null;
        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo();
//        simpleAuthenticationInfo.setCredentials(authenticationToken.getCredentials());
//        simpleAuthenticationInfo.setPrincipals(new SimplePrincipalCollection());

        return new SimpleAuthenticationInfo(authenticationToken1.getUsername(),authenticationToken1.getPassword(),getName());
    }
}
