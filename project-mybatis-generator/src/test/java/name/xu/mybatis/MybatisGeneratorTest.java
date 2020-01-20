package name.xu.mybatis;

import org.junit.Test;

/**
 * Maybe has infinite possibilities
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/2/1
 */
public class MybatisGeneratorTest {

    @Test
    public void runMybatisGenerator() throws Exception {
        //加载配置文件
        GeneratorConfig generatorPath = new GeneratorConfig("/velocity/config.properties");
        MybatisGenerator.runMybatisGenerator(generatorPath);
    }
}
