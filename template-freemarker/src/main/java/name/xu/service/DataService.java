package name.xu.service;

/**
 * 数据获取相关
 */
public interface DataService {
    /**
     * 根据模板code和数据code拼接最终数据
     *
     * @param tCode 模板code
     * @param dCode 数据code
     * @return 最终拼接
     */
    String genMarkdown(String tCode, String dCode);
}
