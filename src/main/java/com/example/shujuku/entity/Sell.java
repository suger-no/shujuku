package com.example.shujuku.entity;

import java.time.LocalDateTime;
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
public class Sell implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(type = IdType.AUTO)
    private Long seId;

    /**
     * 书籍编号
     */
    private Long bId;

    /**
     * 购买的书籍数量
     */
    private Integer seQty;

    /**
     * 书籍销售时间
     */
    private LocalDateTime seTime;

    /**
     * 顾客编号
     */
    private Integer cuId;


}
