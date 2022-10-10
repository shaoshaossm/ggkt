package com.ssm.ggkt.exception;

import com.ssm.ggkt.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/10 14:35
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ApiOperation("全局异常处理") // 这样写会被挨打吗？
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null).message("执行了全局处理异常");
    }

    @ApiOperation("特定异常处理") // 这样写会被挨打吗？
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail(null).message("除数不能为0");
    }

    @ApiOperation("自定义异常处理") // 这样写会被挨打吗？
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.fail(null).message(e.getMsg()).code(e.getCode());
    }
}
