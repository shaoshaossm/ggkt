package com.ssm.ggkt.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/9 19:52
 * 统一返回结果类
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private Integer code; // 状态码
    private String message; // 返回状态信息 （成功 失败）
    private T data; // 返回数据

    // 成功方法
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        if (data != null){
            result.setData(data);
        }
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    //  失败方法
    public static <T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        if (data != null){
            result.setData(data);
        }
        result.setCode(201);
        result.setMessage("失败");
        return result;
    }

    public Result<T> message(String message){
        this.setMessage(message);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
