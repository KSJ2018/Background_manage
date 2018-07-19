package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface FactoryMapper {

    @Select("SELECT * FROM factory LIMIT #{index},#{pageSize}")
    List<Map<String, Object>> getFactory(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("SELECT COUNT(*) AS total FROM factory")
    Integer getFactorysCount();

    @Select("SELECT username FROM s_user WHERE id = (SELECT UserId FROM user_factory WHERE FactoryId = #{factoryId})")
    String getUserNameByFactoryId(@Param("factoryId") String factoryId);

    @Select("SELECT username AS UserName FROM s_user")
    List<Map<String, Object>> getAllUserName();

    @Insert("INSERT INTO factory (FactoryId,FactoryName,BeiZhu) " +
            "VALUES (#{FactoryId},#{FactoryName},#{BeiZhu})")
    Integer insertFactory(@Param("FactoryId") String FactoryId,
                          @Param("FactoryName") String FactoryName,
                          @Param("BeiZhu") String BeiZhu);

    @Insert("INSERT INTO user_factory (UserId,FactoryId) VALUES ((SELECT id FROM s_user WHERE username = #{UserName}),#{FactoryId})")
    Integer insertFactoryWithUser(@Param("UserName") String UserName,
                                  @Param("FactoryId") String FactoryId);

    @Update("UPDATE factory SET FactoryId = #{FactoryId},FactoryName = #{FactoryName},BeiZhu = #{BeiZhu} WHERE id = #{id}")
    Integer updateFactory(@Param("id") Integer id,
                          @Param("FactoryId") String FactoryId,
                          @Param("FactoryName") String FactoryName,
                          @Param("BeiZhu") String BeiZhu);

    @Update("UPDATE user_factory SET UserId = (SELECT id FROM s_user WHERE username = #{UserName}),FactoryId = #{FactoryId} " +
            "WHERE FactoryId = (SELECT FactoryId FROM factory WHERE id = #{id})")
    Integer updateFactoryWithUser(@Param("id") Integer id,
                                  @Param("FactoryId") String FactoryId,
                                  @Param("UserName") String UserName);

    @Delete("DELETE FROM factory WHERE id = #{id}")
    Integer deleteFactory(@Param("id") Integer id);

    @Delete("DELETE FROM user_factory WHERE FactoryId = #{FactoryId} AND UserId = (SELECT id FROM s_user WHERE username = #{UserName})")
    Integer deleteFactoryWithUser(@Param("FactoryId") String FactoryId,
                                  @Param("UserName") String UserName);
}
