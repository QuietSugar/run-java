package name.xu.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import name.xu.entity.DataModel;
import name.xu.entity.TemplateFtl;
import name.xu.service.DataModelService;
import name.xu.service.TemplateFtlService;
import name.xu.utils.FreemarkerUtil;
import org.springframework.stereotype.Service;
import name.xu.service.DataService;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.HashMap;

@Service("dataService")
@Slf4j
public class DataServiceImpl implements DataService {

    @Resource
    DataModelService dataModelService;
    @Resource
    TemplateFtlService templateFtlService;


    @Override
    public String genMarkdown(String tCode, String dCode) {
        DataModel dataModel = dataModelService.findByCode(dCode);
        HashMap map = JSON.parseObject(dataModel.getContent(), HashMap.class);

        TemplateFtl templateFtl = templateFtlService.findByCode(tCode);

        HashMap<String, String> templateList = new HashMap<>();
        templateList.put(templateFtl.getCode(), templateFtl.getContent());


        StringWriter stringWriter = new StringWriter();
        try {
            FreemarkerUtil.process(templateList, templateFtl.getCode(), map, stringWriter);
        } catch (Exception e) {
            log.error("填充模板错误", e);
            return null;
        }
        return stringWriter.toString();
    }
}
