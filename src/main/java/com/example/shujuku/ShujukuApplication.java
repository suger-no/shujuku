package com.example.shujuku;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.shujuku.mapper")
public class ShujukuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShujukuApplication.class, args);
    }

}
