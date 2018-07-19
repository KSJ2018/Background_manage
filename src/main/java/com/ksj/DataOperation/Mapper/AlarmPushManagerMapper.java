package com.ksj.DataOperation.Mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface AlarmPushManagerMapper {
    @Select("select * from alerts limit #{index},#{pageSize}")
    List<Map<String,Object>> getAlarmPushInfo(@Param("index") Integer index,
                                              @Param("pageSize") Integer pageSize);
    @Select("select count(*) as total from alerts")
    Integer getAlarmPushCount();

    @Insert("insert into alerts(point,info,type,rank,phone,comment)" +
            "values(#{point},#{info},#{type},#{rank},#{phone},#{comment})")
    Integer insertAlarmPush(@Param("point") String point,
                            @Param("info") String info,
                            @Param("type") String type,
                            @Param("rank") String rank,
                            @Param("phone") String phone,
                            @Param("comment") String comment);

    @Update("update alerts set id=#{id}," +
            "point=#{point},info=#{info},type=#{type},rank=#{rank},phone=#{phone},comment=#{comment}" +
            "where id=#{id} ")
    Integer modifyAlarmPushById(@Param("id") String id,
                                @Param("point") String point,
                                @Param("info") String info,
                                @Param("type") String type,
                                @Param("rank") String rank,
                                @Param("phone") String phone,
                                @Param("comment") String comment
    );
    @Delete("delete from alerts where id=#{id}")
    Integer deleteAlarmPushById(@Param("id") String id);



}
