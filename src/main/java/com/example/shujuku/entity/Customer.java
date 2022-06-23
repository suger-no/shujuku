package com.example.shujuku.entity;

import java.math.BigDecimal;
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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 顾客编号（顾客登录密码）
     */
    @TableId(type = IdType.AUTO)
    private Integer cuId;

    /**
     * 顾客名字
     */
    private String cuName;

    /**
     * 顾客地址
     */
    private String cuAddresss;

    /**
     * 顾客电话
     */
    private String cuTel;

    /**
     * 顾客消费金额
     */
//    private BigDecimal cuConsume;

    /**
     * 顾客登录密码
     */
    private String cuPassword;


}
