package name.xu.mybatis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maybe has infinite possibilities
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/2/1
 */
public class VelocityGeneratorTest {

    @BeforeClass
    public static void setUp() throws Exception {
    }

    /**
     * 运行完了之后删除文件
     */
    @AfterClass
    public static void tearDown() throws Exception {


    }

    @Test
    public void generatorXml() {

        //加载配置文件
        GeneratorConfig generatorPath = new GeneratorConfig("/velocity/config.properties");

        //表的列表
        List<Map<String, String>> tables = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("model_name", "User");
        map.put("table_name", "user");
        tables.add(map);
        // 需要insert后返回主键的表配置，key:表名,value:主键名
        Map<String, String> lastInsertIdTables = new HashMap<>(2);
        lastInsertIdTables.put(generatorPath.getDatabaseTableName(), generatorPath.getDatabaseTableKey());

        //生成配置文件，会生成一个文件 generatorConfig.xml
        VelocityGenerator.mybatisXml(tables, generatorPath, lastInsertIdTables);


    }

    @Test
    public void serviceRun() {
        //加载配置文件
        GeneratorConfig generatorPath = new GeneratorConfig("/velocity/config.properties");
        //Java 类
        VelocityGenerator.javaFileRun(generatorPath);
    }
}
