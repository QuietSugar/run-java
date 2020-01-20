package name.xu.service;

import name.xu.entity.TemplateFtl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateFtlService {

    int insert(@Param("templateFtl") TemplateFtl templateFtl);

    List<TemplateFtl> list();

    TemplateFtl findByCode(String code);
}
