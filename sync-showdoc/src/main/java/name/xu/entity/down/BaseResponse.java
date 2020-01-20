package name.xu.entity.down;

import lombok.Data;

/**
 * @author Created by HuoXu
 */
@Data
public class BaseResponse<T> {
    private int error_code;
    private T data;
}
