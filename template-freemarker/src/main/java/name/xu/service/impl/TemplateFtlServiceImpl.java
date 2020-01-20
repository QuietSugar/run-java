package name.xu.service.impl;

import name.xu.entity.TemplateFtl;
import name.xu.utils.LoadData;
import org.springframework.stereotype.Service;
import name.xu.mapper.TemplateFtlMapper;
import name.xu.service.TemplateFtlService;

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
