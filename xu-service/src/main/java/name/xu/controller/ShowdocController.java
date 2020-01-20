package name.xu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Showdoc
 *
 * @author Created by HuoXu
 */
@RestController
@RequestMapping(value = "/static/showdoc", method = {RequestMethod.POST, RequestMethod.GET})
public class ShowdocController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowdocController.class);

    /**
     * 主页,获取用户信息,用于判断用户是否登录
     */
    @RequestMapping(value = "/server/index.php")
    public String userInfo(@RequestParam("s") String s) {
        LOGGER.info("请求信息:{}", s);
        if ("/api/user/info".equals(s)) {
            // userInfo    还有参数  redirect_login
            return "{\"error_code\":0,\"data\":{\"uid\":\"145481\",\"username\":\"\\u6216\\u5c0f\\u8bb8\",\"email\":\"2542610526@qq.com\",\"email_verify\":\"1\",\"name\":\"\\u6216\\u5c0f\\u8bb8\",\"avatar\":\"\",\"avatar_small\":\"\",\"groupid\":\"2\",\"reg_time\":\"1561903810\"}}";
        } else if ("/api/item/myList".equals(s)) {
            // 个人主页
            // 获取个人的所有项目
            return "{\"error_code\":0,\"data\":[{\"item_id\":\"406114553416716\",\"uid\":\"145481\",\"item_name\":\"API\\u6587\\u6863\\u793a\\u4f8b\",\"item_domain\":\"\",\"item_type\":\"1\",\"last_update_time\":\"0\",\"item_description\":\"API\\u6587\\u6863\\u793a\\u4f8b\",\"is_del\":\"0\",\"creator\":1},{\"item_id\":\"406114553416717\",\"uid\":\"145481\",\"item_name\":\"\\u6570\\u636e\\u5b57\\u5178\\u793a\\u4f8b\",\"item_domain\":\"\",\"item_type\":\"1\",\"last_update_time\":\"0\",\"item_description\":\"\\u6570\\u636e\\u5b57\\u5178\\u793a\\u4f8b\",\"is_del\":\"0\",\"creator\":1},{\"item_id\":\"406114553416718\",\"uid\":\"145481\",\"item_name\":\"\\u6280\\u672f\\u56e2\\u961f\\u6587\\u6863\\u793a\\u4f8b\",\"item_domain\":\"\",\"item_type\":\"1\",\"last_update_time\":\"0\",\"item_description\":\"\\u6280\\u672f\\u56e2\\u961f\\u6587\\u6863\\u793a\\u4f8b\",\"is_del\":\"0\",\"creator\":1},{\"item_id\":\"407330713491872\",\"uid\":\"145481\",\"item_name\":\"\\u6211\\u7684\\u7b14\\u8bb0\",\"item_domain\":\"\",\"item_type\":\"1\",\"last_update_time\":\"1563076085\",\"item_description\":\"\",\"is_del\":\"0\",\"creator\":1}]}";
        } else if ("/api/item/info".equals(s)) {
            // 点进一个项目进去
            // 获取目录信息
            return "{\"error_code\":0,\"data\":{\"item_id\":\"406114553416716\",\"item_domain\":\"\",\"is_archived\":\"0\",\"item_name\":\"API\\u6587\\u6863\\u793a\\u4f8b\",\"default_page_id\":\"0\",\"default_cat_id2\":0,\"default_cat_id3\":0,\"default_cat_id4\":null,\"unread_count\":\"0\",\"item_type\":1,\"menu\":{\"pages\":[{\"page_id\":\"2365452487532798\",\"author_uid\":\"145481\",\"cat_id\":\"0\",\"page_title\":\"\\u8bf4\\u660e\",\"addtime\":\"1561903810\"},{\"page_id\":\"2365453945969107\",\"author_uid\":\"145481\",\"cat_id\":\"0\",\"page_title\":\"\\u4fee\\u6539\\u8bb0\\u5f55\",\"addtime\":\"1561903810\"},{\"page_id\":\"2365453325054319\",\"author_uid\":\"145481\",\"cat_id\":\"0\",\"page_title\":\"\\u5168\\u5c40\\u9519\\u8bef\\u7801\",\"addtime\":\"1561903810\"}],\"catalogs\":[{\"cat_id\":\"1407503\",\"cat_name\":\"\\u7528\\u6237\\u76f8\\u5173\",\"item_id\":\"406114553416716\",\"s_number\":\"98\",\"addtime\":\"1561903810\",\"parent_cat_id\":\"0\",\"level\":\"2\",\"pages\":[{\"page_id\":\"2365454693220529\",\"author_uid\":\"145481\",\"cat_id\":\"1407503\",\"page_title\":\"\\u7528\\u6237\\u767b\\u5f55\",\"addtime\":\"1561903810\"},{\"page_id\":\"2365454231989297\",\"author_uid\":\"145481\",\"cat_id\":\"1407503\",\"page_title\":\"\\u7528\\u6237\\u6ce8\\u518c\",\"addtime\":\"1561903810\"}],\"catalogs\":[]},{\"cat_id\":\"1407504\",\"cat_name\":\"\\u5730\\u7406\\u76f8\\u5173\",\"item_id\":\"406114553416716\",\"s_number\":\"99\",\"addtime\":\"1561903810\",\"parent_cat_id\":\"0\",\"level\":\"2\",\"pages\":[],\"catalogs\":[{\"cat_id\":\"1407505\",\"cat_name\":\"\\u56fd\\u5185\\u6570\\u636e\",\"item_id\":\"406114553416716\",\"s_number\":\"99\",\"addtime\":\"1561903810\",\"parent_cat_id\":\"1407504\",\"level\":\"3\",\"pages\":[{\"page_id\":\"2365455200135726\",\"author_uid\":\"145481\",\"cat_id\":\"1407505\",\"page_title\":\"\\u7701\\u4efd\\u6570\\u636e\",\"addtime\":\"1561903810\"},{\"page_id\":\"2365455651339995\",\"author_uid\":\"145481\",\"cat_id\":\"1407505\",\"page_title\":\"\\u57ce\\u5e02\\u6570\\u636e\",\"addtime\":\"1561903810\"}],\"catalogs\":[]}]},{\"cat_id\":\"1417491\",\"cat_name\":\"\\u4e00\\u5c42\",\"item_id\":\"406114553416716\",\"s_number\":\"99\",\"addtime\":\"1562121012\",\"parent_cat_id\":\"0\",\"level\":\"2\",\"pages\":[],\"catalogs\":[{\"cat_id\":\"1417492\",\"cat_name\":\"\\u4e8c\\u5c42\",\"item_id\":\"406114553416716\",\"s_number\":\"99\",\"addtime\":\"1562121012\",\"parent_cat_id\":\"1417491\",\"level\":\"3\",\"pages\":[],\"catalogs\":[{\"cat_id\":\"1417493\",\"cat_name\":\"\\u4e09\\u5c42\",\"item_id\":\"406114553416716\",\"s_number\":\"99\",\"addtime\":\"1562121012\",\"parent_cat_id\":\"1417492\",\"level\":\"4\",\"pages\":[{\"page_id\":\"2386269299693008\",\"author_uid\":\"0\",\"cat_id\":\"1417493\",\"page_title\":\"\\u5f00\\u653eAPI\\u6d4b\\u8bd5\",\"addtime\":\"1562121012\"}]}]}]}]},\"is_login\":true,\"ItemPermn\":true,\"ItemCreator\":true}}";
        } else if ("/api/page/info".equals(s)) {
            // 点进一个项目进去
            // 某一个文档的内容
            return "{\"error_code\":0,\"data\":{\"page_id\":\"2365452487532798\",\"author_uid\":\"145481\",\"author_username\":\"\\u6216\\u5c0f\\u8bb8\",\"item_id\":\"406114553416716\",\"cat_id\":\"0\",\"page_title\":\"\\u8bf4\\u660e\",\"page_comments\":\"\",\"page_content\":\"\\u8fd9\\u662f\\u7531\\u7cfb\\u7edf\\u751f\\u6210\\u7684APi\\u6587\\u6863\\u793a\\u4f8b\\u9879\\u76ee\\u3002\\n\\n\\u9664\\u4e86\\u624b\\u52a8\\u7f16\\u8f91\\u6587\\u6863\\u5916\\uff0c\\u4f60\\u8fd8\\u53ef\\u4ee5\\u901a\\u8fc7\\u7a0b\\u5e8f\\u81ea\\u52a8\\u5199\\u5165\\u6587\\u6863\\u3002\\u8be6\\u60c5\\u8bf7\\u53c2\\u8003[\\u81ea\\u52a8\\u751f\\u6210\\u6587\\u6863](https:\\/\\/www.showdoc.cc\\/web\\/#\\/page\\/741656402509783 \\\"\\u8fd9\\u7bc7\\u6587\\u6863\\\")\\u6216\\u8005\\u683c\\u5f0f\\u66f4\\u81ea\\u7531\\u7684[\\u5f00\\u653eAPI](https:\\/\\/www.showdoc.cc\\/web\\/#\\/page\\/102098 \\\"\\u8fd9\\u7bc7\\u6587\\u6863\\\")\",\"s_number\":\"98\",\"is_del\":\"0\",\"addtime\":\"2019-06-30 22:10:10\",\"attachment_count\":\"0\",\"unique_key\":\"\"}}";
        } else {
            LOGGER.info("位未知信息:{}", s);
            return null;
        }
    }
}
