package name.xu.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import name.xu.entity.base.Item;
import name.xu.entity.base.Page;
import name.xu.entity.down.BaseResponse;
import name.xu.tool.HttpUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author Created by HuoXu
 */
public class ShowdocApi {

    private static final String ROOT_URL = "https://www.showdoc.cc/server/index.php?s=";
    private HttpUtil httpUtil;

    public ShowdocApi(String cookie) {
        this.httpUtil = new HttpUtil(cookie);
    }

    /**
     * 总列表
     */
    public BaseResponse<List<Item>> itemList() throws Exception {
        return JSON.parseObject(httpUtil.get(ROOT_URL + "/api/item/myList"), new TypeReference<BaseResponse<List<Item>>>() {
        });
    }

    /**
     * 列表详情
     */
    public BaseResponse<Item> iteminfo(String itemId) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("item_id", itemId);
        String response = httpUtil.post(ROOT_URL + "/api/item/info", map);
        return JSON.parseObject(response, new TypeReference<BaseResponse<Item>>() {
        });
    }


    /**
     * 列表详情
     */
    public BaseResponse<Page> pageInfo(String pageId) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("page_id", pageId);
        return JSON.parseObject(httpUtil.post(ROOT_URL + "/api/page/info", map), new TypeReference<BaseResponse<Page>>() {
        });
    }

}
