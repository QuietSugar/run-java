package name.xu.mapper;

import name.xu.entity.TemplateFtl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TemplateFtlMapper {

    @Insert("insert into template_ftl(code,name,content) values (#{templateFtl.code},#{templateFtl.name},#{templateFtl.content})")
    @Options(useGeneratedKeys = true, keyProperty = "templateFtl.id", keyColumn = "id")
    int insert(@Param("templateFtl") TemplateFtl templateFtl);

    @Select("select * from template_ftl")
    @Results({
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "content", column = "content"),
    })
    List<TemplateFtl> list();

    @Select("select * from template_ftl where code = #{code}")
    @Results({
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "name"),
            @Result(property = "content", column = "content"),
    })
    TemplateFtl findByCode(String code);
}
