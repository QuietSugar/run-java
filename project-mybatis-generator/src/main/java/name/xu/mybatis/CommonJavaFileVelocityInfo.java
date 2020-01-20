package name.xu.mybatis;

import lombok.Data;
import name.xu.utils.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.HashMap;

/**
 * Maybe has infinite possibilities
 *
 * 通用Java源文件 模板生成
 * 默认使用以下规则生成
 * 实体类名+模板名+.java
 *
 * 该类会对应多个模板
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */
@Data
public class CommonJavaFileVelocityInfo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonJavaFileVelocityInfo.class);

    /**
     * 生成的目标路径，应当是一个文件的绝对路径
     */
    private String outputFilePath;
    /**
     * 模板文件的路径
     */
    private String inputVmFilePath;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 实体类名
     */
    private String modelName;


    public CommonJavaFileVelocityInfo(String outputFilePath, String inputVmFilePath, String packageName, String modelName) {
        this.outputFilePath = outputFilePath;
        this.inputVmFilePath = inputVmFilePath;
        this.packageName = packageName;
        this.modelName = modelName;
    }

    public void run() {
        LOGGER.info("========== 开始生成JAVA文件 ==========");
        FileUtil.tryDeleteFile(getOutputFilePath());
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("packageName", packageName);
        parameters.put("modelName", modelName);
        try {
            VelocityUtil.gen2File(inputVmFilePath, parameters, new FileWriter(outputFilePath));
        } catch (Exception e) {
            LOGGER.error("生成出错", e);
        }
        LOGGER.info("========== 结束生成JAVA文件 ==========");
    }
}
