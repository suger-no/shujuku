package com.example.shujuku.controller;


import com.example.shujuku.common.Result;
import com.example.shujuku.config.shiro.ShiroUtils;
import com.example.shujuku.entity.Book;
import com.example.shujuku.entity.Buy;
import com.example.shujuku.entity.Employee;
import com.example.shujuku.entity.Sell;
import com.example.shujuku.service.BookService;
import com.example.shujuku.service.BuyService;
import com.example.shujuku.service.SellService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private static List<String> types = Arrays.asList("小说","文学","教育","成功","科幻","童书","青春文学","古典名著");
    @Autowired
    BookService bookService;
    @Autowired
    BuyService buyService;
    @Autowired
    SellService sellService;


    @GetMapping("/types")
    public Result types(HttpServletResponse response){
//        response.setHeader("Cache-Control","no-cache");
        return Result.success(types);
    }

    @GetMapping("/books")
    public Result books(){
        List<Book> books = bookService.getBaseMapper().selectList(null);
        return Result.success(books);
    }

    @PostMapping("/change")
    public Result books(@RequestBody Book book){
        int i = bookService.getBaseMapper().updateById(book);
        if(i==1)
            return Result.success();
        else{
            return Result.fail("shibai");
        }
    }

    @PostMapping("/buyBook")
    public Result buyBook(@RequestBody Book book,Integer cuId){
        Book byId = bookService.getById(book.getBId());
        if(byId.getBStock()>0){
            byId.setBStock(byId.getBStock()-1);
            bookService.getBaseMapper().updateById(byId);
            Sell sell = new Sell();
            sell.setBId(book.getBId());
            sell.setCuId(cuId);//暂定
            sell.setSeQty(1);
            sell.setSeTime(LocalDateTime.now());
            sellService.getBaseMapper().insert(sell);
            return Result.success("购买成功");
        }else{
            return Result.fail("库存不足");
        }
    }

    @GetMapping("/jin")
    public Result jin(String bName,@RequestParam Long bId,String bAuthor,String bType,String bPress,@RequestParam String bPrice,@RequestParam Integer bStock, Integer emId){
        Book byId = bookService.getById(bId);
        if(byId!=null){
            byId.setBStock(bStock+byId.getBStock());
            bookService.updateById(byId);
        }else{
            Book book = new Book(bId, bName, bAuthor, bType, Integer.parseInt(bPrice), bStock, bPress);
            bookService.save(book);
        }
        Buy buy = new Buy(null,bId,Integer.parseInt(bPrice)*bStock,bStock,emId,LocalDateTime.now());
        buyService.save(buy);
        return Result.success("成功");
    }

    @GetMapping("/xiugai")
    public Result xiugai( String bName,Long bId,String bAuthor,String bType,String bPress,String bPrice,Integer bStock, Integer emId){
        Book book = new Book(bId, bName, bAuthor, bType, Integer.parseInt(bPrice), bStock, bPress);
        bookService.updateById(book);
        return Result.success("成功");
    }



}
