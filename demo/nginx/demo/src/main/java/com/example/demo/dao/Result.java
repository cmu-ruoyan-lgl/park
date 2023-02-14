package com.example.demo.dao;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result() {

    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result ok(String msg){
        return new Result(0,msg);
    }

    public static Result ok(String msg, Object data) {
        return new Result(0, msg, data);
    }

    public static Result failed(){
        return new Result(1,"请求失败");
    }
}
