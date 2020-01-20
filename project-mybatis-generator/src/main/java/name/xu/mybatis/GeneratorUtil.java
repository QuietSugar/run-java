package name.xu.mybatis;


import name.xu.utils.VelocityUtil;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Maybe has infinite possibilities
 *
 * 代码生成工具类
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/1/31
 */
public class GeneratorUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorUtil.class);

    /**
     * 整合其他的自动生成，使用默认配置
     */
    public static void auto() throws Exception {
        //
        //// 调用mybatis生成，会生成4个文件  实体类，实体类Example，Mapper文件，Mapper的xml文件
        //GeneratorUtil.runMybatisGenerator(generatorPath);
        //
        ////模板生成
        //GeneratorUtil.serviceGenerator(generatorPath, tables);
    }


    /**
     * 按照模板生成文件
     */
    public static void serviceGenerator(
            GeneratorConfig generatorPath,
            List<Map<String, String>> tables
    ) throws Exception {


        LOGGER.info("========== 开始生成Service ==========");
        String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());

        String servicePath = generatorPath.getJavaSourcePath();
        for (int i = 0; i < tables.size(); i++) {
            String model = StringUtil.lineToHump(ObjectUtils.toString(tables.get(i).get("table_name")));
            String service = servicePath + "/" + model + "Service.java";
            String serviceMock = servicePath + "/" + model + "ServiceMock.java";
            String serviceImpl = servicePath + "/" + model + "ServiceImpl.java";
            // 生成service
            File serviceFile = new File(service);
            if (!serviceFile.exists()) {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("package_name", generatorPath.getServicePackage());
                parameters.put("model", model);
                parameters.put("ctime", ctime);
                VelocityUtil.gen2File(generatorPath.getVmFilePath("Service.vm"), parameters, new FileWriter(service));
                LOGGER.info(service);
            }
            // 生成serviceMock
            File serviceMockFile = new File(serviceMock);
            if (!serviceMockFile.exists()) {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("package_name", generatorPath.getServicePackage());
                parameters.put("model", model);
                parameters.put("ctime", ctime);
                VelocityUtil.gen2File(generatorPath.getVmFilePath("ServiceMock.vm"), parameters, new FileWriter(serviceMock));
                LOGGER.info(serviceMock);
            }
            // 生成serviceImpl
            File serviceImplFile = new File(serviceImpl);
            if (!serviceImplFile.exists()) {
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("package_name", generatorPath.getServiceImplPackage());
                parameters.put("model", model);
                parameters.put("mapper", StringUtil.toLowerCaseFirstOne(model));
                parameters.put("ctime", ctime);
                VelocityUtil.gen2File(generatorPath.getVmFilePath("ServiceImpl.vm"), parameters, new FileWriter(serviceImpl));
                LOGGER.info(serviceImpl);
            }
        }
        LOGGER.info("========== 结束生成Service ==========");
    }


    // 递归删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        dir.delete();
    }
    // 删除旧代码
//            deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/model"));
//            deleteDir(new File(targetProject + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));
//            deleteDir(new File(targetProjectSqlMap + "/src/main/java/" + packageName.replaceAll("\\.", "/") + "/dao/mapper"));

}
