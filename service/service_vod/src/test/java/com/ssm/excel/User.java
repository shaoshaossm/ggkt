package com.ssm.excel;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/16 11:19
 */
@Data
public class User {
    //设置表头名称
    @ExcelProperty(value = "用户编号",index = 0)
    private int id;
    @ExcelProperty(value = "用户姓名",index = 1)
    private String name;
}
