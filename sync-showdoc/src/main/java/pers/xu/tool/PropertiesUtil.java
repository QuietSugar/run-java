package pers.xu.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Created by HuoXu
 */
public class PropertiesUtil {
    /**
     * 以Properties的形式读取
     */
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    /**
     * 优先读取和jar同级目录的配置文件
     * 读不到就读取jar内部
     */
    public static Properties loadProperties(String fileName) throws Exception {
        String jarWholePath = PropertiesUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        jarWholePath = java.net.URLDecoder.decode(jarWholePath, "UTF-8");

        String jarPath = new File(jarWholePath).getParentFile().getAbsolutePath();

        File file = new File(jarPath + File.separator + fileName);
        Properties properties = new Properties();
        InputStream inputStream;
        if (file.exists()) {
            logger.info("配置文件路径: {}", file.getAbsolutePath());
            inputStream = new FileInputStream(file);
        } else {
            logger.warn("jar 外部配置文件:{} 不存在,读取jar的 classpath 配置文件:", file.getAbsolutePath());
            inputStream = PropertiesUtil.class.getResourceAsStream("/" + fileName);
        }
        properties.load(inputStream);
        return properties;
    }
}
