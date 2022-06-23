package com.example.shujuku.mapper;

import com.example.shujuku.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
