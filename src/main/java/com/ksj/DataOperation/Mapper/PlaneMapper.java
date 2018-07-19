package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlaneMapper {

    @Select("SELECT * FROM plane WHERE factory_id = #{factoryId} LIMIT #{index},#{pageSize}")
    List<Map<String, Object>> getPalne(@Param("factoryId") Integer factoryId,@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("SELECT COUNT(*) AS total FROM plane WHERE factory_id = #{factoryId}")
    Integer getPlanesCount(@Param("factoryId") Integer factoryId);

}
