package com.example.shujuku.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员编号（系统登陆账号）
     */
    @TableId(type = IdType.AUTO)
    private Integer emId;

    /**
     * 管理员名字
     */
    private String emName;

    /**
     * 管理员登录密码
     */
    private String emPassword;


}
