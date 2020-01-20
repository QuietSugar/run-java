package pers.xu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.xu.entity.DataModel;

import java.util.List;

@Mapper
public interface DataModelMapper {

    @Insert("insert into data_model(code,name,content) values (#{dataModel.code},#{dataModel.name},#{dataModel.content})")
    @Options(useGeneratedKeys = true, keyProperty = "dataModel.id", keyColumn = "id")
    int insert(@Param("dataModel") DataModel dataModel);

    @Select("select * from data_model")
    @Results({
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "content", column = "content"),
    })
    List<DataModel> list();

    @Select("select * from data_model where code = #{code}")
    @Results({
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "content", column = "content"),
    })
    DataModel findByCode(String code);
}
