package name.xu.mybatis;

import lombok.Data;

/**
 * jdbc 信息
 *
 * @author Created by HuoXu
 */
@Data
public class JdbcInfo {

    /**
     * 驱动路径
     */
    private String jdbcDriver;
    /**
     * 链接
     */
    private String jdbcUrl;
    /**
     * 帐号
     */
    private String jdbcUsername;
    /**
     * 密码
     */
    private String jdbcPassword;
}
