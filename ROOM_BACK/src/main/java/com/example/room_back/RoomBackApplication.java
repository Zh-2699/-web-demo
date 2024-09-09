package com.example.room_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.room_back.Dao")
@SpringBootApplication
public class RoomBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomBackApplication.class, args);
    }

}
