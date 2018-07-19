package com.ksj.DataOperation.Service;

import com.ksj.Base.Entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface FactoryService {

    List<Map<String,Object>> getFactorys(Integer page, Integer pageSize);

    Integer getFactorysCount();

    String getUserNameByFactoryId(String factoryId);

    List<Map<String,Object>> getAllUserName();

    boolean insertFactoryWithUser(String FactoryId, String FactoryName, String BeiZhu,String UserName) throws IllegalAccessException;

    boolean updataFactoryWithUser(String id,String FactoryId, String FactoryName, String BeiZhu,String UserName) throws IllegalAccessException;
    boolean deleteFactoryWithUser(String id,String FactoryId, String FactoryName, String BeiZhu,String UserName) throws IllegalAccessException;
}
