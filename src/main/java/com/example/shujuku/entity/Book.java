package com.example.shujuku.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍编号
     */
    @TableId
    private Long bId;

    /**
     * 书籍名称
     */
    private String bName;

    /**
     * 书籍作者
     */
    private String bAuthor;

    /**
     * 书籍类型
     */
    private String bType;

    /**
     * 书籍价格
     */
    private Integer bPrice;

    /**
     * 书籍库存
     */
    private Integer bStock;

    /**
     * 书籍出版社
     */
    private String bPress;


}
