package name.xu.service.impl;

import name.xu.entity.DataModel;
import name.xu.service.DataModelService;
import name.xu.utils.LoadData;
import org.springframework.stereotype.Service;
import name.xu.mapper.DataModelMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("dataModelService")
public class DataModelServiceImpl implements DataModelService {
    @Resource
    DataModelMapper dataModelMapper;

    @Override
    public int insert(DataModel dataModel) {
        return dataModelMapper.insert(dataModel);
    }

    @Override
    public List<DataModel> list() {
        return dataModelMapper.list();
    }

    @Override
    public DataModel findByCode(String code) {
        DataModel dataModel = LoadData.getDataModel(code);
        if (dataModel != null) {
            return dataModel;
        }
        return dataModelMapper.findByCode(code);
    }
}
