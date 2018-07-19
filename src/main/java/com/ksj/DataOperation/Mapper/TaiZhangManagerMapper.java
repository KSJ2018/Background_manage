package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaiZhangManagerMapper {
    @Select("select * from taizhang where status=1  limit #{index},#{pageSize}")
    List<Map<String,Object>> getTaiZhangInfo(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("select count(*) as total from taizhang where status=1")
    Integer getTaiZhangCount();


    /*@Delete("delete from taizhang where id=#{id}")
    Integer deletTaiZhangById(@Param("id") String id);*/
    //删除操作只是不在前端页面展示，后台数据库任然存在，只是status由1变为0；
    @Update("update taizhang set status=0 where id=#{id}")
    Integer deletTaiZhangById(@Param("id") String id);

    @Insert("insert into taizhang(equipment_user,equipment_name,equipment_type,product_date,control_type," +
            "responsible,protect_cycle,equipment_vendor,current_state,status,comment)" +
            "values(#{equipment_user},#{equipment_name},#{equipment_type},#{product_date},#{control_type},#{responsible}," +
            "#{protect_cycle},#{equipment_vendor},#{current_state},1,#{comment})")
    Integer insertTaiZhang(@Param("equipment_user") String equipment_user,
                           @Param("equipment_name") String equipment_name,
                           @Param("equipment_type") String equipment_type,
                           @Param("product_date") String product_date,
                           @Param("control_type") String control_type,
                           @Param("responsible") String responsible,
                           @Param("protect_cycle") String protect_cycle,
                           @Param("equipment_vendor") String equipment_vendor,
                           @Param("current_state") String current_state,
                           @Param("comment") String comment
    );
    @Update("update taizhang set id=#{id}," +
            "equipment_user=#{equipment_user},equipment_name=#{equipment_name},equipment_type=#{equipment_type}," +
            "product_date=#{product_date},control_type=#{control_type},responsible=#{responsible}," +
            "protect_cycle=#{protect_cycle},equipment_vendor=#{equipment_vendor},current_state=#{current_state},comment=#{comment}" +
            "where id=#{id}")
            Integer modifyTaiZhangById(@Param("id") String id,
                                       @Param("equipment_user") String equipment_user,
                                       @Param("equipment_name") String equipment_name,
                                       @Param("equipment_type") String equipment_type,
                                       @Param("product_date") String product_date,
                                       @Param("control_type") String control_type,
                                       @Param("responsible") String responsible,
                                       @Param("protect_cycle") String protect_cycle,
                                       @Param("equipment_vendor") String equipment_vendor,
                                       @Param("current_state") String current_state,
                                       @Param("comment") String comment);

}
