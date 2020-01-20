package pers.xu.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Maybe has infinite possibilities
 *
 * @author Created by HuoXu <2542610526@qq.com> on 2019/2/1
 */
public class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * @param filePath 文件路径
     */
    public static void tryDeleteFile(String filePath) {

        //尝试删除已存在的文件
        File file = new File(filePath);
        if (file.exists()) {
            boolean delete = file.delete();
            if (delete) {
                LOGGER.debug("删除成功，文件：{}", file.getName());
            } else {
                LOGGER.debug("删除失败，文件：{}", file.getName());
            }
        }
    }
}
