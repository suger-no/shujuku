package com.example.shujuku.service.impl;

import com.example.shujuku.entity.Book;
import com.example.shujuku.mapper.BookMapper;
import com.example.shujuku.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchitang
 * @since 2022-06-08
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
