package com.zhu.fte.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动器
 *
 * @author zhujiqian
 * @date 2020/7/29 22:53
 */
@ServletComponentScan
@EnableScheduling
@SpringBootApplication
public class FteWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FteWebApplication.class,args);
    }
}
