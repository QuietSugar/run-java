package name.xu.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author Created by HuoXu
 */
public class VelocityUtil {
    /**
     * Velocity 生成
     * 输出到文件
     *
     * @param name       模板
     * @param parameters 参数
     */
    public static void gen2File(String name, Map<String, Object> parameters, FileWriter writer) throws IOException {
        // 初始化模板引擎
        VelocityEngine velocityEngine = new VelocityEngine();
        //设置 Properties 配置文件
        Properties properties = new Properties();
        //System.Environment.CurrentDirectory

        String path = VelocityUtil.class.getResource("/").toString().replaceAll("^file:/", "");
        properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, path);
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        velocityEngine.init(properties);

        // 获取模板文件
        Template template = velocityEngine.getTemplate(name);
        // 设置变量
        VelocityContext ctx = new VelocityContext();
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            ctx.put(entry.getKey(), entry.getValue());
        }
        template.merge(ctx, writer);
        writer.close();

    }


}
