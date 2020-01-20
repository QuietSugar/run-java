package name.xu.utils;

import lombok.extern.slf4j.Slf4j;
import name.xu.entity.DataModel;
import name.xu.entity.TemplateFtl;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 从项目目录加载数据
 * 优先使用
 *
 * @author Created by HuoXu
 */
@Slf4j
public class LoadData {

    private static final String tempSuffix = ".md.ftl";
    private static final String dataSuffix = ".json";


    private static Map<String, DataModel> dataModelMap = new HashMap<>();
    private static Map<String, TemplateFtl> templateFtlMap = new HashMap<>();

    static {
        try {
            File[] templateFiles = new File(LoadData.class.getResource("/init/template/md").toURI()).listFiles();
            if (templateFiles != null) {
                for (File file : templateFiles) {
                    if (file.getName().endsWith(tempSuffix)) {
                        String name = file.getName().replace(tempSuffix, "");
                        TemplateFtl templateFtl = new TemplateFtl();
                        templateFtl.setCode(name);
                        templateFtl.setName(name);
                        templateFtl.setContent(IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8));
                        templateFtlMap.put(name, templateFtl);
                    }
                }
            }
            File[] dataFiles = new File(LoadData.class.getResource("/init/data").toURI()).listFiles();
            if (dataFiles != null) {
                for (File file : dataFiles) {
                    if (file.getName().endsWith(dataSuffix)) {
                        String name = file.getName().replace(dataSuffix, "");
                        DataModel dataModel = new DataModel();
                        dataModel.setCode(name);
                        dataModel.setName(name);
                        dataModel.setContent(IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8));
                        dataModelMap.put(name, dataModel);
                    }
                }
            }

        } catch (Exception e) {
            log.error("加载失败: {}", e);
        }
        log.info("模板列表: {}", templateFtlMap.keySet().toString());
        log.info("数据列表: {}", dataModelMap.keySet().toString());
    }

    public static DataModel getDataModel(String code) {
        return dataModelMap.get(code);
    }

    public static TemplateFtl getTemplateFtl(String code) {
        return templateFtlMap.get(code);
    }
}
