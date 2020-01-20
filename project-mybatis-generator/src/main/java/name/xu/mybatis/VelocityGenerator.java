package name.xu.mybatis;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Maybe has infinite possibilities
 *
 * 代码生成类
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */

public class VelocityGenerator {


    /**
     * 根据模板生成generatorConfig.xml文件
     */
    public static void mybatisXml(List<Map<String, String>> tables,
                                  GeneratorConfig generatorPath,
                                  Map<String, String> lastInsertIdTables) {
        MybatisGeneratorXmlConfigVelocityInfo mybatisVelocityInfo = new MybatisGeneratorXmlConfigVelocityInfo(
                generatorPath.getMybatisXmlConfig(),
                generatorPath.getVmFilePath("generatorConfig.vm"),
                tables,
                generatorPath.getModelPackage(),
                generatorPath.getMapperPackage(),
                generatorPath.getDaoPackage(),
                generatorPath.getProjectPath(),
                generatorPath.getProjectPath(),
                lastInsertIdTables
        );
        mybatisVelocityInfo.run();
    }

    /**
     * 根据模板生成Java文件
     */
    public static void javaFileRun(GeneratorConfig generatorPath) {

        //类名
        String modelName = "Temp";
        //包名
        String packageName = "name.xu.temp";
        //输出文件路径
        String out = Paths.get(generatorPath.getJavaSourcePath(), "pers", "xu", "temp", modelName + ".java").toString();

        CommonJavaFileVelocityInfo commonJavaFileVelocityInfo = new CommonJavaFileVelocityInfo(
                out,
                generatorPath.getVmFilePath("Java.vm"),
                packageName, modelName
        );

        commonJavaFileVelocityInfo.run();
    }
}


