package com.example.room_back.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // 自动生成 getters, setters, toString, equals, hashCode 方法
@NoArgsConstructor  // 自动生成无参构造器
@AllArgsConstructor // 自动生成全参构造器
public class CommonResult {
    private Integer code;
    private String message;
    private Object data;

    // 静态工厂方法
    public static CommonResult error(String message) {
        return new CommonResult(500, message, null);
    }

    public static CommonResult error(String message, Object data) {
        return new CommonResult(500, message, data);
    }

    public static CommonResult success(String message) {
        return new CommonResult(200, message, null);
    }

    public static CommonResult success(String message, Object data) {
        return new CommonResult(200, message, data);
    }
}
