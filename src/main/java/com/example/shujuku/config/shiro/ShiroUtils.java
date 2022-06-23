package com.example.shujuku.config.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.example.shujuku.entity.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.StringUtils;

public class ShiroUtils {
    public static Employee getSysUser()
    {
        Employee user = null;
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj!=null)
        {
            user = new Employee();
            BeanUtil.copyProperties(user, obj);
        }
        return user;
    }

}
