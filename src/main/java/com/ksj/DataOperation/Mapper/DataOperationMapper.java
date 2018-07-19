package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataOperationMapper {

    @Select("SELECT * FROM device_type LIMIT #{index},#{pageSize}")
    List<Map<String, Object>> getDeviceType(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("SELECT COUNT(*) AS total FROM device_type")
    Integer getDeviceTypeCount();

    @Delete("DELETE FROM device_type WHERE TypeId = #{TypeId}")
    Integer deleteDeviceTypeByID(@Param("TypeId") String TypeId);

    @Insert("INSERT INTO device_type (TypeName,TypeDBName,TypeDescription,TypeTableName,DBIP) " +
            "VALUES (#{TypeName},#{TypeDBName},#{TypeDescription},#{TypeTableName},#{DBIP})")
    Integer inserDeviceType(@Param("TypeName") String TypeName,
                            @Param("TypeDBName") String TypeDBName,
                            @Param("TypeDescription") String TypeDescription,
                            @Param("TypeTableName") String TypeTableName,
                            @Param("DBIP") String DBIP);



    @Update("UPDATE device_type SET TypeName = #{TypeName}," +
            "TypeDescription = #{TypeDescription},TypeDBName = #{TypeDBName}," +
            "TypeTableName = #{TypeTableName},DBIP = #{DBIP}" +
            "WHERE TypeId = #{TypeId}")
    Integer updateDeviceTypeByID(@Param("TypeId") String TypeId,
                                 @Param("TypeName") String TypeName,
                                 @Param("TypeDescription") String TypeDescription,
                                 @Param("TypeDBName") String TypeDBName,
                                 @Param("TypeTableName") String TypeTableName,
                                 @Param("DBIP") String DBIP);

}
