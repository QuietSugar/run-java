package pers.xu.service;

import org.apache.ibatis.annotations.Param;
import pers.xu.entity.DataModel;

import java.util.List;

/**
 * 数据获取相关
 */
public interface DataModelService {

    int insert(@Param("dataModel") DataModel dataModel);

    List<DataModel> list();

    DataModel findByCode(String code);
}
