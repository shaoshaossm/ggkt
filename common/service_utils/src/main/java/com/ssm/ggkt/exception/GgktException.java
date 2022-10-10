package com.ssm.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/10 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgktException extends RuntimeException {
    private Integer code;
    private String msg;
}
