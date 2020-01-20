package pers.xu.mybatis;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Maybe has infinite possibilities
 *
 *
 * 使用mybatis生成插件进行代码的生成
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */
public class MybatisGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisGenerator.class);

    /**
     * 运行 MybatisGenerator
     * 会生成4个文件  实体类，实体类Example，Mapper文件，Mapper的xml文件
     */
    public static void runMybatisGenerator(GeneratorConfig generatorPath) throws Exception {
        LOGGER.info("========== 开始运行MybatisGenerator ==========");
        List<String> warnings = new ArrayList<>();
        File configFile = new File(generatorPath.getMybatisXmlConfig());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
        LOGGER.info("========== 开始运行MybatisGenerator ==========");
    }
}
