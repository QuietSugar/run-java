package name.xu.utils;

/**
 * @author Created by HuoXu
 */

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class FreemarkerUtil {
    /**
     * 通过模板生成
     *
     * @param templatePath 模板的路径
     * @param templateName 模板的名称
     * @param out          输出流
     * @throws Exception 异常
     */
    public static void process(File templatePath, String templateName, Writer out) throws Exception {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(templatePath);
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate(templateName);
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map<String, String> dataModel = new HashMap<>();
        //向数据集中添加数据
        dataModel.put("name", "zhangsan");
        //调用模板对象的process方法输出文件。
        template.process(dataModel, out);
    }


    public static void process(Map<String, String> templateList, String templateName, Object param, Writer out) throws Exception {
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        for (Map.Entry<String, String> entry : templateList.entrySet()) {
            stringLoader.putTemplate(entry.getKey(), entry.getValue());
        }

        Configuration cfg = new Configuration(Configuration.getVersion());
        cfg.setTemplateLoader(stringLoader);
        Template template = cfg.getTemplate(templateName);

        //调用模板对象的process方法输出文件。
        template.process(param, out);
    }
}
