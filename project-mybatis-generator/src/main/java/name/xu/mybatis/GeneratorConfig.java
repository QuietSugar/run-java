package name.xu.mybatis;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Maybe has infinite possibilities
 *
 * 该类保存了生成过程中的所有的相关路径
 *
 * 有一些是编译后的路径，比如 /target/classes/
 * 还有就是源码路径，src/main/java
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */
@Data
public class GeneratorConfig {

    /**
     * maven工程默认路径
     */
    public final String[] MAVEN_JAVA_SOURCE = {"src", "main", "java"};

    /**
     * vm 模板文件夹的名称
     */
    public final String VM_DIR_NAME = "template";

    /**
     * generatorConfigXml
     * mybatis generator 的配置文件路径
     */
    public final String MYBATIS_XML_CONFIG_NAME = "generatorConfig.xml";

    /**
     * classPath的路径
     * 一般是 " /target/classes/" 结尾(maven工程)
     */
    private static Path CLASS_PATH;

    /**
     * 配置文件
     */
    private Properties properties;

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorUtil.class);

    static {
        try {
            CLASS_PATH = Paths.get(GeneratorUtil.class.getResource("/").toURI());


        } catch (Exception e) {
            LOGGER.error("路径初始化失败", e);
        }

        String classPathStr = CLASS_PATH.toString();
        // 以下路径
        LOGGER.info("classPath的路径：{}", classPathStr);
    }

    public GeneratorConfig(String propertiesName) {
        try {
            properties = new Properties();
            properties.load(GeneratorConfig.class.getResourceAsStream(propertiesName));
            //加载配置文件
            //JDBC 的配置
            JdbcInfo jdbcInfo = new JdbcInfo();
            jdbcInfo.setJdbcDriver(properties.getProperty("generator.jdbc.driver"));
            jdbcInfo.setJdbcUrl(properties.getProperty("generator.jdbc.url"));
            jdbcInfo.setJdbcUsername(properties.getProperty("generator.jdbc.username"));
            jdbcInfo.setJdbcPassword(properties.getProperty("generator.jdbc.password"));

            this.jdbcInfo = jdbcInfo;

            //包名相关配置
            this.modelPackage = properties.getProperty("package.model");
            this.daoPackage = properties.getProperty("package.dao");
            //依赖上面
            this.mapperPackage = daoPackage + ".xml";
            this.servicePackage = properties.getProperty("package.service");
            this.serviceImplPackage = servicePackage + ".impl";

            this.servicePath = Paths.get(getJavaSourcePath(), properties.getProperty("package.service.path").split("/")).toString();

            this.databaseName = properties.getProperty("database.name");
            this.databaseTableName = properties.getProperty("database.table.name");
            this.databaseTableKey = properties.getProperty("database.table.key");
            this.databaseTableModel = properties.getProperty("database.table.model");

        } catch (Exception e) {
            LOGGER.error("对象初始化失败", e);
        }
    }

    /**
     * 获取模板文件的路径
     *
     * @param fileName 文件名
     * @return 路径
     */
    public String getVmFilePath(String fileName) {

//        // generatorConfig模板路径
//        String generatorConfig_vm = Paths.get(templateDirPathStr, "generatorConfig.vm").toString();
//        // Service模板路径
//        String service_vm = Paths.get(templateDirPathStr, "Service.vm").toString();
//        // ServiceMock模板路径
//        String serviceMock_vm = Paths.get(templateDirPathStr, "ServiceMock.vm").toString();
//        // ServiceImpl模板路径
//        String serviceImpl_vm = Paths.get(templateDirPathStr, "ServiceImpl.vm").toString();

        return Paths.get( VM_DIR_NAME, fileName).toString();
    }

    /**
     * 项目路径
     *
     * @return 路径
     */
    public String getProjectPath() {
        // Java source path  java源码的路径
        return CLASS_PATH.getParent().getParent().toString();
    }


    public String getJavaSourcePath() {
        // 获取两层父路径,然后进入   "src/main/java"  java 的源码路径
        return Paths.get(getProjectPath(), MAVEN_JAVA_SOURCE).toString();
    }

    /**
     * xml 配置文件的路径
     *
     * @return 路径
     */
    public String getMybatisXmlConfig() {
        return Paths.get(CLASS_PATH.toString(), MYBATIS_XML_CONFIG_NAME).toString();
    }


    /**
     * 输出包名配置
     */
    private String modelPackage;
    private String daoPackage;
    private String mapperPackage;
    private String servicePackage;
    private String serviceImplPackage;


    private String servicePath;

    /**
     * 数据库的表的配置
     * 库名
     */
    private String databaseName;
    /**
     * 表名
     */

    private String databaseTableName;
    /**
     * 表的主键名
     */

    private String databaseTableKey;
    /**
     * 表对应的对象名
     */

    private String databaseTableModel;
    /**
     * 数据库配置
     */
    private JdbcInfo jdbcInfo;

}
