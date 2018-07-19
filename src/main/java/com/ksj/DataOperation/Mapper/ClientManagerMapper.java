package com.ksj.DataOperation.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClientManagerMapper {

    @Select("select * from client limit #{index},#{pageSize}")
    List<Map<String,Object>> getClientInfo(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    @Select("select count(*) as total from client")
    Integer getClientCount();

    @Delete("delete from client where id=#{id}")
    Integer deleteClientById(@Param("id") String id);

    @Insert("insert into client(name,phone,salerecord,address,fax,comment)" +
            "values(#{name},#{phone},#{salerecord},#{address},#{fax},#{comment})")
    Integer insertClient(@Param("name") String name,
                         @Param("phone") String phone,
                         @Param("salerecord") String salerecord,
                         @Param("address") String address,
                         @Param("fax") String fax,
                         @Param("comment") String comment);

    @Update("update client set id=#{id}," +
            "name=#{name},phone=#{phone},salerecord=#{salerecord},address=#{address},fax=#{fax},comment=#{comment}" +
            "where id=#{id}")
    Integer modifyClientById(@Param("id") String id,
                             @Param("name") String name,
                             @Param("phone") String phone,
                             @Param("salerecord") String salerecord,
                             @Param("address") String address,
                             @Param("fax") String fax,
                             @Param("comment") String comment);

    @Select("select * from client where name=#{inputName} limit #{index},#{pageSize}")
    Integer getClientInfoByName(@Param("index") Integer index,
                                @Param("pageSize") Integer pageSize,
                                @Param("inputName") String inputName);

}
