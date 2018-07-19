package com.ksj.ResourceManage.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResourceManageMapper {

    @Select("SELECT * FROM resource_manage")
    List<Map<String, Object>> getAllResources();

}
