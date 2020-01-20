package pers.xu.mybatis;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.xu.utils.VelocityUtil;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Maybe has infinite possibilities
 *
 * MybatisGenerator Xml ConfigVelocityInfo 模板生成
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */
@Data
public class MybatisGeneratorXmlConfigVelocityInfo {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisGeneratorXmlConfigVelocityInfo.class);
    /**
     * 生成的目标路径，应当是一个文件的绝对路径
     */
    private String outputFilePath;
    /**
     * 模板文件的路径
     */
    private String inputVmFilePath;
    /**
     * 表信息的集合
     */
    private List<Map<String, String>> tables;
    /**
     * 生成的源码的包名
     * 类似于  com.maybe.temp.pojo
     */
    private String javaModelPackage;

    /**
     * xml文件的包名（路径）
     */
    private String mapperXMLPackage;
    /**
     * mapper的包名
     */
    private String mapperPackage;
    /**
     * 项目路径
     */
    private String targetProject;

    /**
     * xml文件的路径
     */
    private String sqlMapPath;
    /**
     * 主键相关信息
     */
    private Map<String, String> lastInsertIdTables;

    public MybatisGeneratorXmlConfigVelocityInfo(String outputFilePath, String inputVmFilePath, List<Map<String, String>> tables, String javaModelPackage, String mapperXMLPackage, String mapperPackage, String targetProject, String sqlMapPath, Map<String, String> lastInsertIdTables) {
        this.outputFilePath = outputFilePath;
        this.inputVmFilePath = inputVmFilePath;
        this.tables = tables;
        this.javaModelPackage = javaModelPackage;
        this.mapperXMLPackage = mapperXMLPackage;
        this.mapperPackage = mapperPackage;
        this.targetProject = targetProject;
        this.sqlMapPath = sqlMapPath;
        this.lastInsertIdTables = lastInsertIdTables;
    }

    public void run() {
        LOGGER.info("========== 开始生成generatorConfig.xml文件 ==========");
        //FileUtil.tryDeleteFile(getOutputFilePath());
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("tables", tables);
        parameters.put("generator_javaModelGenerator_targetPackage", javaModelPackage);
        parameters.put("generator_sqlMapGenerator_targetPackage", mapperXMLPackage);
        parameters.put("generator_javaClientGenerator_targetPackage", mapperPackage);
        parameters.put("targetProject", targetProject);
        parameters.put("targetProject_sqlMap", sqlMapPath);
        parameters.put("last_insert_id_tables", lastInsertIdTables);
        try {
            FileWriter writer = new FileWriter(outputFilePath);
            VelocityUtil.gen2File(inputVmFilePath, parameters,writer );

        } catch (Exception e) {
            LOGGER.error("生成出错", e);

        }
        LOGGER.info("========== 结束生成generatorConfig.xml文件 ==========");
    }
}
