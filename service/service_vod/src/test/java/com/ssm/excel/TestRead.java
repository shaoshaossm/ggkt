package com.ssm.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/16 12:20
 */
public class TestRead {
    public static void main(String[] args) {
        String fileName = "F:\\ggkt.xlsx";
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();
    }
}
