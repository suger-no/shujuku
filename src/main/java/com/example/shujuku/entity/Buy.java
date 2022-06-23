package com.example.shujuku.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 采购编号
     */
    @TableId(type = IdType.AUTO)
    private Long buyId;

    /**
     * 书籍编号
     */
    private Long bId;

    /**
     * 进货价格
     */
    private Integer bSumprice;

    /**
     * 书籍数量
     */
    private Integer buyQty;

    /**
     * 管理员编号
     */
    private Integer emId;

    /**
     * 进货时间
     */
    private LocalDateTime buyTime;


}
