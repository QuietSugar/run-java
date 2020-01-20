package pers.xu.tool;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private String cookie;

    public HttpUtil(String cookie) {
        this.cookie = cookie;
    }

    public String get(String url) throws Exception {
        try (
                CloseableHttpClient httpclient = HttpClients.createDefault()
        ) {
            HttpGet httpget = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpget.setConfig(requestConfig);
            httpget.setHeader("Cookie", cookie);

            logger.debug("请求信息: {}", httpget.getRequestLine());

            // 创建一个 Response 处理器
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            logger.debug("处理结束");
            return responseBody;
        }
    }

    public String post(String url, String content) throws Exception {
        try (
                CloseableHttpClient httpclient = HttpClients.createDefault()
        ) {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost.setConfig(requestConfig);
            try {
                StringEntity entity = new StringEntity(content, StandardCharsets.UTF_8);

                httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
                httpPost.setHeader("Cookie", cookie);


                httpPost.setEntity(entity);
                CloseableHttpResponse response = httpclient.execute(httpPost);
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                if (result.length() > 500) {
                    logger.debug("RESULT: {}", result.substring(0, 500));
                } else {
                    logger.debug("RESULT: {}", result);
                }
                return result;
            } catch (IOException e) {
                logger.error("ERROR: {}", e.getMessage());
            }
            return null;
        }
    }

    /**
     * form 提交
     */

    public String post(String url, Map<String, String> map) {
        logger.debug("POST URL: {}, CONTENT: {}", url, map);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);

        try {
            httpPost.setHeader("Cookie", cookie);

            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            //设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");

            logger.debug("RESULT: {}", result);

            return result;
        } catch (IOException e) {
            logger.error("ERROR: {}", e.getMessage());
        }
        return null;
    }

}
