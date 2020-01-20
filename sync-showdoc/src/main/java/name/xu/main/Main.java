package name.xu.main;

import name.xu.entity.base.Catalog;
import name.xu.entity.base.Item;
import name.xu.entity.base.Page;
import name.xu.tool.PropertiesUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import name.xu.api.ShowdocApi;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

/**
 * @author Created by HuoXu
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String suffix = ".md";

    static ShowdocApi showdocApi;

    static {

        try {
            Properties properties = PropertiesUtil.loadProperties("conf.properties");
            String cookie = properties.getProperty("cookie");
            showdocApi = new ShowdocApi(cookie);
        } catch (Exception e) {
            logger.error("读取配置文件异常: {}", e);
        }
        System.exit(-1);
    }

    public static void main(String[] args) throws Exception {
        List<Item> itemList = showdocApi.itemList().getData();
        for (Item item : itemList) {
            String itemName = "D://data/showdoc" + File.separator + item.getItem_name();
            logger.info("项目: {}", itemName);
            new File(itemName).mkdirs();
            catalogUtil((showdocApi.iteminfo(item.getItem_id()).getData()).getMenu(), itemName);

        }
    }

    public static void catalogUtil(Catalog catalogFirst, String baseDir) throws Exception {

        for (Page page : catalogFirst.getPages()) {
            String pagePath = baseDir + File.separator + page.getPage_title() + suffix;
            logger.info("文档: {}", pagePath);
            IOUtils.write((showdocApi.pageInfo(page.getPage_id()).getData()).getPage_content(),
                    new FileOutputStream(pagePath),
                    StandardCharsets.UTF_8
            );

        }
        List<Catalog> catalogs = catalogFirst.getCatalogs();
        if (catalogs == null) {
            return;
        }
        for (Catalog catalog : catalogs) {
            String dirPath = baseDir + File.separator + catalog.getCat_name();
            new File(dirPath).mkdirs();
            catalogUtil(catalog, dirPath);
        }
    }

}
