package name.xu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maybe has infinite possibilities
 *
 * @author Created by Maybe on 2018/3/18
 */
@RestController
@RequestMapping(value = "/server", method = {RequestMethod.POST, RequestMethod.GET})
public class ServerInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerInfoController.class);

    @RequestMapping("/info")
    public String index() {
        return "System is running";
    }

    /**
     * 心跳,返回系统当前时间戳
     */
    @RequestMapping(value = "/heartbeat")
    public Object heartbeat() {
        return System.currentTimeMillis();
    }

    /**
     * 接受到什么就返回什么
     */
    @RequestMapping(value = "/echo")
    public Object echo(@RequestParam("value") Object value) {
        LOGGER.info(value == null ? null : value.toString());
        return value;
    }
}
