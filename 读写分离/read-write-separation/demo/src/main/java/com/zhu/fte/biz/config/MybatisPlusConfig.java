package com.zhu.fte.biz.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2020/12/24 23:42
 */
@Configuration
@MapperScan("com.zhu.fte.biz.mapper")
public class MybatisPlusConfig {

    /**
     * 分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }


}
