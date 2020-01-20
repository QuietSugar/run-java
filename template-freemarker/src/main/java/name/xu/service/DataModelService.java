package name.xu.service;

import name.xu.entity.DataModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据获取相关
 */
public interface DataModelService {

    int insert(@Param("dataModel") DataModel dataModel);

    List<DataModel> list();

    DataModel findByCode(String code);
}
