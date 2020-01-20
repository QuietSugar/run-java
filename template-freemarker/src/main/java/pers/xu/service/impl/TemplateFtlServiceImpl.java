package pers.xu.service.impl;

import org.springframework.stereotype.Service;
import pers.xu.entity.TemplateFtl;
import pers.xu.mapper.TemplateFtlMapper;
import pers.xu.service.TemplateFtlService;
import pers.xu.utils.LoadData;

import javax.annotation.Resource;
import java.util.List;

@Service("templateFtlService")
public class TemplateFtlServiceImpl implements TemplateFtlService {
    @Resource
    TemplateFtlMapper templateFtlMapper;

    @Override
    public int insert(TemplateFtl templateFtl) {
        return templateFtlMapper.insert(templateFtl);
    }

    @Override
    public List<TemplateFtl> list() {
        return templateFtlMapper.list();
    }

    @Override
    public TemplateFtl findByCode(String code) {
        TemplateFtl templateFtl = LoadData.getTemplateFtl(code);
        if (templateFtl != null) {
            return templateFtl;
        }
        return templateFtlMapper.findByCode(code);
    }
}
