package com.example.shujuku.controller;


import com.example.shujuku.common.Result;
import com.example.shujuku.service.BuyService;
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
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    BuyService buyService;
    @GetMapping("/buys")
    public Result buys(){
        return Result.success(buyService.getBaseMapper().selectList(null));
    }
}
