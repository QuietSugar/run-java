package pers.xu.service;

import org.apache.ibatis.annotations.Param;
import pers.xu.entity.TemplateFtl;

import java.util.List;

public interface TemplateFtlService {

    int insert(@Param("templateFtl") TemplateFtl templateFtl);

    List<TemplateFtl> list();

    TemplateFtl findByCode(String code);
}
