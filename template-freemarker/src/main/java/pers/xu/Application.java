package pers.xu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Maybe has infinite possibilities
 *
 * @author Created by sugar on 2018/5/26
 */
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "pers.xu.mapper")
@EntityScan("pers.xu.entity")
@ServletComponentScan("pers.xu.interceptor")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
