package name.xu.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import name.xu.service.DataService;

/**
 * 页面导航
 *
 * @author huoxu
 */
@Controller
@RequestMapping("/html")
@Slf4j
public class HtmlController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/markdown")
    public String showByCode(
            @RequestParam(value = "tCode") String tCode,
            @RequestParam(value = "dCode") String dCode,
            Model model
    ) {
        String markdown = dataService.genMarkdown(tCode, dCode);
        if (markdown == null) {
            return "/404";
        } else {
            model.addAttribute("markdown", markdown);
            return "/markdownShow";
        }
    }
}
