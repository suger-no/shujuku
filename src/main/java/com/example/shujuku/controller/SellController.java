package com.example.shujuku.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shujuku.common.Result;
import com.example.shujuku.entity.Sell;
import com.example.shujuku.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    SellService sellService;
    @GetMapping("/sells")
    public Result sells(){
        return Result.success(sellService.getBaseMapper().selectList(null));
    }
    @GetMapping("/sellsId")
    public Result sellsId(Integer id){
        return Result.success(sellService.getBaseMapper().selectList(new QueryWrapper<Sell>().eq("cu_id",id)));
    }

}
