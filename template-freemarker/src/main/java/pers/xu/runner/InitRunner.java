package pers.xu.runner;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化运行的代码
 */
@Slf4j
@Component
public class InitRunner implements ApplicationRunner {

    @Value("${env.name}")
    private String envName;

    @Override
    public void run(ApplicationArguments args) {
        log.info("环境名称: {}", envName);
    }
}
