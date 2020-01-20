package pers.xu.service.impl;

import org.springframework.stereotype.Service;
import pers.xu.entity.DataModel;
import pers.xu.mapper.DataModelMapper;
import pers.xu.service.DataModelService;
import pers.xu.utils.LoadData;

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
