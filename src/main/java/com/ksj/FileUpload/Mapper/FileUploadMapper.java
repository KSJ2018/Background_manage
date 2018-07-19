package com.ksj.FileUpload.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FileUploadMapper {

    @Select("SELECT * FROM factory WHERE FactoryId IN (SELECT FactoryId FROM user_factory WHERE UserId = #{UserId})")
    List<Map<String, Object>> getFactorysById(@Param("UserId") Integer id);
}
