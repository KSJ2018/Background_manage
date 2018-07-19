package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SaleManagerMapper {

    @Select("select * from sales limit #{index},#{pageSize}")
    List<Map<String,Object>> getSaleInfo(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("select count(*) as total from sales")
    Integer getSaleCount();

    @Delete("delete from sales where id=#{id}")
    Integer deleteSaleById(@Param("id") String id);

    @Insert("insert into sales(client_id,equipment_name,equipment_price,description,note)" +
            "values(#{client_id},#{equipment_name},#{equipment_price},#{description},#{note})")
    Integer insertSale(@Param("client_id") String client_id,
                       @Param("equipment_name") String equipment_name,
                       @Param("equipment_price") String equipment_price,
                       @Param("description") String description,
                       @Param("note") String note);
    @Update("update sales set id=#{id}," +
            "client_id=#{client_id},equipment_name=#{equipment_name},equipment_price=#{equipment_price},description=#{description},note=#{note} " +
            "where id=#{id}")
    Integer modifySaleById(@Param("id") String id,
                           @Param("client_id") String client_id,
                           @Param("equipment_name") String equipment_name,
                           @Param("equipment_price") String equipment_price,
                           @Param("description") String description,
                           @Param("note") String note);
}
