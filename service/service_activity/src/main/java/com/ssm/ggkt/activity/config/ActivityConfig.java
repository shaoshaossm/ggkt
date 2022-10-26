package com.ssm.ggkt.activity.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/10/24 21:13
 */
@Configuration
@MapperScan("com.ssm.ggkt.activity.mapper")
public class ActivityConfig {
    /**
     *  分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
