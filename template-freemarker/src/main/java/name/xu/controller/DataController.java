package name.xu.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import name.xu.service.DataService;

/**
 * 单纯的请求数据
 *
 *
 * @author huoxu
 */
@Controller
@RequestMapping("/data")
@Slf4j
@ResponseBody
public class DataController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/markdown")
    public String getDataByCode(@RequestParam(value = "tCode") String tCode,
                                @RequestParam(value = "dCode") String dCode) {
        return dataService.genMarkdown(tCode, dCode);
    }
}
